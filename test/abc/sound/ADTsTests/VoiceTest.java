package abc.sound.ADTsTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

import abc.sound.ADTs.Bar;
import abc.sound.ADTs.Element;
import abc.sound.ADTs.Measure;
import abc.sound.ADTs.Note;
import abc.sound.ADTs.Voice;
import abc.sound.ClassCodeUsed.Pitch;

public class VoiceTest {
    // Test partitions:
    // public int duration()
    //-List of Bars with one longest bar, two equally longest bars, rest longest bar,empty list of bars
    //Voice transpose(int semitonesUp)
    //-Bar with no rests-0 semitonesUp, 1 semitone up, n-semitonesUp
    //-Bar with some rests-0 semitonesUp, 1 semitone up, n-semitonesUp
    //-Bar with all rests-0 semitoneUp,1 semitone up,n-semitonesup

    //boolean equals(Object thatObject)
    //-Different duration voices, same duration but different bars, same bars with arbitrary number of rests

    //int hashCode()
    //-Different duration voices, same duration but different bars, same bars with arbitrary number of rests

    @Test
    public void testDurationOneLongestBar(){
        Note note= new Note(new Pitch('A'),0,10);
        Note note2=new Note(new Pitch('B'),0,25);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        Measure measure1=new Measure(temp1);
        Measure measure2=new Measure(temp2);
        List<Bar> bar1=new ArrayList<Bar>();
        bar1.add(measure1);
        bar1.add(measure2);
        Voice voice=new Voice(bar1);
        assertEquals(25,voice.duration()); 
    }
    @Test
    public void testDurationTwoEquallyLongestBars(){
        Note note= new Note(new Pitch('A'),0,25);
        Note note2=new Note(new Pitch('B'),0,25);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        Measure measure1=new Measure(temp1);
        Measure measure2=new Measure(temp2);
        List<Bar> bar1=new ArrayList<Bar>();
        bar1.add(measure1);
        bar1.add(measure2);
        Voice voice=new Voice(bar1);
        assertEquals(25,voice.duration()); 
    }
    @Test
    public void testRestLongestBar(){
        Note note= new Note(0,25);
        Note note2=new Note(new Pitch('B'),0,20);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        Measure measure1=new Measure(temp1);
        Measure measure2=new Measure(temp2);
        List<Bar> bar1=new ArrayList<Bar>();
        bar1.add(measure1);
        bar1.add(measure2);
        Voice voice=new Voice(bar1);
        assertEquals(25,voice.duration()); 
    }

