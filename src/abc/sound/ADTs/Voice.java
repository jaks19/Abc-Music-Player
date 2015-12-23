package abc.sound.ADTs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import abc.sound.ClassCodeUsed.SequencePlayer;

/**
 * An immutable data type representing information about the music
 * of an abc file
 */

public class Voice {
    private final List<Bar> voices;
    // Datatype definition
    //   Element = Note(duration:int, pitch:Pitch, sound:Boolean) + ConcatElement(left:Element, right:Element)
    //   Bar = Measure(listOfElements:List<Element>) + ConcatBar(left:Bar,right:Bar,repeat:boolean)
    //   Voice = List<Bar>
    
    //Abstraction Function:
    // Takes a list of bars and maps this to a voice that plays multiple complete musical parts.
    //Representation Invariant:
    //-voices.size()>0
    //Representation Exposure:
    //- No representation exposure since there is defensive copying in the constructor and every
    //-other method outputs primitives.

    /**
     * Creates a piece of music composed of multiple voices.
     * @param voices list of bars that cannot be empty.
     */
    public Voice(List<Bar> voices){
        List<Bar> temp= new ArrayList<>();
        temp.addAll(voices);
        this.voices=temp;
    }
    private void checkRep(){
        assert voices.size()>0;
    }

    /**
     * Get the duration of this piece in ticks
     * @return int total duration of this piece in ticks
     */
    public int duration(){
        int maxLength=voices.get(0).duration();
        for(Bar bar:voices){
            if (bar.duration()>=maxLength){
                maxLength=bar.duration();
            }
        }
        checkRep();
        return maxLength;
    }

    /**
     * Transpose all notes upward or downward in pitch
     * @param semitonesUp semitones by which to transpose
     * @return Voice the transposed Voice
     */
    public Voice transpose(int semitonesUp){
        List<Bar> temp= new ArrayList<>();
        for(Bar bar:voices){
            temp.add(bar.transpose(semitonesUp));
        }
        checkRep();
        return new Voice(temp);
    }

    /**
     * Play this piece.
     * @param player player to play on
     * @param atBeat when to play
     */
    public void play(SequencePlayer player, int atTick){
        for(Bar bar:voices){
            bar.play(player, atTick);
        }
        checkRep();
    }

    @Override
    public String toString(){
        String temp="";
        for(Bar bar:voices){
            temp=temp+bar.toString();
        }
        checkRep();
        return temp;
    }
    /**
     * Checks for musical equality.
     * @param thatObject
     */
    @Override
    public boolean equals(Object thatObject){
        if(!(thatObject instanceof Voice)) return false;
        Voice thatVoiceObject= (Voice)thatObject;
        Set<Bar> temp1= new HashSet<Bar>();
        Set<Bar> temp2= new HashSet<Bar>();
        Set<Bar> temp3=new HashSet<Bar>();
        Set<Bar> temp4=new HashSet<Bar>();
        int counter=0;
        if (thatVoiceObject.duration()!=this.duration()){
            checkRep();
            return false;
        }
        else{
            temp3.addAll(this.voices);
            temp4.addAll(thatVoiceObject.voices);
            temp1.addAll(this.voices);
            temp2.addAll(thatVoiceObject.voices);
            if (temp1.size()>=temp2.size()){
                temp1.removeAll(temp2);
                temp4.removeAll(temp3);
                Iterator<Bar> iterator=temp1.iterator();
                while (iterator.hasNext()){
                    Bar iteratorBar= iterator.next();
                    if (iteratorBar.transpose(1).equals(iteratorBar)){
                        counter++;
                    }
                }
                if (counter==temp1.size()){
                    counter=0;
                    Iterator<Bar> iterator4=temp4.iterator();
                    while(iterator4.hasNext()){
                        Bar iteratorBar=iterator4.next();
                        if (iteratorBar.transpose(1).equals(iteratorBar)){
                            counter++;
                        }
                    }
                    if (counter==temp4.size()){
                        checkRep();
                        return true;
                    }
                    else{
                        checkRep();
                        return false;
                    }
                }
                else{
                    checkRep();
                    return false;
                }
            }
            else{
                temp2.removeAll(temp1);
                temp3.removeAll(temp4);
                Iterator<Bar> iterator=temp2.iterator();
                while (iterator.hasNext()){
                    Bar iteratorBar= iterator.next();
                    if(iteratorBar.transpose(1).equals(iteratorBar)){
                        counter++;
                    }
                }
                if(counter==temp2.size()){
                    counter=0;
                    Iterator<Bar> iterator3=temp3.iterator();
                    while(iterator3.hasNext()){
                        Bar iteratorBar=iterator3.next();
                        if(iteratorBar.transpose(1).equals(iteratorBar)){
                            counter++;
                        } 
                    }
                    if(counter==temp3.size()){
                        checkRep();
                        return true;
                    }
                    else{
                        checkRep();
                        return false;
                    }
                }
                else{
                    checkRep();
                    return false;
                }   
            }   
        }
    }

    @Override
    public int hashCode(){
        int counter=0;
        for(Bar bar:voices){
            counter=counter+bar.hashCode();
            System.out.println(bar.hashCode());
        }
        checkRep();
        return counter;
    }
}