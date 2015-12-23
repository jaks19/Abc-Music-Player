package abc.sound.ADTsTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import abc.sound.ADTs.ConcatBar;
import abc.sound.ADTs.ConcatElement;
import abc.sound.ADTs.Measure;
import abc.sound.ADTs.Note;
import abc.sound.ClassCodeUsed.Pitch;

public class BarTest {

    private final Note noteA0 = new Note(new Pitch('A'), 0, 6);                           // A
    private final Note noteBb0 = (Note) (new Note(new Pitch('B'), 0, 6)).transpose(-1);   // Bb
    private final Note noteB0 = new Note(new Pitch('B'), 0, 6);                           // B
    private final Note noteC0 = (Note) (new Note(new Pitch('B'), 0, 6)).transpose(1);     // B#
    
    private final Note noteA6 = new Note(new Pitch('A'), 6, 6);                           // A
    private final Note noteBb6 = (Note) (new Note(new Pitch('B'), 6, 6)).transpose(-1);   // Bb
    private final Note noteB6 = new Note(new Pitch('B'), 6, 6);                           // B
    private final Note noteC6 = (Note) (new Note(new Pitch('B'), 6, 6)).transpose(1);     // B#
    
    private final Note noteA12 = new Note(new Pitch('A'), 12, 6);                         // A
    private final Note noteBb12 = (Note) (new Note(new Pitch('B'), 12, 6)).transpose(-1); // Bb
    private final Note noteB12 = new Note(new Pitch('B'), 12, 6);                         // B
    private final Note noteC12 = (Note) (new Note(new Pitch('B'), 12, 6)).transpose(1);   // B#
    
    private final Note noteA18 = new Note(new Pitch('A'), 18, 6);                         // A
    private final Note noteBb18 = (Note) (new Note(new Pitch('B'), 18, 6)).transpose(-1); // Bb
    private final Note noteB18 = new Note(new Pitch('B'), 18, 6);                         // B
    private final Note noteC18 = (Note) (new Note(new Pitch('B'), 18, 6)).transpose(1);   // B#
    
    private final ConcatElement chordABb0 = new ConcatElement(noteA0, noteBb0);
    private final ConcatElement chordAB0 = new ConcatElement(noteA0, noteB0);
    private final ConcatElement chordBbB0 = new ConcatElement(noteBb0, noteB0);
    private final ConcatElement tupletABC0 = new ConcatElement(new ConcatElement(new Note(
            new Pitch('A'),0,2), new Note(new Pitch('B'),2,2)), new Note(new Pitch('C'),4,2));
    private final ConcatElement tupletBbCDb0 = new ConcatElement(new ConcatElement((new Note(
            new Pitch('A'),0,2)).transpose(1), (new Note(new Pitch('B'),2,2)).transpose(1)), (new Note(new Pitch('C'),4,2)).transpose(1));
    
    //
    // Measure
    //
    // duration()
    // Test partitions:
    //    measure contains 0, 1, >1 element
    //
    // transpose()
    // Test partitions:
    //    measure's elements contains accidentals, measure does not contain accidentals
    //    transpose's semitonesUp is <0, 0, >0
    //
    // play()
    // Test partitions:
    //    measure's elements contains accidentals, measure does not contain accidentals
    //    atTick =0, >0
    //
    // equals()
    // Test partitions:
    //    thatObject is a Measure, is a ConcatBar, is not a Bar 
    //    thatObject contains 0, 1, >1 element
    //    this contains 0, 1, >1 element
    //
    // hashCode()
    // Test partitions:
    //    measure contains 0, 1, >1 element
    //
    
    // duration(): measure contains 0 elements
    @Test
    public void measureDurationZeroElements() {
        Measure measure = new Measure(new ArrayList<>());
        assertEquals(0,measure.duration());
    }
    
    // duration(): measure contains 1 element
    @Test
    public void measureDurationOneElement() {
        Measure measureNote = new Measure(Arrays.asList(noteA0));
        Measure measureChord = new Measure(Arrays.asList(chordABb0));
        Measure measureTuplet = new Measure(Arrays.asList(tupletABC0));
        assertTrue(measureNote.duration()==6);
        assertTrue(measureChord.duration()==6);
        assertTrue(measureTuplet.duration()==6);
    }
    
    // duration(): measure contains 2 elements
    @Test
    public void measureDurationTwoElements() {
        Measure measureNote = new Measure(Arrays.asList(noteA0,noteA6,noteA12,noteA18));
        Measure measureChord = new Measure(Arrays.asList(chordABb0,noteA6,noteA12,noteA18));
        Measure measureTuplet = new Measure(Arrays.asList(tupletABC0,noteA6,noteA12,noteA18));
        assertTrue(measureNote.duration()==24);
        assertTrue(measureChord.duration()==24);
        assertTrue(measureTuplet.duration()==24);
    }
    
