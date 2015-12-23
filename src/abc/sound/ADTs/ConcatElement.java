package abc.sound.ADTs;

import abc.sound.ClassCodeUsed.SequencePlayer;

/**
 * An Immutable data type that implements the Element interface
 * Represents a combination of notes or groups of notes found inside a measure
 *      in a given abc music sheet
 */
public class ConcatElement implements Element {
    private final Element left;
    private final Element right;

    // Abstraction function:
    // - Represents a Combination of 2 musical elements of which each can be:
    //          a Note or another Combination of 2 musical elements
    //          left: the musical Element played first
    //          right: the musical Element played second
    // - The ConcatElement plays at the startTick of the leftmost Note
    //
    // Representation invariant:
    // - left starts before right (tuplet) or at the same time (chord)
    //
    // Safety from representation exposure:
    // - Fields left, right are private and final
    // - Returned types are immutable: integer, element, String, Boolean

    /**
     * Creates a new ConcatElement object
     * @param first The first Element to concatenate
     * @param second The second Element to concatenate
     */
    public ConcatElement(Element first, Element second){
        this.left = first;
        this.right = second;
        checkRep();
    }

    /**
     * Makes sure the representation invariant is obeyed
     */
    private void checkRep() {
        assert left.start() <= right.start();
    }

    @Override
    public int duration() {
        if (!(left.start() == right.start())){
            checkRep();
            return left.duration() + right.duration();
        }
        else{
            checkRep();
            return left.duration();}
    }

    @Override
    public Element transpose(int semitonesUp) {
        checkRep();
        return new ConcatElement(left.transpose(semitonesUp), right.transpose(semitonesUp));
    }

    @Override
    public void play(SequencePlayer player, int atTick) {
        left.play(player, atTick);
        right.play(player, atTick);
        checkRep();
    }

    @Override
    public int start(){
        checkRep();
        return left.start();
    }

    @Override
    public String toString(){
        checkRep();
        return left.toString() + right.toString();
    }

    @Override
    public boolean equals(Object thatObject){
        if (!(thatObject instanceof ConcatElement)) return false;
        ConcatElement thatConcatElement = (ConcatElement) thatObject;
        checkRep();
        return (this.left.equals(thatConcatElement.left) 
                && this.right.equals(thatConcatElement.right));
    }

    @Override
    public int hashCode(){
        checkRep();
        return left.hashCode() + right.hashCode();
    }
}