package abc.sound.Listeners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import abc.parser.AbcListener;
import abc.parser.AbcParser.AbcmusicContext;
import abc.parser.AbcParser.ChordContext;
import abc.parser.AbcParser.DenominatorContext;
import abc.parser.AbcParser.ElementContext;
import abc.parser.AbcParser.FirstbarlineContext;
import abc.parser.AbcParser.MeasureContext;
import abc.parser.AbcParser.MeasureandbarContext;
import abc.parser.AbcParser.NoteContext;
import abc.parser.AbcParser.NotelengthContext;
import abc.parser.AbcParser.NotelengthstrictContext;
import abc.parser.AbcParser.NumeratorContext;
import abc.parser.AbcParser.PitchContext;
import abc.parser.AbcParser.RootContext;
import abc.parser.AbcParser.TupletelementContext;
import abc.parser.AbcParser.TupletspecContext;
import abc.sound.ADTs.Bar;
import abc.sound.ADTs.ConcatBar;
import abc.sound.ADTs.ConcatElement;
import abc.sound.ADTs.Element;
import abc.sound.ADTs.Measure;
import abc.sound.ADTs.Note;
import abc.sound.ClassCodeUsed.Pitch;

/** Makes a Bar object containing music representing a single voice/instrument. **/
public class MakeMusic implements AbcListener {

    // Abstraction function:
    // - Represents complete musical instrument/voice as a single
    //   Bar instance which contains all necessary information to play, transpose,
    //   etc. the single-voice music
    //
    // Representation invariant:
    // - keyText is a string of one of the following:
    //       C,  G,  D,  A,   E,   B,   F#,  C#,  F,  Bb, Eb, Ab, Db,  Gb,  Cb
    //       Am, Em, Bm, F#m, C#m, G#m, D#m, A#m, Dm, Gm, Cm, Fm, Bbm, Ebm, Abm
    // - ticksPerBeat >= 1
    // - chordTimeIncrement >= 0
    // - tupletType = 0,2, 3, or 4
    // - t >= 0
    // - noteLength >= 0
    // - bars.size() >= 0, as stack can be empty for empty abc body and can be empty when
    //   popping and pushing to recombine Bar objects
    //
    // Safety from representation exposure:
    // - all fields that are not private and final are never returned and used internally to walk
    //   the tree
    // - only a Bar object is every returned, which is immutable and is constructed of
    //   other immutable types (Element objects, Pitch objects, and integers at the lowest levels)
    
    public enum Type { NOTE, CHORD, TUPLET }
    private static Set<String> keys = new HashSet<String>(Arrays.asList(
            "C","G","D","A","E","B","F#","C#","F","Bb","Eb","Ab","Db","Gb","Cb",
            "Am","Em","Bm","F#m","C#m","G#m","D#m","A#m","Dm","Gm","Cm","Fm","Bbm","Ebm","Abm"));
    
    private final String keyText;
    private final int ticksPerBeat;
    private final int numL;
    private final int denL;
    private final int numQ;
    private final int denQ;

    private final Map<Pitch, Integer> key = new HashMap<Pitch, Integer>();  
    private final Map<Pitch, Integer> measureNoteModifications = new HashMap<Pitch, Integer>(); 
    private Type noteChordOrTupletPrevious = Type.NOTE;
    private Type noteChordOrTuplet = Type.NOTE;
    private boolean firstNoteOfChord = false;
    int chordTimeIncrement = 0;
    private int tupletType = 0;
    private int t = 0;
    private double noteLength = 0;
    private Pitch pitch;

    private final LinkedList<Element> elementsInMeasure = new LinkedList<Element>();

    private final Stack<Bar> bars = new Stack<Bar>();

    /**
     * Parses music fed to it and creates a bar object to contain the data
     * @param keyText 
     * @param ticksPerBeat 
     */
    public MakeMusic(String keyText, int ticksPerBeat, int numL, int denL, int numQ, int denQ) {
        this.keyText = keyText;
        this.ticksPerBeat = ticksPerBeat;
        this.numL = numL;
        this.denL = denL;
        this.numQ = numQ;
        this.denQ = denQ;
        checkRep();
    }

    /**
     * Makes sure the representation invariant is obeyed
     */
    private void checkRep() {
        assert(keys.contains(keyText));
        assert(ticksPerBeat >= 1);
        assert(chordTimeIncrement >= 0);
        assert(tupletType==0 | tupletType==2 | tupletType==3 | tupletType==4);
        assert(t >= 0);
        assert(noteLength >= 0);
        assert(bars.size() >= 0);
    }
    
    /**
     * @return complete Bar for voice parsed by MakeMusic
     */
    public Bar getBar() {
        checkRep();
        return bars.get(0);
    }