    // transpose(): measure contains accidentals, semitonesUp <0
    @Test
    public void measureTransposeSemitonesNeg() {
        Measure measureNote = new Measure(Arrays.asList(noteBb0,noteB6,noteBb12,noteB18));
        Measure measureChord = new Measure(Arrays.asList(chordBbB0,noteB6,noteBb12,noteB18));
        Measure measureTuplet = new Measure(Arrays.asList(tupletBbCDb0,noteB6,noteBb12,noteB18));
        Measure measureNoteCorrect = new Measure(Arrays.asList(noteA0,noteBb6,noteA12,noteBb18));
        Measure measureChordCorrect = new Measure(Arrays.asList(chordABb0,noteBb6,noteA12,noteBb18));
        Measure measureTupletCorrect = new Measure(Arrays.asList(tupletABC0,noteBb6,noteA12,noteBb18));
        assertTrue(measureNote.transpose(-1).equals(measureNoteCorrect));
        assertTrue(measureChord.transpose(-1).equals(measureChordCorrect));
        assertTrue(measureTuplet.transpose(-1).equals(measureTupletCorrect));
    }
    
    // transpose(): measure contains accidentals, semitonesUp =0
    @Test
    public void measureTransposeSemitonesZero() {
        Measure measureNote = new Measure(Arrays.asList(noteA0,noteB6,noteA12,noteB18));
        Measure measureChord = new Measure(Arrays.asList(chordAB0,noteB6,noteA12,noteB18));
        Measure measureTuplet = new Measure(Arrays.asList(tupletABC0,noteB6,noteA12,noteB18));
        Measure measureNoteCorrect = new Measure(Arrays.asList(noteA0,noteB6,noteA12,noteB18));
        Measure measureChordCorrect = new Measure(Arrays.asList(chordAB0,noteB6,noteA12,noteB18));
        Measure measureTupletCorrect = new Measure(Arrays.asList(tupletABC0,noteB6,noteA12,noteB18));
        assertTrue(measureNote.transpose(0).equals(measureNoteCorrect));
        assertTrue(measureChord.transpose(0).equals(measureChordCorrect));
        assertTrue(measureTuplet.transpose(0).equals(measureTupletCorrect));
    }
    
    // transpose(): measure contains no accidentals, semitonesUp >0
    @Test
    public void measureTransposeSemitonesPos() {
        Measure measureNote = new Measure(Arrays.asList(noteA0,noteBb6,noteA12,noteBb18));
        Measure measureChord = new Measure(Arrays.asList(chordABb0,noteBb6,noteA12,noteBb18));
        Measure measureTuplet = new Measure(Arrays.asList(tupletABC0,noteBb6,noteA12,noteBb18));
        Measure measureNoteCorrect = new Measure(Arrays.asList(noteBb0,noteB6,noteBb12,noteB18));
        Measure measureChordCorrect = new Measure(Arrays.asList(chordBbB0,noteB6,noteBb12,noteB18));
        Measure measureTupletCorrect = new Measure(Arrays.asList(tupletBbCDb0,noteB6,noteBb12,noteB18));
        assertTrue(measureNote.transpose(1).equals(measureNoteCorrect));
        assertTrue(measureChord.transpose(1).equals(measureChordCorrect));
        assertTrue(measureTuplet.transpose(1).equals(measureTupletCorrect));
    }
    
