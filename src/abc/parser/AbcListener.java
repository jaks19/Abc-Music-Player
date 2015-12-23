// Generated from Abc.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AbcParser}.
 */
public interface AbcListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link AbcParser#root}.
   * @param ctx the parse tree
   */
  void enterRoot(AbcParser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#root}.
   * @param ctx the parse tree
   */
  void exitRoot(AbcParser.RootContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#abcmusic}.
   * @param ctx the parse tree
   */
  void enterAbcmusic(AbcParser.AbcmusicContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#abcmusic}.
   * @param ctx the parse tree
   */
  void exitAbcmusic(AbcParser.AbcmusicContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#measureandbar}.
   * @param ctx the parse tree
   */
  void enterMeasureandbar(AbcParser.MeasureandbarContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#measureandbar}.
   * @param ctx the parse tree
   */
  void exitMeasureandbar(AbcParser.MeasureandbarContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#measure}.
   * @param ctx the parse tree
   */
  void enterMeasure(AbcParser.MeasureContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#measure}.
   * @param ctx the parse tree
   */
  void exitMeasure(AbcParser.MeasureContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#element}.
   * @param ctx the parse tree
   */
  void enterElement(AbcParser.ElementContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#element}.
   * @param ctx the parse tree
   */
  void exitElement(AbcParser.ElementContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#note}.
   * @param ctx the parse tree
   */
  void enterNote(AbcParser.NoteContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#note}.
   * @param ctx the parse tree
   */
  void exitNote(AbcParser.NoteContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#pitch}.
   * @param ctx the parse tree
   */
  void enterPitch(AbcParser.PitchContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#pitch}.
   * @param ctx the parse tree
   */
  void exitPitch(AbcParser.PitchContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#notelength}.
   * @param ctx the parse tree
   */
  void enterNotelength(AbcParser.NotelengthContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#notelength}.
   * @param ctx the parse tree
   */
  void exitNotelength(AbcParser.NotelengthContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#notelengthstrict}.
   * @param ctx the parse tree
   */
  void enterNotelengthstrict(AbcParser.NotelengthstrictContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#notelengthstrict}.
   * @param ctx the parse tree
   */
  void exitNotelengthstrict(AbcParser.NotelengthstrictContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#numerator}.
   * @param ctx the parse tree
   */
  void enterNumerator(AbcParser.NumeratorContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#numerator}.
   * @param ctx the parse tree
   */
  void exitNumerator(AbcParser.NumeratorContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#denominator}.
   * @param ctx the parse tree
   */
  void enterDenominator(AbcParser.DenominatorContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#denominator}.
   * @param ctx the parse tree
   */
  void exitDenominator(AbcParser.DenominatorContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#tupletelement}.
   * @param ctx the parse tree
   */
  void enterTupletelement(AbcParser.TupletelementContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#tupletelement}.
   * @param ctx the parse tree
   */
  void exitTupletelement(AbcParser.TupletelementContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#tupletspec}.
   * @param ctx the parse tree
   */
  void enterTupletspec(AbcParser.TupletspecContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#tupletspec}.
   * @param ctx the parse tree
   */
  void exitTupletspec(AbcParser.TupletspecContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#chord}.
   * @param ctx the parse tree
   */
  void enterChord(AbcParser.ChordContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#chord}.
   * @param ctx the parse tree
   */
  void exitChord(AbcParser.ChordContext ctx);
  /**
   * Enter a parse tree produced by {@link AbcParser#firstbarline}.
   * @param ctx the parse tree
   */
  void enterFirstbarline(AbcParser.FirstbarlineContext ctx);
  /**
   * Exit a parse tree produced by {@link AbcParser#firstbarline}.
   * @param ctx the parse tree
   */
  void exitFirstbarline(AbcParser.FirstbarlineContext ctx);
}