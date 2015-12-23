package abc.sound.ADTsTests;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

import abc.sound.ADTs.Bar;
import abc.sound.ADTs.ConcatBar;
import abc.sound.ADTs.ConcatElement;
import abc.sound.ADTs.Element;
import abc.sound.ADTs.Measure;
import abc.sound.ADTs.Note;
import abc.sound.ADTs.Voice;
import abc.sound.ClassCodeUsed.Pitch;
import abc.sound.ClassCodeUsed.SequencePlayer;

/**
 * Test music playing methods of ADTs.
 * @category no_didit
 */

public class PlayTest {

    /**
     * Purpose:
     * This class contains tests to the play() methods found in the ADT
     *  i.e. Note, ConcatElement, Bar, ConcatBar, Voice
     * The play() tests are placed here for didit to ignore them
     * 
     * Testing strategy for all methods, including play() methods are found 
     *  in the respective ADT testing files (ElementTest.java, BarTest.java, VoiceTest.java)
     */

    // ------------------------------------- ELEMENT ADT ----------------------------------------------

    private final Note note1 = new Note(new Pitch('A'), 0, 10);
    private final Note rest1 = new Note(0, 10);

    //Sounding Note
    @Test 
    public void testPlaySound() 
            throws MidiUnavailableException, InvalidMidiDataException, IOException {
        SequencePlayer player = new SequencePlayer(100, 10);
        note1.play(player, 10);
        player.play();
    }

    //Rest
    @Test
    public void testPlayRest() 
            throws MidiUnavailableException, InvalidMidiDataException, IOException {
        SequencePlayer player = new SequencePlayer(100, 10);
        rest1.play(player, 10);
        player.play();
    }

    // ---------------------------------------- BAR ADT ----------------------------------------------

    // play(): measure contains no accidentals, atTick = 0
    @Test
    public void measurePlayAtTickZero() {
        Note A0 = new Note(new Pitch('A'), 10*0, 5);
        Note R0 = new Note(5+10*0,5);
        Note A1 = new Note(new Pitch('A'), 10*1, 5);
        Note R1 = new Note(5+10*1,5);
        Note A2 = new Note(new Pitch('A'), 10*2, 5);
        Note R2 = new Note(5+10*2,5);
        Note A3 = new Note(new Pitch('A'), 10*3, 5);
        Note R3 = new Note(5+10*3,5);
        Measure measure1 = new Measure(Arrays.asList(A0,R0,A1,R1,A2,R2,A3,R3));

        try {
            SequencePlayer player = new SequencePlayer(100, 10);
            measure1.play(player, 0);
            System.out.println(measure1.duration());
            measure1.play(player, 0+measure1.duration());
            player.play();
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MidiUnavailableException mue) {
            mue.printStackTrace();
        } catch (InvalidMidiDataException imde) {
            imde.printStackTrace();
        }
    }

    // play(): measure contains accidentals, atTick > 0
    @Test
    public void measurePlayAtTickPos() {
        Note A0 = new Note(new Pitch('A'), 6*0, 6);
        A0 = (Note) A0.transpose(-12);
        Note A1 = new Note(new Pitch('B'), 4+2*1, 2);
        A1 = (Note) A1.transpose(-12);
        Note A2 = new Note(new Pitch('C'), 4+2*2, 2);
        A2 = (Note) A2.transpose(1);
        Note A3 = new Note(new Pitch('D'), 4+2*3, 2);
        Note A4 = new Note(new Pitch('E'), 4+2*4, 2);
        Note A5 = new Note(new Pitch('F'), 4+2*6, 2);
        A5 = (Note) A5.transpose(1);
        Note A6 = new Note(new Pitch('G'), 4+2*6, 2);
        A6 = (Note) A6.transpose(1);
        Note A7 = new Note(new Pitch('A'), 4+2*7, 6);
        Note A8 = new Note(new Pitch('G'), 8+2*8, 2);
        A8 = (Note) A8.transpose(1);
        Note A9 = new Note(new Pitch('F'), 8+2*9, 2);
        A9 = (Note) A9.transpose(1);
        Note A10 = new Note(new Pitch('E'), 8+2*10, 2);
        Note A11 = new Note(new Pitch('D'), 8+2*11, 2);
        Note A12 = new Note(new Pitch('C'), 8+2*12, 2);
        A12 = (Note) A12.transpose(1);
        Note A13 = new Note(new Pitch('B'), 8+2*13, 2);
        A13 = (Note) A13.transpose(-12);
        Note A14 = new Note(new Pitch('A'), 8+2*14, 6);
        A14 = (Note) A14.transpose(-12);

        Note E0 = new Note(new Pitch('E'), 6*0, 1);
        Note E1 = new Note(new Pitch('E'), 4+2*1, 1);
        Note E2 = new Note(new Pitch('E'), 4+2*2, 1);
        Note E3 = new Note(new Pitch('E'), 4+2*3, 1);
        Note E4 = new Note(new Pitch('E'), 4+2*4, 1);
        Note E5 = new Note(new Pitch('E'), 4+2*6, 1);
        Note E6 = new Note(new Pitch('E'), 4+2*6, 1);
        Note E7 = new Note(new Pitch('E'), 4+2*7, 1);
        Note E8 = new Note(new Pitch('E'), 8+2*8, 1);
        Note E9 = new Note(new Pitch('E'), 8+2*9, 1);
        Note E10 = new Note(new Pitch('E'), 8+2*10, 1);
        Note E11 = new Note(new Pitch('E'), 8+2*11, 1);
        Note E12 = new Note(new Pitch('E'), 8+2*12, 1);
        Note E13 = new Note(new Pitch('E'), 8+2*13, 1);
        Note E14 = new Note(new Pitch('E'), 8+2*14, 1);

        ConcatElement C0 = new ConcatElement(A0,E0);
        ConcatElement C1 = new ConcatElement(A1,E1);
        ConcatElement C2 = new ConcatElement(A2,E2);
        ConcatElement C3 = new ConcatElement(A3,E3);
        ConcatElement C4 = new ConcatElement(A4,E4);
        ConcatElement C5 = new ConcatElement(A5,E5);
        ConcatElement C6 = new ConcatElement(A6,E6);
        ConcatElement C7 = new ConcatElement(A7,E7);
        ConcatElement C8 = new ConcatElement(A8,E8);
        ConcatElement C9 = new ConcatElement(A9,E9);
        ConcatElement C10 = new ConcatElement(A10,E10);
        ConcatElement C11 = new ConcatElement(A11,E11);
        ConcatElement C12 = new ConcatElement(A12,E12);
        ConcatElement C13 = new ConcatElement(A13,E13);
        ConcatElement C14 = new ConcatElement(A14,E14);

        Measure measure1 = new Measure(Arrays.asList(C0,C1,C2,C3,C4,C5,C6,C7,C8,C9,C10,C11,C12,C13,C14));

        try {
            SequencePlayer player = new SequencePlayer(60, 6);
            measure1.play(player, 12);
            player.play();
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MidiUnavailableException mue) {
            mue.printStackTrace();
        } catch (InvalidMidiDataException imde) {
            imde.printStackTrace();
        }
    }

