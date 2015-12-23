package abc.sound.ADTs;

import abc.sound.ClassCodeUsed.SequencePlayer;

/**
 * An immutable data type representing musical notes, rests and their groupings
 * from an abc file
 */
public interface Element {
    /* Data Type definition
     * Element = Note(duration:int, pitch:Pitch, sound:Boolean) + ConcatElement(left:Element, right:Element)
     * 
     * Super Data Types:
     * Bar = Measure(listOfElements:List<Element>) + ConcatBar(left:Bar,right:Bar,repeat:boolean)
     * Voice = List<Bar>
     */

    /**
     * Get the duration of this Element in ticks
     * @return int duration of this Element in ticks
     */
    public int duration();

    /**
     * Transpose upward or downward in pitch
     * @param semitonesUp Semitones by which to transpose the Element
     * @return int a new Element transposed by the required semitones
     */
    public Element transpose(int semitonesUp);

    /**
     * Play this element
     * @param player The SequencePlayer to play on
     * @param atTick The tick when the element is played
     *      must be >= 0
     */
    public void play(SequencePlayer player, int atTick);

    /**
     * Fetch the tick at which this Element starts
     * @return int the starting tick
     */
    public int start();
}