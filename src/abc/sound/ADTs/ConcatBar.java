package abc.sound.ADTs;

import abc.sound.ClassCodeUsed.SequencePlayer;

/**
 * An immutable data type that implements the Bar interface
 * Represents musical measures as a repeated or non-repeated collection
 * of Bar instances able to represent alternate endings.
 */
public class ConcatBar implements Bar {
    
    private final Bar base;
    private final Bar firstEnding;
    private final Bar secondEnding;
    private final boolean repeat;
    private final int duration;

    // Abstraction function:
    // - Represents complete musical measures as an ordered collection of
    //   Bar instances representing the order in which the music
    //   elements are played
    // - non-repeated collections of measures are represented with the secondEnding
    //   field ignored
    // - repeated collections of measures with no alternate endings have firstEnding
    //   and secondEnding pointing to the same barObject
    // - repeated collections of measures with alternate endings are represented by
    //   the fields firstEnding and secondEnding
    //
    // Representation invariant:
    // - duration >= 0
    //
    // Safety from representation exposure:
    // - all fields are private and final
    // - only immutable objects are ever returned

    /**
     * Constructor for ConcatBar without alternate endings
     * @param left first Bar element in order of music
     * @param right second Bar element in order of music
     * @param repeat whether or not this ConcatBar is repeated
     */
    public ConcatBar(Bar left, Bar right, boolean repeat) {
        this(left,right,right,repeat);
    }

    /**
     * Constructor for ConcatBar with alternate endings
     * @param left first Bar element in order of music
     * @param right second Bar element representing first ending
     * @param secondEnding Bar element representing second ending
     * @param repeat whether or not the music represented by ConcatBar is repeated;
     *    if not, only the first ending is considered
     */
    public ConcatBar(Bar base, Bar firstEnding, Bar secondEnding, boolean repeat) {
        this.base = base;
        this.firstEnding = firstEnding;
        this.secondEnding = secondEnding;
        this.repeat = repeat;
        if (this.repeat) {
            this.duration = this.base.duration()*2 + this.firstEnding.duration() + this.secondEnding.duration();
        } else {
            this.duration = this.base.duration() + this.firstEnding.duration();
        }
    }

    /**
     * Makes sure the representation invariant is obeyed
     */
    private void checkRep() {
        assert(this.duration >= 0);
    }

    @Override
    public int duration() {
        checkRep();
        return this.duration;
    }

    @Override
    public Bar transpose(int semitonesUp) {
        checkRep();
        return new ConcatBar(this.base.transpose(semitonesUp), this.firstEnding.transpose(semitonesUp),
                this.secondEnding.transpose(semitonesUp), this.repeat);
    }

    @Override
    public void play(SequencePlayer player, int atTick) {
        if (repeat) {
            this.base.play(player, atTick);
            this.firstEnding.play(player, atTick + this.base.duration());
            this.base.play(player, atTick + this.base.duration() + this.firstEnding.duration());
            this.secondEnding.play(player, atTick + (this.base.duration()*2) + this.firstEnding.duration());
        } else {
            this.base.play(player, atTick);
            this.firstEnding.play(player, atTick + this.base.duration());
        }
    }

    @Override
    public String toString(){
        return "( " + this.base.toString() +
                "1: " + this.firstEnding.toString() +
                "2: " + this.secondEnding.toString() +
                "repeated: " + this.repeat + " )";
    }

    /**
     * Compares different ConcatBar objects for having the same repeats,
     * same bases, same first endings, and same second endings if repeated
     * @param thatObject object to be compare to
     */
    @Override
    public boolean equals(Object thatObject){
        if (!(thatObject instanceof ConcatBar)) { return false; }
        ConcatBar that = (ConcatBar) thatObject;
        if (this.repeat != that.repeat) { return false; }
        if (!this.base.equals(that.base) || !this.firstEnding.equals(that.firstEnding)) {
            return false;
        } else if (this.repeat && !this.secondEnding.equals(that.secondEnding)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash += this.base.hashCode() + this.firstEnding.hashCode();
        if (repeat) {
            hash += this.secondEnding.hashCode();
        }
        return hash;
    }
}