    @Test
    public void concatBarTest1() {
        Note A0 = new Note(new Pitch('C'), 10*0, 5);
        Note R0 = new Note(5+10*0,5);
        Note A1 = new Note(new Pitch('C'), 10*1, 5);
        Note R1 = new Note(5+10*1,5);
        Note A2 = new Note(new Pitch('C'), 10*2, 5);
        Note R2 = new Note(5+10*2,5);
        Note A3 = new Note(new Pitch('C'), 10*3, 5);
        Note R3 = new Note(5+10*3,5);
        Measure measure0 = new Measure(Arrays.asList(A0,R0,A1,R1,A2,R2,A3,R3));

        Note A4 = new Note(new Pitch('D'), 10*0, 5);
        Note R4 = new Note(5+10*0,5);
        Note A5 = new Note(new Pitch('D'), 10*1, 5);
        Note R5 = new Note(5+10*1,5);
        Note A6 = new Note(new Pitch('D'), 10*2, 5);
        Note R6 = new Note(5+10*2,5);
        Note A7 = new Note(new Pitch('D'), 10*3, 5);
        Note R7 = new Note(5+10*3,5);
        Measure measure1 = new Measure(Arrays.asList(A4,R4,A5,R5,A6,R6,A7,R7));

        Note A8 = new Note(new Pitch('E'), 10*0, 5);
        Note R8 = new Note(5+10*0,5);
        Note A9 = new Note(new Pitch('E'), 10*1, 5);
        Note R9 = new Note(5+10*1,5);
        Note A10 = new Note(new Pitch('E'), 10*2, 5);
        Note R10 = new Note(5+10*2,5);
        Note A11 = new Note(new Pitch('E'), 10*3, 5);
        Note R11 = new Note(5+10*3,5);
        Measure measure2 = new Measure(Arrays.asList(A8,R8,A9,R9,A10,R10,A11,R11));

        Note A12 = new Note(new Pitch('F'), 10*0, 5);
        Note R12 = new Note(5+10*0,5);
        Note A13 = new Note(new Pitch('F'), 10*1, 5);
        Note R13 = new Note(5+10*1,5);
        Note A14 = new Note(new Pitch('F'), 10*2, 5);
        Note R14 = new Note(5+10*2,5);
        Note A15 = new Note(new Pitch('F'), 10*3, 5);
        Note R15 = new Note(5+10*3,5);
        Measure measure3 = new Measure(Arrays.asList(A12,R12,A13,R13,A14,R14,A15,R15));

        ConcatBar bar0 = new ConcatBar(measure0,measure1,false);
        ConcatBar bar1 = new ConcatBar(measure2,new Measure(new ArrayList<>()),false);
        ConcatBar bar2 = new ConcatBar(bar0,bar1,measure3,true);

        try {
            SequencePlayer player = new SequencePlayer(100, 10);
            bar2.play(player, 0);
            System.out.println("m0: " + measure0.duration());
            System.out.println("m1: " + measure1.duration());
            System.out.println("m2: " + measure2.duration());
            System.out.println("m3: " + measure3.duration());
            System.out.println("bar0: " + bar0.duration());
            System.out.println("bar1: " + bar1.duration());
            System.out.println("bar2: " + bar2.duration());
            bar2.play(player, 0+bar2.duration());
            player.play();
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MidiUnavailableException mue) {
            mue.printStackTrace();
        } catch (InvalidMidiDataException imde) {
            imde.printStackTrace();
        }
    }


    // ---------------------------------------- VOICE ADT ----------------------------------------------
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
}