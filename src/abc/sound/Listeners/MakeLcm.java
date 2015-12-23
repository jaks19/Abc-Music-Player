package abc.sound.Listeners;

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

/** Make an Expression value from a parse tree. */
public class MakeLcm implements AbcListener {
    private int largestDenominator = 12;

    /**
     * Returns the LCM calculated from this voice's note durations
     * @return the LCM obtained
     */
    public int getLcm(){return this.largestDenominator;}

    @Override public void enterEveryRule(ParserRuleContext arg0) { }
    @Override public void exitEveryRule(ParserRuleContext arg0) { }
    @Override public void visitErrorNode(ErrorNode arg0) { }
    @Override public void visitTerminal(TerminalNode arg0) { }
    @Override public void enterRoot(RootContext ctx) { }
    @Override public void exitRoot(RootContext ctx) { }
    @Override public void enterAbcmusic(AbcmusicContext ctx) {}
    @Override public void exitAbcmusic(AbcmusicContext ctx) {}
    @Override public void enterMeasure(MeasureContext ctx) {}
    @Override public void exitMeasure(MeasureContext ctx) {}
    @Override public void enterElement(ElementContext ctx) {}
    @Override public void exitElement(ElementContext ctx) {}
    @Override public void enterNote(NoteContext ctx) {}
    @Override public void exitNote(NoteContext ctx) {}
    @Override public void enterPitch(PitchContext ctx) {}
    @Override public void exitPitch(PitchContext ctx) {}
    @Override public void enterNotelength(NotelengthContext ctx) {}
    @Override public void exitNotelength(NotelengthContext ctx) {
        int denominator = 1;
        if (ctx.denominator() != null) {
            denominator = Integer.parseInt((ctx.denominator().getText()));
        }
        if (denominator > this.largestDenominator){
            if ((denominator % this.largestDenominator) == 0){
                this.largestDenominator = denominator;
            }
            else{
                this.largestDenominator *= denominator;
            }
        }
        else{
            if ((this.largestDenominator % denominator) == 0){
                this.largestDenominator *= 1;
            }
            else{
                this.largestDenominator *= denominator;
            }
        }
    }
    @Override public void enterNotelengthstrict(NotelengthstrictContext ctx) {}
    @Override public void exitNotelengthstrict(NotelengthstrictContext ctx) {}
    @Override public void enterNumerator(NumeratorContext ctx) {}
    @Override public void exitNumerator(NumeratorContext ctx) {}
    @Override public void enterDenominator(DenominatorContext ctx) {}
    @Override public void exitDenominator(DenominatorContext ctx) {}
    @Override public void enterTupletelement(TupletelementContext ctx) {}
    @Override public void exitTupletelement(TupletelementContext ctx) {}
    @Override public void enterTupletspec(TupletspecContext ctx) {}
    @Override public void exitTupletspec(TupletspecContext ctx) {}
    @Override public void enterChord(ChordContext ctx) {}
    @Override public void exitChord(ChordContext ctx) {}
    @Override public void enterMeasureandbar(MeasureandbarContext ctx) {}
    @Override public void exitMeasureandbar(MeasureandbarContext ctx) {}
    @Override public void enterFirstbarline(FirstbarlineContext ctx) {}
    @Override public void exitFirstbarline(FirstbarlineContext ctx) {
    }
}