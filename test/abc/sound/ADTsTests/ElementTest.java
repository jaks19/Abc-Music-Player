package abc.sound.ADTsTests;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

import abc.sound.ADTs.ConcatElement;
import abc.sound.ADTs.Element;
import abc.sound.ADTs.Note;
import abc.sound.ClassCodeUsed.Pitch;
import abc.sound.ClassCodeUsed.SequencePlayer;

public class ElementTest {

    //-------------------------------------TESTING NOTE----------------------------------------------------

    private final Pitch pitch1 = new Pitch('A');
    private final Pitch pitch2 = new Pitch('B');
    private final Note note1 = new Note(pitch1, 0, 10);
    private final Note note11 = new Note(pitch1, 0, 10);
    private final Note note2 = new Note(pitch2, 10, 10);
    private final Note rest1 = new Note(0, 10);
    private final Note rest11 = new Note(0, 10);
    private final Note rest2 = new Note(10, 10);

    //TESTING CONSTRUCTOR()
    //Testing Strategy
    /*
     * In all cases, the field values are also verified to see if they are as we need them
     * 1. Note created is a sounding Note (In all cases duration > 0)
     *  - startTick > 0
     *  - startTick == 0
     *  
     * 2. Note created is a rest (In all cases duration > 0)
     *  - startTick > 0
     *  - startTick == 0
     */
    //Sounding Note, startTick > 0
    @Test
    public void testConstructorSound1() {
        Note testNote = new Note(pitch2, 10, 10);
        assertTrue(testNote.start() == 10
                && testNote.duration() == 10
                && testNote.pitch().equals(pitch2)
                && testNote.sound() == true);
    }

    //Sounding Note, startTick == 0
    @Test
    public void testConstructorSound2() {
        Note testNote = new Note(pitch2, 0, 10);
        assertTrue(testNote.start() == 0
                && testNote.duration() == 10
                && testNote.pitch().equals(pitch2)
                && testNote.sound() == true);
    }

    //Rest, startTick > 0
    @Test
    public void testConstructorRest1() {
        Note testNote = new Note(10, 10);
        assertTrue(testNote.start() == 10
                && testNote.duration() == 10
                && testNote.pitch().equals(pitch1)
                && testNote.sound() == false);
    }

    //Rest, startTick == 0
    @Test
    public void testConstructorRest2() {
        Note testNote = new Note(0, 10);
        assertTrue(testNote.start() == 0
                && testNote.duration() == 10
                && testNote.pitch().equals(pitch1)
                && testNote.sound() == false);
    }

    //TESTING DURATION()
    //Testing Strategy
    /*
     * Basic Functionality of the method
     *  - Note is a sounding Note and it has a duration
     *  - Note is a rest and it has a duration
     */

    //Sounding Note
    @Test
    public void testDurationSound() {
        assertTrue(note1.duration() == 10);
    }

    //Rest
    @Test
    public void testDurationRest() {
        assertTrue(rest1.duration() == 10);
    }

    //TESTING PLAY()
    //Testing Strategy
    /*
     * Basic Functionality of the method
     *  - Note is a sounding Note 
     *  - Note is a rest 
     *  
     *  TESTS ARE IN PlayTest.java
     */

    //TESTING TRANSPOSE()
    //Testing Strategy
    /*
     * 1. Note is a sounding Note
     *  - Transpose by +1
     *  - Transpose by -1
     *  - Transpose by 0
     *  
     * 2. Note is a rest
     *  - Transpose by +1
     *  - Transpose by -1
     *  - Transpose by 0
     */

    //Sounding Note by + 1
    @Test
    public void testTransposeSoundPlus1() {
        Element noteTrans = note1.transpose(1);
        assertTrue((noteTrans.toString()).equals("P:^A S:0 D:10| "));
    }

    //Sounding Note by - 1
    @Test
    public void testTransposeSoundMinus1() {
        Element noteTrans = note1.transpose(-1);
        assertTrue((noteTrans.toString()).equals("P:^G S:0 D:10| "));
    }

    //Sounding Note by 0
    @Test
    public void testTransposeSound0() {
        Element noteTrans = note1.transpose(0);
        assertTrue(noteTrans.equals(note1));
    }

    //Rest by + 1
    @Test
    public void testTransposeRestPlus1() {
        Element restTrans = rest1.transpose(1);
        assertTrue(restTrans.equals(rest1));
    }

    //Rest by - 1
    @Test
    public void testTransposeRestMinus1() {
        Element restTrans = rest1.transpose(-1);
        assertTrue(restTrans.equals(rest1));
    }