    //========================================================================================================================
    @Test
    public void testTranposeBarWithNoRestZeroTones(){
        Note note= new Note(new Pitch('A'),0,10);
        List<Element> temp1=new ArrayList<Element>();
        temp1.add(note);
        Measure measure= new Measure(temp1);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        Voice voice= new Voice(bar);

        Note note2= new Note(new Pitch('A'),0,10);
        List<Element> temp2=new ArrayList<Element>();
        temp2.add(note2);
        Measure measure2= new Measure(temp2);
        List<Bar> bar2= new ArrayList<Bar>();
        bar2.add(measure2);
        Voice voice2= new Voice(bar2);

        assertEquals(voice2,voice.transpose(0));

    }
    @Test
    public void testTranposeBarWithNoRestOneTones(){
        Note note= new Note(new Pitch('A'),0,10);
        List<Element> temp1=new ArrayList<Element>();
        temp1.add(note);
        Measure measure= new Measure(temp1);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        Voice voice= new Voice(bar);

        Note note2= new Note(new Pitch('A').transpose(1),0,10);
        List<Element> temp2=new ArrayList<Element>();
        temp2.add(note2);
        Measure measure2= new Measure(temp2);
        List<Bar> bar2= new ArrayList<Bar>();
        bar2.add(measure2);
        Voice voice2= new Voice(bar2);
        assertEquals(voice2,voice.transpose(1));
    }
    @Test
    public void testTranposeBarWithNoRestThreeTones(){
        Note note= new Note(new Pitch('A'),0,10);
        List<Element> temp1=new ArrayList<Element>();
        temp1.add(note);
        Measure measure= new Measure(temp1);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        Voice voice= new Voice(bar);

        Note note2= new Note(new Pitch('A').transpose(3),0,10);
        List<Element> temp2=new ArrayList<Element>();
        temp2.add(note2);
        Measure measure2= new Measure(temp2);
        List<Bar> bar2= new ArrayList<Bar>();
        bar2.add(measure2);
        Voice voice2= new Voice(bar2);

        assertEquals(voice2,voice.transpose(3));
    }
    @Test
    public void testTranposeSomeRestsZeroTones(){
        Note note= new Note(new Pitch('A'),0,10);
        Note note2= new Note(0,5);
        Note note3= new Note(0,7);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2= new ArrayList<Element>();
        List<Element> temp3=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        temp3.add(note3);
        Measure measure= new Measure(temp1);
        Measure measure2=new Measure(temp2);
        Measure measure3=new Measure(temp3);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        bar.add(measure2);
        bar.add(measure3);
        Voice voice= new Voice(bar);
        
        Note knote= new Note(new Pitch('A').transpose(1),0,10);
        Note knote2= new Note(0,5);
        Note knote3= new Note(0,7);
        List<Element> ktemp1= new ArrayList<Element>();
        List<Element> ktemp2= new ArrayList<Element>();
        List<Element> ktemp3=new ArrayList<Element>();
        ktemp1.add(knote);
        ktemp2.add(knote2);
        ktemp3.add(knote3);
        Measure kmeasure= new Measure(ktemp1);
        Measure kmeasure2=new Measure(ktemp2);
        Measure kmeasure3=new Measure(ktemp3);
        List<Bar> kbar= new ArrayList<Bar>();
        kbar.add(kmeasure);
        kbar.add(kmeasure2);
        kbar.add(kmeasure3);
        Voice kvoice= new Voice(kbar);
        
        assertEquals(kvoice,voice.transpose(1));
        
    }
    @Test
    public void testTranposeSomeRestsOneTone(){
        Note note= new Note(new Pitch('A'),0,10);
        Note note2= new Note(0,5);
        Note note3= new Note(0,7);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2= new ArrayList<Element>();
        List<Element> temp3=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        temp3.add(note3);
        Measure measure= new Measure(temp1);
        Measure measure2=new Measure(temp2);
        Measure measure3=new Measure(temp3);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        bar.add(measure2);
        bar.add(measure3);
        Voice voice= new Voice(bar);
        
        Note knote= new Note(new Pitch('A').transpose(-1),0,10);
        Note knote2= new Note(0,5);
        Note knote3= new Note(0,7);
        List<Element> ktemp1= new ArrayList<Element>();
        List<Element> ktemp2= new ArrayList<Element>();
        List<Element> ktemp3=new ArrayList<Element>();
        ktemp1.add(knote);
        ktemp2.add(knote2);
        ktemp3.add(knote3);
        Measure kmeasure= new Measure(ktemp1);
        Measure kmeasure2=new Measure(ktemp2);
        Measure kmeasure3=new Measure(ktemp3);
        List<Bar> kbar= new ArrayList<Bar>();
        kbar.add(kmeasure);
        kbar.add(kmeasure2);
        kbar.add(kmeasure3);
        Voice kvoice= new Voice(kbar);
        assertEquals(kvoice,voice.transpose(-1));
    }
    @Test
    public void testTranposeSomeRestsThreeTones(){
        Note note= new Note(new Pitch('A'),0,10);
        Note note2= new Note(0,5);
        Note note3= new Note(0,7);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2= new ArrayList<Element>();
        List<Element> temp3=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        temp3.add(note3);
        Measure measure= new Measure(temp1);
        Measure measure2=new Measure(temp2);
        Measure measure3=new Measure(temp3);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        bar.add(measure2);
        bar.add(measure3);
        Voice voice= new Voice(bar);
        
        Note knote= new Note(new Pitch('A').transpose(3),0,10);
        Note knote2= new Note(2,5);
        List<Element> ktemp1= new ArrayList<Element>();
        List<Element> ktemp2= new ArrayList<Element>();
        ktemp1.add(knote);
        ktemp2.add(knote2);
        Measure kmeasure= new Measure(ktemp1);
        Measure kmeasure2=new Measure(ktemp2);
        List<Bar> kbar= new ArrayList<Bar>();
        kbar.add(kmeasure);
        kbar.add(kmeasure2);
        Voice kvoice= new Voice(kbar);
        assertEquals(kvoice,voice.transpose(3));
    }

