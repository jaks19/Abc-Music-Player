package abc.sound.ADTs;

import abc.sound.ClassCodeUsed.Pitch;
import abc.sound.ClassCodeUsed.SequencePlayer;

/**
 * An Immutable data type that implements the Element interface
 * Represents a musical note or rest that lasts for bounded time 
 */
public class Note implements Element {
    private final int startTick;
    private final int duration;
    private final Pitch pitch;
    private final boolean sound;

    // Abstraction function:
    // - Represents a musical note as an Object having a pitch, startTick and duration
    // - The Note plays at the startTick for a time period: duration
    // - The Pitch of the Note dictates the frequency of the note
    // - When sound is true it means when this note is played it produces a sound
    //      but when it is false, it means this is actually a rest
    //
    // Representation invariant:
    // - duration >= 0
    // - startTick >= 0
    //
    // Safety from representation exposure:
    // - Fields startTick, duration, pitch and sound are private and final
    // - Returned types are immutable: integer, element, String, Boolean, Pitch

    /**
     * Create a Note played for a specific number of ticks
     * @param pitch Pitch of the Note
     * @param startTick Tick at which to start playing this Note, must be >= 0
     * @param duration Duration in ticks to play the Note, must be > 0
     * 
     */
    public Note(Pitch pitch, int startTick, int duration) {
        this.startTick = startTick;
        this.duration = duration;
        this.pitch = pitch;
        this.sound = true;
        //checkRep();
    }

    /**
     * Create a rest (Note with no sound) that lasts for a specific number of ticks
     * @param startTick Tick at which to start the rest, must be >= 0
     * @param duration Duration in ticks that the rest lasts, must be > 0
     */
    public Note(int startTick, int duration) {
        this.startTick = startTick;
        this.duration = duration;
        this.pitch = new Pitch('A');
        this.sound = false;
        //checkRep();
    }

    /**
     * Makes sure the representation invariant is obeyed
     */
    private void checkRep() {
        assert this.duration() >= 0;
        assert this.start() >= 0;
    }

    @Override
    public Element transpose(int semitonesUp) {
        if (sound == true){
            //checkRep();
            return new Note(this.pitch().transpose(semitonesUp), this.start(), this.duration());
        }
        else {
            //checkRep();
            return new Note(this.start(), this.duration());}
    }

    @Override
    public int duration() {
        return duration;
    }

    @Override
    public void play(SequencePlayer player, int atTick) {
        if (sound == true){
            player.addNote(this.pitch().toMidiNote(), 
                    this.start()+atTick, 
                    this.duration());
        }
    }

    @Override
    public int start() {
        return this.startTick;
    }

    @Override
    public int hashCode() {
        if (this.sound() == true){
            checkRep();
            return (this.duration() 
                    * this.pitch().hashCode()
                    * this.start() + 1);
        }
        else{
            checkRep();
            return (this.duration() 
                    * this.start() + 1);
        }
    }

    @Override
    public boolean equals(Object thatObject) {
        if (!(thatObject instanceof Note)) {return false;}
        Note thatNote = (Note) thatObject;
        if (this.sound() == true && thatNote.sound() == true){
            //checkRep();
            return (this.start() == thatNote.start()
                    && this.pitch().equals(thatNote.pitch())
                    && this.duration() == thatNote.duration());
        }
        else if (this.sound() == false && thatNote.sound() == false){
            //checkRep();
            return (this.start() == thatNote.start()
                    && this.duration() == thatNote.duration());
        }
        else {return false;}
    }

    @Override
    public String toString() {
        //checkRep();
        return "P:" + this.pitch.toString() + " "
        + "S:" + this.start() + " "
        + "D:" + this.duration() + "| ";
    }

    /**
     * @return pitch of this note
     */
    public Pitch pitch() {
        //checkRep();
        return pitch;
    }

    /**
     * @return true if it is a Note producing sound, false if a rest
     */
    public boolean sound() {
        //checkRep();
        return this.sound;
    }
}