    // equals(): thatObject is a Measure, thatObject contains 0 elements, this contains 0 elements
    @Test
    public void measureEqualsMeasureThatZeroThisZero() {
        Measure thisObject = new Measure(new ArrayList<>());
        Measure thatObject = new Measure(new ArrayList<>());
        assertTrue(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, thatObject contains 0 elements, this contains 1 elements
    @Test
    public void measureEqualsMeasureThatZeroThisOne() {
        Measure thisObject = new Measure(new ArrayList<>());
        Measure thatObject = new Measure(Arrays.asList(noteC0));
        assertFalse(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, thatObject contains 0 elements, this contains >1 elements
    @Test
    public void measureEqualsMeasureThatZeroThisTwo() {
        Measure thisObject = new Measure(new ArrayList<>());
        Measure thatObject = new Measure(Arrays.asList(noteA0,noteC6,noteC12,noteC18));
        assertFalse(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, thatObject contains 1 elements, this contains 0 elements
    @Test
    public void measureEqualsMeasureThatOneThisZero() {
        Measure thisObject = new Measure(Arrays.asList(noteC0));
        Measure thatObject = new Measure(new ArrayList<>());
        assertFalse(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, thatObject contains 1 elements, this contains 1 elements
    @Test
    public void measureEqualsMeasureThatOneThisOne() {
        Measure thisObject = new Measure(Arrays.asList(noteC0));
        Measure thatObject = new Measure(Arrays.asList(noteC0));
        Measure thatObjectWrong = new Measure(Arrays.asList(noteC6));
        assertTrue(thisObject.equals(thatObject));
        assertFalse(thisObject.equals(thatObjectWrong));
    }
    
    // equals(): thatObject is a Measure, thatObject contains 1 elements, this contains >1 elements
    @Test
    public void measureEqualsMeasureThatOneThisTwo() {
        Measure thisObject = new Measure(Arrays.asList(noteC0));
        Measure thatObject = new Measure(Arrays.asList(noteC0,noteC6,noteB12));
        assertFalse(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, thatObject contains >1 elements, this contains 0 elements
    @Test
    public void measureEqualsMeasureThatTwoThisZero() {
        Measure thisObject = new Measure(Arrays.asList(noteC0,noteC6,noteB12));
        Measure thatObject = new Measure(new ArrayList<>());
        assertFalse(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, thatObject contains >1 elements, this contains 1 elements
    @Test
    public void measureEqualsMeasureThatTwoThisOne() {
        Measure thisObject = new Measure(Arrays.asList(noteC0,noteC6,noteB12));
        Measure thatObject = new Measure(Arrays.asList(noteC0));
        assertFalse(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, thatObject contains >1 elements, this contains >1 elements
    @Test
    public void measureEqualsMeasureThatTwoThisTwo() {
        Measure thisObject = new Measure(Arrays.asList(noteC0,noteC6,noteB12));
        Measure thatObject = new Measure(new ArrayList<>());
        assertFalse(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a ConcatBar, thatObject contains 0 elements, this contains 0 elements
    @Test
    public void measureEqualsConcatBarThatZeroThisZero() {
        Measure measure1 = new Measure(new ArrayList<>());
        Measure measure2 = new Measure(new ArrayList<>());
        ConcatBar thatObject = new ConcatBar(measure1,measure2,false);
        assertFalse(measure1.equals(thatObject));
    }
    
    // equals(): thatObject is a ConcatBar, thatObject contains 1 elements, this contains 1 elements
    @Test
    public void measureEqualsConcatBarThatOneThisOne() {
        Measure measure1 = new Measure(Arrays.asList(noteA0));
        Measure measure2 = new Measure(new ArrayList<>());
        ConcatBar thatObject = new ConcatBar(measure1,measure2,false);
        assertFalse(measure1.equals(thatObject));
    }
    
    // equals(): thatObject is a ConcatBar, thatObject contains >1 elements, this contains >1 elements
    @Test
    public void measureEqualsConcatBarThatTwoThisTwo() {
        Measure measure1 = new Measure(Arrays.asList(noteA0,noteA6));
        Measure measure2 = new Measure(Arrays.asList(noteA0,noteA6));
        ConcatBar thatObject = new ConcatBar(measure1,measure2,false);
        assertFalse(measure1.equals(thatObject));
    }
    
    // equals(): thatObject is not a Bar, thatObject contains 0 elements, this contains 0 elements
    @Test
    public void measureEqualsNotBarThatZeroThisZero() {
        Measure measure = new Measure(new ArrayList<>());
        assertFalse(measure.equals(new ArrayList<>()));
    }
    
    // equals(): thatObject is not a Bar, thatObject contains 1 elements, this contains 1 elements
    @Test
    public void measureEqualsNotBarThatOneThisOne() {
        Measure measure = new Measure(Arrays.asList(noteA0));
        assertFalse(measure.equals(Arrays.asList(noteA0)));
    }
    
    // equals(): thatObject is not a Bar, thatObject contains >1 elements, this contains >1 elements
    @Test
    public void measureEqualsNotBarThatTwoThisTwo() {
        Measure measure = new Measure(Arrays.asList(noteA0, noteB6));
        assertFalse(measure.equals(Arrays.asList(noteA0, noteB6)));
    }
    
    // hashCode(): measure contains 0 elements
    @Test
    public void measureHashCodeZeroElements() {
        Measure measure = new Measure(new ArrayList<>());
        assertEquals(0, measure.hashCode());
    }
    
    // hashCode(): measure contains 1 elements
    @Test
    public void measureHashCodeOneElement() {
        Measure measure = new Measure(Arrays.asList(noteA0));
        assertEquals(1+noteA0.hashCode(), measure.hashCode());
    }
    
    // hashCode(): measure contains >1 elements
    @Test
    public void measureHashCodeTwoElements() {
        Measure measure = new Measure(Arrays.asList(noteA0,noteA6,noteA12));
        assertEquals(3+noteA0.hashCode()+noteA6.hashCode()+noteA12.hashCode(), measure.hashCode());
    }
    
    
    
    
    //
    // ConcatBar
    //
    // duration()
    // Test partitions:
    //    contains 0, 1, 2 Measure objects
    //    contains 0, 1, 2 ConcatBar objects
    //    contains repeat, doesn't contain repeats
    //    contains alternate endings, doesn't contain alternate endings
    //
    // transpose()
    // Test partitions:
    //    concatBar's elements contains accidentals, measure does not contain accidentals
    //    transpose's semitonesUp is <0, 0, >0
    //    contains repeat, doesn't contain repeats
    //    contains alternate endings, doesn't contain alternate endings
    //
    // play()
    // Test partitions:
    //    measure's elements contains accidentals, measure does not contain accidentals
    //    atTick =0, >0
    //    contains repeat, doesn't contain repeats
    //    contains alternate endings, doesn't contain alternate endings
    //
    // equals()
    // Test partitions:
    //    thatObject is a Measure, is a ConcatBar, is not a Bar
    //    contains repeat, doesn't contain repeats
    //    contains alternate endings, doesn't contain alternate endings
    //
    // hashCode()
    // Test partitions:
    //    contains repeat, doesn't contain repeats
    //    contains alternate endings, doesn't contain alternate endings
    //
    
    private final Measure measure1 = new Measure(Arrays.asList(noteA0,noteB6,noteA12,noteB18));
    private final Measure measure2 = new Measure(Arrays.asList(chordAB0,noteA6,noteB12,noteA18));
    private final Measure measure3 = new Measure(Arrays.asList(tupletABC0,noteBb6,noteC12,noteBb18));
    private final ConcatBar concatBar1 = new ConcatBar(measure1,measure2, false);
    private final ConcatBar concatBar2 = new ConcatBar(measure1,measure2,true);
    private final ConcatBar concatBar3 = new ConcatBar(measure1,measure2,measure3,false);
    private final ConcatBar concatBar4 = new ConcatBar(measure1,measure2,measure3,true);
    
    // duration(): ConcatBar object contains >1 measure objects, 0 ConcatBar objects, no repeats, no alternate endings
    @Test
    public void concatBarDurationZeroElementsOne() {
        assertEquals(24*2,concatBar1.duration());
    }
    
    // duration(): ConcatBar object contains >1 measure objects, 0 ConcatBar objects, repeats, no alternate endings
    @Test
    public void concatBarDurationZeroElementsTwo() {
        assertEquals(24*4,concatBar2.duration());
    }
    
    // duration(): ConcatBar object contains >1 measure objects, 0 ConcatBar objects, no repeats, alternate endings
    @Test
    public void concatBarDurationZeroElementsThree() {
        assertEquals(24*2,concatBar3.duration());
    }
    
    // duration(): ConcatBar object contains >1 measure objects, 0 ConcatBar objects, repeats, alternate endings
    @Test
    public void concatBarDurationZeroElementsFour() {
        assertEquals(24*4,concatBar4.duration());
    }
    
    // duration(): ConcatBar object contains 1 measure objects, 1 ConcatBar objects, no repeats, no alternate endings
    @Test
    public void concatBarDurationOneElementOne() {
        ConcatBar concatBarToTest1 = new ConcatBar(concatBar1,measure1,false);
        ConcatBar concatBarToTest2 = new ConcatBar(concatBar2,measure1,false);
        ConcatBar concatBarToTest3 = new ConcatBar(concatBar3,measure1,false);
        ConcatBar concatBarToTest4 = new ConcatBar(concatBar4,measure1,false);
        ConcatBar concatBarToTest5 = new ConcatBar(measure1,concatBar1,false);
        ConcatBar concatBarToTest6 = new ConcatBar(measure1,concatBar2,false);
        ConcatBar concatBarToTest7 = new ConcatBar(measure1,concatBar3,false);
        ConcatBar concatBarToTest8 = new ConcatBar(measure1,concatBar4,false);
        assertEquals(24*3,concatBarToTest1.duration());
        assertEquals(24*5,concatBarToTest2.duration());
        assertEquals(24*3,concatBarToTest3.duration());
        assertEquals(24*5,concatBarToTest4.duration());
        assertEquals(24*3,concatBarToTest5.duration());
        assertEquals(24*5,concatBarToTest6.duration());
        assertEquals(24*3,concatBarToTest7.duration());
        assertEquals(24*5,concatBarToTest8.duration());
    }
    
    // duration(): ConcatBar object contains 1 measure objects, 1 ConcatBar objects, repeats, no alternate endings
    @Test
    public void concatBarDurationOneElementTwo() {
        ConcatBar concatBarToTest1 = new ConcatBar(concatBar1,measure1,true);
        ConcatBar concatBarToTest2 = new ConcatBar(concatBar2,measure1,true);
        ConcatBar concatBarToTest3 = new ConcatBar(concatBar3,measure1,true);
        ConcatBar concatBarToTest4 = new ConcatBar(concatBar4,measure1,true);
        ConcatBar concatBarToTest5 = new ConcatBar(measure1,concatBar1,true);
        ConcatBar concatBarToTest6 = new ConcatBar(measure1,concatBar2,true);
        ConcatBar concatBarToTest7 = new ConcatBar(measure1,concatBar3,true);
        ConcatBar concatBarToTest8 = new ConcatBar(measure1,concatBar4,true);
        assertEquals(24*6,concatBarToTest1.duration());
        assertEquals(24*10,concatBarToTest2.duration());
        assertEquals(24*6,concatBarToTest3.duration());
        assertEquals(24*10,concatBarToTest4.duration());
        assertEquals(24*6,concatBarToTest5.duration());
        assertEquals(24*10,concatBarToTest6.duration());
        assertEquals(24*6,concatBarToTest7.duration());
        assertEquals(24*10,concatBarToTest8.duration());
    }
    
    // duration(): ConcatBar object contains 1 measure objects, 1 ConcatBar objects, no repeats, alternate endings
    @Test
    public void concatBarDurationOneElementThree() {
        ConcatBar concatBarToTest1 = new ConcatBar(concatBar1,measure1,measure1,false);
        ConcatBar concatBarToTest2 = new ConcatBar(concatBar2,measure1,measure1,false);
        ConcatBar concatBarToTest3 = new ConcatBar(concatBar3,measure1,measure1,false);
        ConcatBar concatBarToTest4 = new ConcatBar(concatBar4,measure1,measure1,false);
        ConcatBar concatBarToTest5 = new ConcatBar(measure1,concatBar1,measure1,false);
        ConcatBar concatBarToTest6 = new ConcatBar(measure1,concatBar2,measure1,false);
        ConcatBar concatBarToTest7 = new ConcatBar(measure1,concatBar3,measure1,false);
        ConcatBar concatBarToTest8 = new ConcatBar(measure1,concatBar4,measure1,false);
        assertEquals(24*3,concatBarToTest1.duration());
        assertEquals(24*5,concatBarToTest2.duration());
        assertEquals(24*3,concatBarToTest3.duration());
        assertEquals(24*5,concatBarToTest4.duration());
        assertEquals(24*3,concatBarToTest5.duration());
        assertEquals(24*5,concatBarToTest6.duration());
        assertEquals(24*3,concatBarToTest7.duration());
        assertEquals(24*5,concatBarToTest8.duration());
    }
    
    // duration(): ConcatBar object contains 1 measure objects, 1 ConcatBar objects, repeats, alternate endings
    @Test
    public void concatBarDurationOneElementFour() {
        ConcatBar concatBarToTest1 = new ConcatBar(concatBar1,measure1,measure1,true);
        ConcatBar concatBarToTest2 = new ConcatBar(concatBar2,measure1,measure1,true);
        ConcatBar concatBarToTest3 = new ConcatBar(concatBar3,measure1,measure1,true);
        ConcatBar concatBarToTest4 = new ConcatBar(concatBar4,measure1,measure1,true);
        ConcatBar concatBarToTest5 = new ConcatBar(measure1,concatBar1,measure1,true);
        ConcatBar concatBarToTest6 = new ConcatBar(measure1,concatBar2,measure1,true);
        ConcatBar concatBarToTest7 = new ConcatBar(measure1,concatBar3,measure1,true);
        ConcatBar concatBarToTest8 = new ConcatBar(measure1,concatBar4,measure1,true);
        assertEquals(24*6,concatBarToTest1.duration());
        assertEquals(24*10,concatBarToTest2.duration());
        assertEquals(24*6,concatBarToTest3.duration());
        assertEquals(24*10,concatBarToTest4.duration());
        assertEquals(24*5,concatBarToTest5.duration());
        assertEquals(24*7,concatBarToTest6.duration());
        assertEquals(24*5,concatBarToTest7.duration());
        assertEquals(24*7,concatBarToTest8.duration());
    }
    
    // duration(): ConcatBar object contains 0 measure objects, >1 ConcatBar objects, no repeats, no alternate endings
    @Test
    public void concatBarDurationTwoElementsOne() {
        ConcatBar concatBarToTest1 = new ConcatBar(concatBar1,concatBar1,false);
        ConcatBar concatBarToTest2 = new ConcatBar(concatBar2,concatBar1,false);
        ConcatBar concatBarToTest3 = new ConcatBar(concatBar3,concatBar1,false);
        ConcatBar concatBarToTest4 = new ConcatBar(concatBar4,concatBar1,false);
        ConcatBar concatBarToTest5 = new ConcatBar(concatBar1,concatBar1,false);
        ConcatBar concatBarToTest6 = new ConcatBar(concatBar1,concatBar2,false);
        ConcatBar concatBarToTest7 = new ConcatBar(concatBar1,concatBar3,false);
        ConcatBar concatBarToTest8 = new ConcatBar(concatBar1,concatBar4,false);
        assertEquals(24*4,concatBarToTest1.duration());
        assertEquals(24*6,concatBarToTest2.duration());
        assertEquals(24*4,concatBarToTest3.duration());
        assertEquals(24*6,concatBarToTest4.duration());
        assertEquals(24*4,concatBarToTest5.duration());
        assertEquals(24*6,concatBarToTest6.duration());
        assertEquals(24*4,concatBarToTest7.duration());
        assertEquals(24*6,concatBarToTest8.duration());
    }
    
    // duration(): ConcatBar object contains 0 measure objects, >1 ConcatBar objects, repeats, no alternate endings
    @Test
    public void concatBarDurationTwoElementsTwo() {
        ConcatBar concatBarToTest1 = new ConcatBar(concatBar1,concatBar1,true);
        ConcatBar concatBarToTest2 = new ConcatBar(concatBar2,concatBar1,true);
        ConcatBar concatBarToTest3 = new ConcatBar(concatBar3,concatBar1,true);
        ConcatBar concatBarToTest4 = new ConcatBar(concatBar4,concatBar1,true);
        ConcatBar concatBarToTest5 = new ConcatBar(concatBar1,concatBar1,true);
        ConcatBar concatBarToTest6 = new ConcatBar(concatBar1,concatBar2,true);
        ConcatBar concatBarToTest7 = new ConcatBar(concatBar1,concatBar3,true);
        ConcatBar concatBarToTest8 = new ConcatBar(concatBar1,concatBar4,true);
        assertEquals(24*8,concatBarToTest1.duration());
        assertEquals(24*12,concatBarToTest2.duration());
        assertEquals(24*8,concatBarToTest3.duration());
        assertEquals(24*12,concatBarToTest4.duration());
        assertEquals(24*8,concatBarToTest5.duration());
        assertEquals(24*12,concatBarToTest6.duration());
        assertEquals(24*8,concatBarToTest7.duration());
        assertEquals(24*12,concatBarToTest8.duration());
    }
    
    // duration(): ConcatBar object contains 0 measure objects, >1 ConcatBar objects, no repeats, alternate endings
    @Test
    public void concatBarDurationTwoElementsThree() {
        ConcatBar concatBarToTest1 = new ConcatBar(concatBar1,concatBar1,concatBar1,false);
        ConcatBar concatBarToTest2 = new ConcatBar(concatBar2,concatBar1,concatBar1,false);
        ConcatBar concatBarToTest3 = new ConcatBar(concatBar3,concatBar1,concatBar1,false);
        ConcatBar concatBarToTest4 = new ConcatBar(concatBar4,concatBar1,concatBar1,false);
        ConcatBar concatBarToTest5 = new ConcatBar(concatBar1,concatBar1,concatBar1,false);
        ConcatBar concatBarToTest6 = new ConcatBar(concatBar1,concatBar2,concatBar1,false);
        ConcatBar concatBarToTest7 = new ConcatBar(concatBar1,concatBar3,concatBar1,false);
        ConcatBar concatBarToTest8 = new ConcatBar(concatBar1,concatBar4,concatBar1,false);
        assertEquals(24*4,concatBarToTest1.duration());
        assertEquals(24*6,concatBarToTest2.duration());
        assertEquals(24*4,concatBarToTest3.duration());
        assertEquals(24*6,concatBarToTest4.duration());
        assertEquals(24*4,concatBarToTest5.duration());
        assertEquals(24*6,concatBarToTest6.duration());
        assertEquals(24*4,concatBarToTest7.duration());
        assertEquals(24*6,concatBarToTest8.duration());
    }
    
    // duration(): ConcatBar object contains 0 measure objects, >1 ConcatBar objects, repeats, alternate endings
    @Test
    public void concatBarDurationTwoElementsFour() {
        ConcatBar concatBarToTest1 = new ConcatBar(concatBar1,concatBar1,concatBar1,true);
        ConcatBar concatBarToTest2 = new ConcatBar(concatBar2,concatBar1,concatBar1,true);
        ConcatBar concatBarToTest3 = new ConcatBar(concatBar3,concatBar1,concatBar1,true);
        ConcatBar concatBarToTest4 = new ConcatBar(concatBar4,concatBar1,concatBar1,true);
        ConcatBar concatBarToTest5 = new ConcatBar(concatBar1,concatBar1,concatBar1,true);
        ConcatBar concatBarToTest6 = new ConcatBar(concatBar1,concatBar2,concatBar1,true);
        ConcatBar concatBarToTest7 = new ConcatBar(concatBar1,concatBar3,concatBar1,true);
        ConcatBar concatBarToTest8 = new ConcatBar(concatBar1,concatBar4,concatBar1,true);
        assertEquals(24*8,concatBarToTest1.duration());
        assertEquals(24*12,concatBarToTest2.duration());
        assertEquals(24*8,concatBarToTest3.duration());
        assertEquals(24*12,concatBarToTest4.duration());
        assertEquals(24*8,concatBarToTest5.duration());
        assertEquals(24*10,concatBarToTest6.duration());
        assertEquals(24*8,concatBarToTest7.duration());
        assertEquals(24*10,concatBarToTest8.duration());
    }
    
    // transpose(): measure contains accidentals, semitonesUp <0, no repeats, no alternate endings
    @Test
    public void concatBarTransposeSemitonesNegOne() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,false);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(-1),measure2.transpose(-1),false);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(-1));
    }
    
    // transpose(): measure contains accidentals, semitonesUp <0, repeats, no alternate endings
    @Test
    public void concatBarTransposeSemitonesNegTwo() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,true);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(-1),measure2.transpose(-1),true);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(-1));
    }
    
    // transpose(): measure contains accidentals, semitonesUp <0, no repeats, alternate endings
    @Test
    public void concatBarTransposeSemitonesNegThree() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,measure3,false);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(-1),measure2.transpose(-1),measure3.transpose(-1),false);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(-1));
    }
    
    // transpose(): measure contains accidentals, semitonesUp <0, repeats, alternate endings
    @Test
    public void concatBarTransposeSemitonesNegFour() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,measure3,true);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(-1),measure2.transpose(-1),measure3.transpose(-1),true);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(-1));
    }
    
    
    
    
    // transpose(): measure contains accidentals, semitonesUp =0, no repeats, no alternate endings
    @Test
    public void concatBarTransposeSemitonesZeroOne() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,false);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(0),measure2.transpose(0),false);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(0));
    }
    
    // transpose(): measure contains accidentals, semitonesUp =0, repeats, no alternate endings
    @Test
    public void concatBarTransposeSemitonesZeroTwo() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,true);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(0),measure2.transpose(0),true);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(0));
    }
    
    // transpose(): measure contains accidentals, semitonesUp =0, no repeats, alternate endings
    @Test
    public void concatBarTransposeSemitonesZeroThree() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,measure3,false);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(0),measure2.transpose(0),measure3.transpose(0),false);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(0));
    }
    
    // transpose(): measure contains accidentals, semitonesUp =0, repeats, alternate endings
    @Test
    public void concatBarTransposeSemitonesZeroFour() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,measure3,true);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(0),measure2.transpose(0),measure3.transpose(0),true);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(0));
    }
    
    // transpose(): measure contains accidentals, semitonesUp >0, no repeats, no alternate endings
    @Test
    public void concatBarTransposeSemitonesPosOne() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,false);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(1),measure2.transpose(1),false);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(1));
    }
    
    // transpose(): measure contains accidentals, semitonesUp >0, repeats, no alternate endings
    @Test
    public void concatBarTransposeSemitonesPosTwo() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,true);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(1),measure2.transpose(1),true);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(1));
    }
    
    // transpose(): measure contains accidentals, semitonesUp >0, no repeats, alternate endings
    @Test
    public void concatBarTransposeSemitonesPosThree() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,measure3,false);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(1),measure2.transpose(1),measure3.transpose(1),false);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(1));
    }
    
    // transpose(): measure contains accidentals, semitonesUp >0, repeats, alternate endings
    @Test
    public void concatBarTransposeSemitonesPosFour() {
        ConcatBar concatBarToTest = new ConcatBar(measure1,measure2,measure3,true);
        ConcatBar concatBarToTestCorrect = new ConcatBar(measure1.transpose(1),measure2.transpose(1),measure3.transpose(1),true);
        assertEquals(concatBarToTestCorrect,concatBarToTest.transpose(1));
    }    
    
    // equals(): thatObject is a Measure, no repeat, no alternate endings
    @Test
    public void concatBarEqualsMeasureOne() {
        ConcatBar thisObject = new ConcatBar(concatBar1, concatBar2, false);
        Measure thatObject = measure1;
        assertFalse(thisObject.equals(thatObject));
    }

    // equals(): thatObject is a Measure, repeat, no alternate endings
    @Test
    public void concatBarEqualsMeasureTwo() {
        ConcatBar thisObject = new ConcatBar(concatBar1, concatBar2, true);
        Measure thatObject = measure1;
        assertFalse(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, no repeat, alternate endings
    @Test
    public void concatBarEqualsMeasureThree() {
        ConcatBar thisObject = new ConcatBar(concatBar1, concatBar2, false);
        Measure thatObject = measure1;
        assertFalse(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, repeat, alternate endings
    @Test
    public void concatBarEqualsMeasureFour() {
        ConcatBar thisObject = new ConcatBar(concatBar1, concatBar2, false);
        Measure thatObject = measure1;
        assertFalse(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, no repeat, no alternate endings
    @Test
    public void concatBarEqualsConcatBarOne() {
        ConcatBar thisObject = new ConcatBar(concatBar1, concatBar2, false);
        ConcatBar thatObject = new ConcatBar(concatBar1, concatBar2, false);
        assertTrue(thisObject.equals(thatObject));
    }

    // equals(): thatObject is a Measure, repeat, no alternate endings
    @Test
    public void concatBarEqualsConcatBarTwo() {
        ConcatBar thisObject = new ConcatBar(concatBar1, concatBar2, false);
        ConcatBar thatObject = new ConcatBar(concatBar1, concatBar2, false);
        assertTrue(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, no repeat, alternate endings
    @Test
    public void concatBarEqualsConcatBarThree() {
        ConcatBar thisObject = new ConcatBar(concatBar1, concatBar2, false);
        ConcatBar thatObject = new ConcatBar(concatBar1, concatBar2, false);
        assertTrue(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is a Measure, repeat, alternate endings
    @Test
    public void concatBarEqualsConcatBarFour() {
        ConcatBar thisObject = new ConcatBar(concatBar1, concatBar2, false);
        ConcatBar thatObject = new ConcatBar(concatBar1, concatBar2, false);
        assertTrue(thisObject.equals(thatObject));
    }
    
    // equals(): thatObject is not a Bar
    @Test
    public void concatBarEqualsNotBar() {
        ConcatBar thisObject = new ConcatBar(concatBar1, concatBar2, false);
        String thatObject = "incorrect";
        assertFalse(thisObject.equals(thatObject));
    }
    
    // hashCode(): concatBar no repeat, no alternate endings
    @Test
    public void concatBarHashCodeOne() {
        ConcatBar concatBar = new ConcatBar(concatBar1, concatBar2, false);
        assertEquals(concatBar1.hashCode()+concatBar2.hashCode(), concatBar.hashCode());
    }
    
    // hashCode(): concatBar repeat, no alternate endings
    @Test
    public void concatBarHashCodeTwo() {
        ConcatBar concatBar = new ConcatBar(concatBar1, concatBar2, true);
        assertEquals(concatBar1.hashCode()+2*concatBar2.hashCode(), concatBar.hashCode());
    }
    
    // hashCode(): concatBar no repeat, alternate endings
    @Test
    public void concatBarHashCodeThird() {
        ConcatBar concatBar = new ConcatBar(concatBar1, concatBar2, concatBar3, false);
        assertEquals(concatBar1.hashCode()+concatBar2.hashCode(), concatBar.hashCode());
    }
    
    // hashCode(): concatBar repeat, alternate endings
    @Test
    public void concatBarHashCodeFour() {
        ConcatBar concatBar = new ConcatBar(concatBar1, concatBar2, concatBar3, true);
        assertEquals(concatBar1.hashCode()+concatBar2.hashCode()+concatBar3.hashCode(), concatBar.hashCode());
    }
    
}