    @Test
    public void testTranposeAllRestsZeroTones(){
        Note note= new Note(0,10);
        Note note2= new Note(0,5);
        Note note3= new Note(0,7);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2= new ArrayList<Element>();
        List<Element> temp3=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        temp3.add(note3);
        Measure measure= new Measure(temp1);
        Measure measure2=new Measure(temp2);
        Measure measure3=new Measure(temp3);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        bar.add(measure2);
        bar.add(measure3);
        Voice voice= new Voice(bar);
        
        Note knote= new Note(5,5);
        Note knote2= new Note(0,5);
        Note knote3=new Note(0,8);
        List<Element> ktemp1= new ArrayList<Element>();
        List<Element> ktemp2= new ArrayList<Element>();
        ktemp1.add(knote);
        ktemp1.add(knote2);
        ktemp2.add(knote3);
        Measure kmeasure= new Measure(ktemp1);
        Measure kmeasure2=new Measure(ktemp2);
        List<Bar> kbar= new ArrayList<Bar>();
        kbar.add(kmeasure);
        kbar.add(kmeasure2);
        Voice kvoice= new Voice(kbar);
        assertEquals(kvoice,voice.transpose(3));
    }
    @Test
    public void testTranposeAllRestsOneTone(){
        Note note= new Note(0,10);
        Note note2= new Note(0,5);
        Note note3= new Note(0,7);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2= new ArrayList<Element>();
        List<Element> temp3=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        temp3.add(note3);
        Measure measure= new Measure(temp1);
        Measure measure2=new Measure(temp2);
        Measure measure3=new Measure(temp3);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        bar.add(measure2);
        bar.add(measure3);
        Voice voice= new Voice(bar);
        
        Note knote= new Note(5,5);
        Note knote2= new Note(0,5);
        Note knote3=new Note(0,8);
        List<Element> ktemp1= new ArrayList<Element>();
        List<Element> ktemp2= new ArrayList<Element>();
        ktemp1.add(knote);
        ktemp1.add(knote2);
        ktemp2.add(knote3);
        Measure kmeasure= new Measure(ktemp1);
        Measure kmeasure2=new Measure(ktemp2);
        List<Bar> kbar= new ArrayList<Bar>();
        kbar.add(kmeasure);
        kbar.add(kmeasure2);
        Voice kvoice= new Voice(kbar);
        assertEquals(kvoice,voice.transpose(1));
        
    }
    @Test
    public void testTranposeAllRestsThreeTones(){
        Note note= new Note(0,10);
        Note note2= new Note(0,5);
        Note note3= new Note(0,7);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2= new ArrayList<Element>();
        List<Element> temp3=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        temp3.add(note3);
        Measure measure= new Measure(temp1);
        Measure measure2=new Measure(temp2);
        Measure measure3=new Measure(temp3);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        bar.add(measure2);
        bar.add(measure3);
        Voice voice= new Voice(bar);
        
        Note knote= new Note(5,5);
        Note knote2= new Note(0,5);
        Note knote3=new Note(0,8);
        List<Element> ktemp1= new ArrayList<Element>();
        List<Element> ktemp2= new ArrayList<Element>();
        ktemp1.add(knote);
        ktemp1.add(knote2);
        ktemp2.add(knote3);
        Measure kmeasure= new Measure(ktemp1);
        Measure kmeasure2=new Measure(ktemp2);
        List<Bar> kbar= new ArrayList<Bar>();
        kbar.add(kmeasure);
        kbar.add(kmeasure2);
        Voice kvoice= new Voice(kbar);
        assertEquals(kvoice,voice.transpose(3));
    }
    //=========================================================================================================================
    @Test
    public void testPlayOneBar5AtBeats() throws MidiUnavailableException, InvalidMidiDataException{
        Note note= new Note(new Pitch('B'),0,5);
        List<Element> temp1= new ArrayList<Element>();
        temp1.add(note);
        Measure measure= new Measure(temp1);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        Voice voice= new Voice(bar);
        assertEquals("P:B S:0 D:5|  ",voice.toString());
    }
    @Test 
    public void testPlayOneBarAt20AtBeats(){
        Note note= new Note(new Pitch('B'),0,20);
        List<Element> temp1= new ArrayList<Element>();
        temp1.add(note);
        Measure measure= new Measure(temp1);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        Voice voice= new Voice(bar);
        assertEquals("P:B S:0 D:20|  ",voice.toString());
    }
    @Test
    public void testPlayTwoBarsAt5AtBeats(){
        Note note= new Note(new Pitch('B'),0,20);
        Note note2= new Note(new Pitch('C'),20,5);
        List<Element> temp1= new ArrayList<Element>();
        temp1.add(note);
        temp1.add(note2);
        Measure measure= new Measure(temp1);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        Voice voice= new Voice(bar);
        assertEquals("P:B S:0 D:20|  P:C S:20 D:5|  ",voice.toString());
    }
    //=========================================================================================================================
    @Test
    public void testEqualsDifferentDurationVoices(){
        Note note= new Note(new Pitch('B'),0,15);
        Note note2= new Note(0,5);
        Note note3= new Note(0,7);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2= new ArrayList<Element>();
        List<Element> temp3=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        temp3.add(note3);
        Measure measure= new Measure(temp1);
        Measure measure2=new Measure(temp2);
        Measure measure3=new Measure(temp3);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        bar.add(measure2);
        bar.add(measure3);
        Voice voice= new Voice(bar);
        
        Note knote= new Note(5,5);
        Note knote2= new Note(new Pitch('G'),5,5);
        Note knote3=new Note(0,8);
        List<Element> ktemp1= new ArrayList<Element>();
        List<Element> ktemp2= new ArrayList<Element>();
        ktemp1.add(knote);
        ktemp1.add(knote2);
        ktemp2.add(knote3);
        Measure kmeasure= new Measure(ktemp1);
        Measure kmeasure2=new Measure(ktemp2);
        List<Bar> kbar= new ArrayList<Bar>();
        kbar.add(kmeasure);
        kbar.add(kmeasure2);
        Voice kvoice= new Voice(kbar);
        assertFalse(kvoice.equals(voice.transpose(3)));
    }
    @Test
    public void testEqualsSameDurationDifferentBars(){
        Note note= new Note(new Pitch('B'),0,15);
        Note note2= new Note(0,5);
        Note note3= new Note(0,7);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2= new ArrayList<Element>();
        List<Element> temp3=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        temp3.add(note3);
        Measure measure= new Measure(temp1);
        Measure measure2=new Measure(temp2);
        Measure measure3=new Measure(temp3);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        bar.add(measure2);
        bar.add(measure3);
        Voice voice= new Voice(bar);
        
        Note knote= new Note(5,5);
        Note knote2= new Note(new Pitch('G'),0,15);
        Note knote3=new Note(0,8);
        List<Element> ktemp1= new ArrayList<Element>();
        List<Element> ktemp2= new ArrayList<Element>();
        ktemp1.add(knote);
        ktemp1.add(knote2);
        ktemp2.add(knote3);
        Measure kmeasure= new Measure(ktemp1);
        Measure kmeasure2=new Measure(ktemp2);
        List<Bar> kbar= new ArrayList<Bar>();
        kbar.add(kmeasure);
        kbar.add(kmeasure2);
        Voice kvoice= new Voice(kbar);
        assertFalse(kvoice.equals(voice.transpose(3)));
    }
    @Test
    public void testHashCodeDifferentDurationVoices(){
        Note note= new Note(new Pitch('B'),0,17);
        Note note2= new Note(0,5);
        Note note3= new Note(0,7);
        List<Element> temp1= new ArrayList<Element>();
        List<Element> temp2= new ArrayList<Element>();
        List<Element> temp3=new ArrayList<Element>();
        temp1.add(note);
        temp2.add(note2);
        temp3.add(note3);
        Measure measure= new Measure(temp1);
        Measure measure2=new Measure(temp2);
        Measure measure3=new Measure(temp3);
        List<Bar> bar= new ArrayList<Bar>();
        bar.add(measure);
        bar.add(measure2);
        bar.add(measure3);
        Voice voice= new Voice(bar);
        assertEquals(measure.hashCode()+measure2.hashCode()+measure3.hashCode(),voice.hashCode());
    }

}