    //Rest by 0
    @Test
    public void testTransposeRest0() {
        Element restTrans = rest1.transpose(0);
        assertTrue(restTrans.equals(rest1));
    }

    //TESTING START()
    //Testing Strategy
    /*
     * Basic Functionality of the method
     *  - Note is a sounding Note and it has a startTick
     *  - Note is a rest and it has a startTick
     */

    //Sounding Note
    @Test
    public void testStartSound() {
        assertTrue(note1.start() == 0);
    }

    //Rest
    @Test
    public void testStartRest() {
        assertTrue(rest1.start() == 0);
    }

    //TESTING HASHCODE()
    //Testing Strategy
    /*
     * 1. Basic Functionality of the method
     *  - Note is a sounding Note and it has a hashCode
     *  - Note is a rest and it has a hashCode
     * 2. Equal Notes (should have same hashCodes)
     *  - Note is a sounding Note and it has a hashCode
     *  - Note is a rest and it has a hashCode
     */

    //Basics Sounding Note
    @Test
    public void testHashcodeSound() {
        assertTrue(note1.hashCode() == 1);
    }

    //Basics Rest
    @Test
    public void testHashcodeRest() {
        assertTrue(rest1.hashCode() == 1);
    }

    //Equal Sounding Notes
    @Test
    public void testEqualHashcodeSound() {
        assertTrue(note1.hashCode() == note11.hashCode());
    }

    //Equal Rests
    @Test
    public void testEqualHashcodeRest() {
        assertTrue(rest1.hashCode() == rest11.hashCode());
    }

    //TESTING EQUALS()
    //Testing Strategy
    /*
     * 1. Both Notes are sounding Notes
     *  - Both equal
     *  - They are unequal
     *  
     * 2. Both Notes are rests
     *  - Both equal
     *  - They are unequal
     *  
     * 3. One is a sounding Note, one is a rest
     */

    //Two equal sounding Notes
    @Test
    public void testEqualsEqualSounds() {
        assertTrue(note1.equals(note11));
    }

    //Two unequal sounding Notes
    @Test
    public void testEqualsUnequalSounds() {
        assertFalse(note1.equals(note2));
    }

    //Two equal rests
    @Test
    public void testEqualsEqualRests() {
        assertTrue(rest1.equals(rest11));
    }

    //Two unequal rests
    @Test
    public void testEqualsUnequalRests() {
        assertFalse(rest1.equals(rest2));
    }

    //One sounding Note and One rest
    @Test
    public void testEqualsSoundAndRest() {
        assertFalse(note1.equals(rest1));
    }


    //TESTING TOSTRING()
    //Testing Strategy
    /*
     * Basic Functionality of the method
     *  - Note is a sounding Note
     *  - Note is a rest
     */

    //Sounding Note
    @Test
    public void testToStringSound() {
        assertTrue(note1.toString().equals("P:A S:0 D:10| "));
    }

    //Rest
    @Test
    public void testToStringRest() {
        assertTrue(rest1.toString().equals("P:A S:0 D:10| "));
    }

    //TESTING PITCH()
    //Testing Strategy
    /*
     * Basic Functionality of the method
     *  - Note is a sounding Note and it has a Pitch
     *  - Note is a rest and it has no Pitch
     */

    //Sounding Note
    @Test
    public void testPitchSound() {
        assertTrue(note1.pitch().equals(pitch1));
    }

    //Rest
    @Test
    public void testPitchRest() {
        assertTrue(rest1.pitch().equals(pitch1));
    }


    //TESTING SOUND()
    //Testing Strategy
    /*
     * Basic Functionality of the method
     *  - Note is a sounding Note and it has a sound field
     *  - Note is a rest and it has a sound field
     */

    //Sounding Note
    @Test
    public void testSoundSoundingNote() {
        assertTrue(note1.sound() == true);
    }

    //Rest
    @Test
    public void testSoundRest() {
        assertTrue(rest1.sound() == false);
    }

    //-------------------------------------TESTING CONCATELEMENT----------------------------------------------------
    //TESTING CONSTRUCTOR()
    //Testing Strategy
    /*
     * Basic Functionality of the method
     *  - left, right are both Notes
     *  - left is a Note, right is another ConcatElement
     *  - right is a Note, left is another ConcatElement
     *  - left, right are ConcatElements
     */
    private final Note note3 = new Note(pitch1, 20, 10);
    private final Note note4 = new Note(pitch1, 30, 10);

