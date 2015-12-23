package abc.sound.ADTs;

import abc.sound.ClassCodeUsed.SequencePlayer;

/**
 * An immutable data type representing information about the music
 * of an abc file
 */
public interface Bar {
    
    // Datatype definition
    //   Element = Note(duration:int, pitch:Pitch, sound:Boolean) + ConcatElement(left:Element, right:Element)
    //   Bar = Measure(listOfElements:List<Element>) + ConcatBar(left:Bar,right:Bar,repeat:boolean)
    //   Voice = List<Bar>
    
    /**
     * Get the duration of this Measure in ticks
     * @return duration of this Measure in ticks
     */
    public int duration();
    
    /**
     * Transpose all notes upward or downward in pitch, maintaining
     * all other properties of the Measure
     * @param semitonesUp semitones by which to transpose
     * @return Bar the transposed Bar
     */
    public Bar transpose(int semitonesUp);
    
    /**
     * Play this bar, starting at atTick
     * @param player The SequencePlayer to play on
     * @param atTick The tick when the element is played,
     *      must be >= 0
     */
    public void play(SequencePlayer player, int atTick);
      
}