    /**
     * Initializes the map 'key' with Pitches mapped to the correct transpose
     *      based on the keyText
     * Used in enterRoot()
     */
    private Map<Pitch, Integer> initializeKey(){
        List<Integer> listValues = new ArrayList<Integer>();

        switch(keyText) {
            case "G":
            case "Em":
                listValues = Arrays.asList( 1, 0, 0, 0, 0, 0, 0);
                break;
            case "D":
            case "Bm":
                listValues = Arrays.asList( 1, 1, 0, 0, 0, 0, 0);
                break;
            case "A":
            case "F#m":
                listValues = Arrays.asList( 1, 1, 1, 0, 0, 0, 0);
                break;
            case "E":
            case "C#m":
                listValues = Arrays.asList( 1, 1, 1, 1, 0, 0, 0);
                break;
            case "B":
            case "G#m":
                listValues = Arrays.asList( 1, 1, 1, 1, 1, 0, 0);
                break;
            case "F#":
            case "D#m":
                listValues = Arrays.asList( 1, 1, 1, 1, 1, 1, 0);
                break;
            case "C#":
            case "A#m":
                listValues = Arrays.asList( 1, 1, 1, 1, 1, 1, 1);
                break;
            case "Cb":
            case "Abm":
                listValues = Arrays.asList(-1,-1,-1,-1,-1,-1,-1);
                break;
            case "Gb":
            case "Ebm":
                listValues = Arrays.asList( 0,-1,-1,-1,-1,-1,-1);
                break;
            case "Db":
            case "Bbm":
                listValues = Arrays.asList( 0, 0,-1,-1,-1,-1,-1);
                break;
            case "Ab":
            case "Fm":
                listValues = Arrays.asList( 0, 0, 0,-1,-1,-1,-1);
                break;
            case "Eb":
            case "Cm":
                listValues = Arrays.asList( 0, 0, 0, 0,-1,-1,-1);
                break;
            case "Bb":
            case "Gm":
                listValues = Arrays.asList( 0, 0, 0, 0, 0,-1,-1);
                break;
            case "F":
            case"Dm":
                listValues = Arrays.asList( 0, 0, 0, 0, 0, 0,-1);
                break;
            case "C":
            case"Am":
                listValues = Arrays.asList( 0, 0, 0, 0, 0, 0, 0);
                break;
        }

        List<Pitch> listPitches = Arrays.asList(new Pitch('F'),new Pitch('C'),new Pitch('G'),new Pitch('D'),new Pitch('A'),new Pitch('E'),new Pitch('B'));
        Map<Pitch, Integer> keyMap = new HashMap<Pitch, Integer>();
        int counter = 0;
        while (counter < 7){
            keyMap.put(listPitches.get(counter), listValues.get(counter));
            counter += 1;
        }
        checkRep();
        return Collections.unmodifiableMap(keyMap);
    }

    @Override
    public void enterAbcmusic(AbcmusicContext ctx) {
        Map<Pitch,Integer> keyTemp = initializeKey();
        for (Pitch pitch : keyTemp.keySet()) {
            this.key.put(pitch, keyTemp.get(pitch));
        }
        checkRep();
    }

    @Override
    public void exitAbcmusic(AbcmusicContext ctx) {
        if ((ctx.BARLINE() != null) && (ctx.BARLINE().getText().equals(":|"))) {
            Bar barNoNthRepeat = bars.pop();
            bars.push(new ConcatBar(barNoNthRepeat, new Measure(new ArrayList<>()), true));
        }
        int barsLength = bars.size();
        Stack<Bar> tempStack = new Stack<Bar>();
        for (int i = 0 ; i < barsLength ; i++) {
            tempStack.push(bars.pop());
        }
        while(tempStack.size() != 1) {
            Bar bar1 = tempStack.pop();
            Bar bar2 = tempStack.pop();
            tempStack.push(new ConcatBar(bar1, bar2, false));
        }
        bars.push(tempStack.pop());
        checkRep();
    }