    private final ConcatElement concatNotes = new ConcatElement(note1, note2);
    private final ConcatElement concatNotes1 = new ConcatElement(note1, note2);
    private final ConcatElement concatNotes2 = new ConcatElement(note3, note4);
    private final ConcatElement concatLeft = new ConcatElement(note1, concatNotes);
    private final ConcatElement concatLeft1 = new ConcatElement(note1, concatNotes);
    private final ConcatElement concatLeft2 = new ConcatElement(note1, concatNotes2);
    private final ConcatElement concatRight = new ConcatElement(concatNotes, note2);
    private final ConcatElement concatRight1 = new ConcatElement(concatNotes, note2);
    private final ConcatElement concatRight2 = new ConcatElement(concatNotes, note4);
    private final ConcatElement concatConcats = new ConcatElement(concatNotes1, concatNotes2);
    private final ConcatElement concatConcats1 = new ConcatElement(concatNotes1, concatNotes2);
    private final ConcatElement concatConcats2 = new ConcatElement(concatNotes1, concatRight2);

    //Both Notes
    @Test
    public void testConstructorBothNotes() {
        ConcatElement testConcat = new ConcatElement(note1, note2);
        assertTrue(testConcat.start() == 0
                && testConcat.duration() == 20);
    }

    //Left Note, Right ConcatElement
    @Test
    public void testConstructorLeftNote() {
        ConcatElement testConcat = new ConcatElement(note1, concatNotes);
        assertTrue(testConcat.start() == 0
                && testConcat.duration() == 10);
    }

    //Right Note, Left ConcatElement
    @Test
    public void testConstructorRightNote() {
        ConcatElement testConcat = new ConcatElement(concatNotes, note2);
        assertTrue(testConcat.start() == 0
                && testConcat.duration() == 30);
    }

    //Both ConcatElements
    @Test
    public void testConstructorBothConcats() {
        ConcatElement testConcat = new ConcatElement(concatNotes, concatNotes);
        assertTrue(testConcat.start() == 0
                && testConcat.duration() == 20);
    }

    //TESTING DURATION()
    //Testing Strategy
    /*
     *  - left, right are both Notes
     *  - left is a Note, right is another ConcatElement
     *  - right is a Note, left is another ConcatElement
     *  - left, right are ConcatElements 
     */

    //Both Notes
    @Test
    public void testDurationBothNotes() {
        assertTrue(concatNotes.duration() == 20);
    }

    //Left Note, Right ConcatElement
    @Test
    public void testDurationLeftNote() {
        assertTrue(concatLeft.duration() == 10);
    }

    //Right Note, Left ConcatElement
    @Test
    public void testDurationRightNote() {
        assertTrue(concatRight.duration() == 30);
    }

    //Both ConcatElements
    @Test
    public void testDurationBothConcats() {
        assertTrue(concatConcats.duration() == 40);
    }

    //TESTING PLAY()
    //Testing Strategy
    /*
     *  - left, right are both Notes
     *  - left is a Note, right is another ConcatElement
     *  - right is a Note, left is another ConcatElement
     *  - left, right are ConcatElements 
     */

    //Both Notes
    //@Test Commented out as Didit does not play sounds
    public void testPlayBothNotes()  
            throws MidiUnavailableException, InvalidMidiDataException, IOException {
        SequencePlayer player = new SequencePlayer(100, 10);
        concatNotes.play(player, 10);
        player.play();
        //Listen if duration correct and number of Notes correct
    }

    //Left Note, Right ConcatElement
    //@Test Commented out as Didit does not play sounds
    public void testPlayLeftNote()  
            throws MidiUnavailableException, InvalidMidiDataException, IOException {
        SequencePlayer player = new SequencePlayer(100, 10);
        concatLeft.play(player, 10);
        player.play();
        //Listen if duration correct and number of Notes correct
    }

    //Right Note, Left ConcatElement
    //@Test Commented out as Didit does not play sounds
    public void testPlayRightNote()  
            throws MidiUnavailableException, InvalidMidiDataException, IOException {
        SequencePlayer player = new SequencePlayer(100, 10);
        concatRight.play(player, 10);
        player.play();
        //Listen if duration correct and number of Notes correct
    }

    //Both ConcatElements
    //@Test Commented out as Didit does not play sounds
    public void testPlayBothConcats()
            throws MidiUnavailableException, InvalidMidiDataException, IOException {
        SequencePlayer player = new SequencePlayer(100, 10);
        concatConcats.play(player, 10);
        player.play();
        //Listen if duration correct and number of Notes correct
    }

    //TESTING TRANSPOSE()
    //Testing Strategy
    /*
     * The following actions are performed...
     *  - Transpose by +1
     *  - Transpose by -1
     *  - Transpose by 0
     * ...On the following ConcatElements:
     *  - left, right are both Notes
     *  - left is a Note, right is another ConcatElement
     *  - right is a Note, left is another ConcatElement
     *  - left, right are ConcatElements 
     */

    //Both Notes
    @Test
    public void testTransposeBothNotes() {
        Element notesTrans1 = concatNotes.transpose(1);
        assertTrue((notesTrans1.toString()).equals("P:^A S:0 D:10| P:C' S:10 D:10| "));
        Element notesTransM1 = concatNotes.transpose(-1);
        assertTrue((notesTransM1.toString()).equals("P:^G S:0 D:10| P:^A S:10 D:10| "));
        Element notesTrans0 = concatNotes.transpose(0);
        assertTrue((notesTrans0.toString()).equals("P:A S:0 D:10| P:B S:10 D:10| "));
    }

    //Left Note, Right ConcatElement
    @Test
    public void testTransposeLeftNote() {
        Element leftTrans1 = concatLeft.transpose(1);
        assertTrue((leftTrans1.toString()).equals(
                "P:^A S:0 D:10| P:^A S:0 D:10| P:C' S:10 D:10| "));
        Element leftTransM1 = concatLeft.transpose(-1);
        assertTrue((leftTransM1.toString()).equals(
                "P:^G S:0 D:10| P:^G S:0 D:10| P:^A S:10 D:10| "));
        Element leftTrans0 = concatLeft.transpose(0);
        assertTrue((leftTrans0.toString()).equals(
                "P:A S:0 D:10| P:A S:0 D:10| P:B S:10 D:10| "));
    }

    //Right Note, Left ConcatElement
    @Test
    public void testTransposeRightNote() {
        Element rightTrans1 = concatRight.transpose(1);
        assertTrue((rightTrans1.toString()).equals(
                "P:^A S:0 D:10| P:C' S:10 D:10| P:C' S:10 D:10| "));
        Element rightTransM1 = concatRight.transpose(-1);
        assertTrue((rightTransM1.toString()).equals(
                "P:^G S:0 D:10| P:^A S:10 D:10| P:^A S:10 D:10| "));
        Element rightTrans0 = concatRight.transpose(0);
        assertTrue((rightTrans0.toString()).equals(
                "P:A S:0 D:10| P:B S:10 D:10| P:B S:10 D:10| "));
    }

    //Both ConcatElements
    @Test
    public void testTransposeBothConcats() {
        Element concatsTrans1 = concatConcats.transpose(1);
        assertTrue((concatsTrans1.toString()).equals(
                "P:^A S:0 D:10| P:C' S:10 D:10| P:^A S:20 D:10| P:^A S:30 D:10| "));
        Element concatsTransM1 = concatConcats.transpose(-1);
        assertTrue((concatsTransM1.toString()).equals(
                "P:^G S:0 D:10| P:^A S:10 D:10| P:^G S:20 D:10| P:^G S:30 D:10| "));
        Element concatsTrans0 = concatConcats.transpose(0);
        assertTrue((concatsTrans0.toString()).equals(
                "P:A S:0 D:10| P:B S:10 D:10| P:A S:20 D:10| P:A S:30 D:10| "));
    }

    //TESTING START()
    //Testing Strategy
    /*
     *  - left, right are both Notes
     *  - left is a Note, right is another ConcatElement
     *  - right is a Note, left is another ConcatElement
     *  - left, right are ConcatElements 
     */

    //Both Notes
    @Test
    public void testStartBothNotes() {
        assertTrue(concatNotes.start() == 0);
    }

    //Left Note, Right ConcatElement
    @Test
    public void testStartLeftNote() {
        assertTrue(concatLeft.start() == 0);
    }

    //Right Note, Left ConcatElement
    @Test
    public void testStartRightNote() {
        assertTrue(concatRight.start() == 0);
    }

    //Both ConcatElements
    @Test
    public void testStartBothConcats() {
        assertTrue(concatConcats.start() == 0);
    }


    //TESTING HASHCODE()
    //Testing Strategy
    /*
     * 1. Basic Functionality of the method: Objects should have a hashCode
     *  - left, right are both Notes
     *  - left is a Note, right is another ConcatElement
     *  - right is a Note, left is another ConcatElement
     *  - left, right are ConcatElements - Note is a sounding Note and it has a hashCode
     * 2. Equal Concats (should have same hashCodes)
     *  - left, right are both Notes
     *  - left is a Note, right is another ConcatElement
     *  - right is a Note, left is another ConcatElement
     *  - left, right are ConcatElements - Note is a sounding Note and it has a hashCode
     */