    @Override
    public void exitMeasureandbar(MeasureandbarContext ctx) {
        if ((ctx.NTHREPEAT() != null) && (ctx.NTHREPEAT().getText().equals("[1"))) {
            // do nothing so stack becomes 1 Bar deeper, initializing firstEnding for alternate endings repeat    
        } else if (ctx.BARLINE().getText().equals("|")) {
            // concat previous bar and current bar
            Bar bar2 = bars.pop();
            Bar bar1 = bars.pop();
            bars.push(new ConcatBar(bar1, bar2, false));
        } else if ((ctx.NTHREPEAT() != null) && (ctx.NTHREPEAT().getText().equals("[2"))) {
            // concat bars to create alternate endings
            Bar secondEnding = bars.pop();
            Bar firstEnding = bars.pop();
            Bar base = bars.pop();
            bars.push(new ConcatBar(base, firstEnding, secondEnding, true));
        } else if (ctx.BARLINE().getText().equals(":|")) {
            // create repeat for previous bar
            Bar temp = bars.pop();
            Bar barNoNthRepeat = bars.pop();
            bars.push(new ConcatBar(barNoNthRepeat, new Measure(new ArrayList<>()), true));
            bars.push(temp);
        } else if (ctx.BARLINE().getText().equals("|]") || ctx.BARLINE().getText().equals("[|")
                || ctx.BARLINE().getText().equals("||") || ctx.BARLINE().getText().equals("|:")) {
            // do nothing so stack becomes 1 Bar deeper, initializing base for repeat
        }
        checkRep();
    }

    @Override
    public void enterMeasure(MeasureContext ctx) { 
        for (Pitch pitch : key.keySet()) {
            measureNoteModifications.put(pitch, key.get(pitch));
        }
        elementsInMeasure.clear();
        t = 0;
        checkRep();
    }

    @Override
    public void exitMeasure(MeasureContext ctx) {
        bars.push(new Measure(elementsInMeasure));
        checkRep();
    }

    @Override
    public void exitNote(NoteContext ctx) {
        
        int noteDuration;
        // for noteChordOrTuplet == NOTE
        if (ctx.notelength() != null){
            final int duration = (int)(this.noteLength * ticksPerBeat);
            noteDuration = duration;
        } else {
            noteDuration = ticksPerBeat;
        }

        //In the case of a duplet, 3/2 of the original durations. 
        //For a triplet, 2/3 of the original duration. 
        //And for a quadruplet, 3/4 of the original durations.
        if (noteChordOrTuplet.equals(Type.TUPLET) 
                || (noteChordOrTupletPrevious.equals(Type.TUPLET) && noteChordOrTuplet.equals(Type.TUPLET))){
            if (tupletType == 2) {
                noteDuration = (3 * noteDuration) / 2;
            } else if (tupletType == 3) {
                noteDuration = (2 * noteDuration) / 3;
            } else {
                noteDuration = (3 * noteDuration) / 4;
            }
            //assert(!firstNoteOfChord); // tuplet should not be in a chord
        } else if (firstNoteOfChord){
            chordTimeIncrement = noteDuration;
            firstNoteOfChord = false;
        }
        noteDuration = (noteDuration * numL * denQ) / (denL * numQ);
        if (ctx.REST() != null && ctx.REST().getText().equals("z")) {
            elementsInMeasure.addLast(new Note(t, noteDuration));
        }
        else {
            elementsInMeasure.addLast(new Note(this.pitch, t, noteDuration));
        }
        
        if (!noteChordOrTuplet.equals(Type.CHORD)){ //Not a chord (as t incremented in exitChord() )
            t += noteDuration;
        }
        checkRep();
    }
    
    @Override
    public void exitPitch(PitchContext ctx) { 
        String basenote = ctx.BASENOTE().getText();
        Pitch basePitch = new Pitch(basenote.toUpperCase().charAt(0));
        if (ctx.ACCIDENTAL() != null){
            int transposeAmount = individualTransposeAmount(ctx);
            measureNoteModifications.put(basePitch, transposeAmount);
        }
        this.pitch = basePitch.transpose(measureNoteModifications.get(basePitch));

        int octaveTranposeAmount = 0;
        if (basenote.equals(basenote.toLowerCase())) {
            octaveTranposeAmount = Pitch.OCTAVE;
        }
        if (ctx.OCTAVE() != null) {
            String octave = ctx.OCTAVE().getText();
            if (octave.charAt(0) == '\''){
                octaveTranposeAmount += octave.length() * Pitch.OCTAVE;
            }
            else {
                octaveTranposeAmount += octave.length() * -Pitch.OCTAVE;
            }
        }
        this.pitch = this.pitch.transpose(octaveTranposeAmount);
        checkRep();
    }

    /**
     * When exiting Pitch node, this method is run to check if the Pitch
     *      has to be transposed by an accidental or octave according to 
     *      the abc music sheet
     * Used in exitPitch()
     * @param ctx the context of the Pitch node being exited, ctx.ACCIDENTAL() cannot
     *     be null
     * @return the amount by which this Pitch must be transposed
     */
    private int individualTransposeAmount(PitchContext ctx){
        String accidental = ctx.ACCIDENTAL().getText();
        int transposeAmount = 0;
        if (accidental.equals("^")) {
            transposeAmount = 1;
        } else if (accidental.equals("^^")) {
            transposeAmount = 2;
        } else if (accidental.equals("_")) {
            transposeAmount = -1;
        } else if (accidental.equals("__")) {
            transposeAmount = -2;
        } else if (accidental.equals("=")) {
            transposeAmount = 0;
        }
        return transposeAmount;
    }

    @Override
    public void exitNotelength(NotelengthContext ctx) {
        double denominator = ctx.children.toString().contains("/") ? 2.0 : 1.0;
        double numerator = 1.0;
        if (ctx.numerator() != null) {
            numerator = Double.parseDouble(ctx.numerator().getText());
        }
        if (ctx.denominator() != null) {
            denominator = Double.parseDouble(ctx.denominator().getText());
        }
        this.noteLength = numerator / denominator;
        checkRep();
    }

    @Override
    public void enterTupletelement(TupletelementContext ctx) { 
        noteChordOrTupletPrevious = noteChordOrTuplet;
        noteChordOrTuplet = Type.TUPLET;
        tupletType = 0;
        checkRep();
    }
    
    @Override
    public void exitTupletelement(TupletelementContext ctx) { 
        noteChordOrTuplet = Type.NOTE;
        noteChordOrTupletPrevious = Type.NOTE;
        int notesInTuplet = tupletType; //-2 for the '[', ']'
        int index = elementsInMeasure.size() - notesInTuplet;
        Element firstNote = elementsInMeasure.remove(index);
        Element imaginaryRest = new Note(firstNote.start(), firstNote.duration());
        Element tuplet = new ConcatElement(firstNote, imaginaryRest);
        int counter = 1;
        while (counter != notesInTuplet){
            Element nextNote = elementsInMeasure.remove(index);
            tuplet = new ConcatElement(tuplet, nextNote);
            counter += 1;
        }
        elementsInMeasure.add(tuplet);
        checkRep();
    }

    @Override
    public void exitTupletspec(TupletspecContext ctx) { 
        tupletType = Integer.parseInt(ctx.DIGIT().getText());
    }

    @Override
    public void enterChord(ChordContext ctx) { 
        firstNoteOfChord = true;
        noteChordOrTupletPrevious = noteChordOrTuplet;
        noteChordOrTuplet = Type.CHORD;
        checkRep();
    }

    @Override
    public void exitChord(ChordContext ctx) {
        noteChordOrTuplet = noteChordOrTupletPrevious;
        t += chordTimeIncrement;

        int notesInChord = ctx.children.size()-2-ctx.WHITESPACE().size(); // ignores [, ], and whitespace
        int index = elementsInMeasure.size() - notesInChord;
        if (notesInChord > 1) {
            Note firstNote = (Note) elementsInMeasure.remove(index);
            Note secondNote = (Note) elementsInMeasure.remove(index);
            ConcatElement chord = new ConcatElement(firstNote, secondNote);
            for (int counter = 2 ; counter < notesInChord ; counter++){
                Element nextNote = elementsInMeasure.remove(index);
                chord = new ConcatElement(chord, nextNote);
            }
            elementsInMeasure.add(chord);    
        } // Else, do nothing, leave Note in list
        checkRep();
    }

    // Unused methods
    @Override public void enterPitch(PitchContext ctx) { }
    @Override public void enterTupletspec(TupletspecContext ctx) { }
    @Override public void enterNotelengthstrict(NotelengthstrictContext ctx) { }
    @Override public void exitNotelengthstrict(NotelengthstrictContext ctx) { }
    @Override public void enterNumerator(NumeratorContext ctx) { }
    @Override public void exitNumerator(NumeratorContext ctx) { }
    @Override public void enterDenominator(DenominatorContext ctx) { }
    @Override public void exitDenominator(DenominatorContext ctx) { }
    @Override public void enterNotelength(NotelengthContext ctx) { }
    @Override public void enterElement(ElementContext ctx) { }
    @Override public void exitElement(ElementContext ctx) {}
    @Override public void enterNote(NoteContext ctx) { }
    @Override public void enterMeasureandbar(MeasureandbarContext ctx) { }
    @Override public void enterEveryRule(ParserRuleContext arg0) { }
    @Override public void exitEveryRule(ParserRuleContext arg0) { }
    @Override public void visitErrorNode(ErrorNode arg0) { }
    @Override public void visitTerminal(TerminalNode arg0) { }
    @Override public void enterRoot(RootContext ctx) { }
    @Override public void exitRoot(RootContext ctx) { }
    @Override public void enterFirstbarline(FirstbarlineContext ctx) { }
    @Override public void exitFirstbarline(FirstbarlineContext ctx) { }

}