    //Basics Note+Note
    @Test
    public void testHashcodeBasic1() {
        assertTrue(concatNotes.hashCode() == 1102);
    }

    //Basics Note+concat
    @Test
    public void testHashcodeBasic2() {
        assertTrue(concatLeft.hashCode() == 1103);
    }

    //Basics Concat+note
    @Test
    public void testHashcodeBasic3() {
        assertTrue(concatRight.hashCode() == 2203);
    }

    //Basics Concat+concat
    @Test
    public void testHashcodeBasic4() {
        assertTrue(concatConcats.hashCode() == 5604);
    }

    //Equal Note+Note
    @Test
    public void testHashcodeEqual1() {
        assertTrue(concatNotes.hashCode() == concatNotes1.hashCode());
    }

    //Equal Note+concat
    @Test
    public void testHashcodeEqual2() {
        assertTrue(concatLeft.hashCode() == concatLeft1.hashCode());
    }

    //Equal Concat+note
    @Test
    public void testHashcodeEqual3() {
        assertTrue(concatRight.hashCode() == concatRight1.hashCode());
    }

    //Equal Concat+concat
    @Test
    public void testHashcodeEqual4() {
        assertTrue(concatConcats.hashCode() == concatConcats.hashCode());
    }

    //TESTING EQUALS()
    //Testing Strategy
    /*
     * 1. Both ConcatElement Objects are equal
     *  - left, right are both Notes
     *  - left is a Note, right is another ConcatElement
     *  - right is a Note, left is another ConcatElement
     *  - left, right are ConcatElements 
     *  
     * 2. ConcatElementObjects are unequal
     *  - left, right are both Notes
     *  - left is a Note, right is another ConcatElement
     *  - right is a Note, left is another ConcatElement
     *  - left, right are ConcatElements 
     */

    //Equal, Note+Note
    @Test
    public void testEqualsEqual1() {
        assertTrue(concatNotes.equals(concatNotes1));
    }

    //Equal, Note+Concat
    @Test
    public void testEqualsEqual2() {
        assertTrue(concatLeft.equals(concatLeft1));
    }

    //Equal, Concat+Note
    @Test
    public void testEqualsEqual3() {
        assertTrue(concatRight.equals(concatRight1));
    }

    //Equal, Concat+Concat
    @Test
    public void testEqualsEqual4() {
        assertTrue(concatConcats.equals(concatConcats1));
    }

    //Unequal, Note+Note
    @Test
    public void testEqualsUnequal1() {
        assertFalse(concatNotes.equals(concatNotes2));
    }

    //Unequal, Note+Concat
    @Test
    public void testEqualsUnequal2() {
        assertFalse(concatLeft.equals(concatLeft2));
    }

    //Unequal, Concat+Note
    @Test
    public void testEqualsUnequal3() {
        assertFalse(concatRight.equals(concatRight2));
    }

    //Unequal, Concat+Concat
    @Test
    public void testEqualsUnequal4() {
        assertFalse(concatConcats.equals(concatConcats2));
    }


    //TESTING TOSTRING()
    //Testing Strategy
    /*
     *  - left, right are both Notes
     *  - left is a Note, right is another ConcatElement
     *  - right is a Note, left is another ConcatElement
     *  - left, right are ConcatElements 
     */

    //Both Notes
    @Test
    public void testToStringBothNotes() {
        assertTrue(concatNotes.toString().equals(
                "P:A S:0 D:10| P:B S:10 D:10| "));
    }

    //Left Note, Right ConcatElement
    @Test
    public void testToStringLeftNote() {
        assertTrue(concatLeft.toString().equals(
                "P:A S:0 D:10| P:A S:0 D:10| P:B S:10 D:10| "));
    }

    //Right Note, Left ConcatElement
    @Test
    public void testToStringRightNote() {
        assertTrue(concatRight.toString().equals(
                "P:A S:0 D:10| P:B S:10 D:10| P:B S:10 D:10| "));
    }

    //Both ConcatElements
    @Test
    public void testToStringBothConcats() {
        assertTrue(concatConcats.toString().equals(
                "P:A S:0 D:10| P:B S:10 D:10| P:A S:20 D:10| P:A S:30 D:10| "));
    }

}