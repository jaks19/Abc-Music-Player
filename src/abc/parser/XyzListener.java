// Generated from Xyz.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XyzParser}.
 */
public interface XyzListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link XyzParser#root}.
   * @param ctx the parse tree
   */
  void enterRoot(XyzParser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#root}.
   * @param ctx the parse tree
   */
  void exitRoot(XyzParser.RootContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#header}.
   * @param ctx the parse tree
   */
  void enterHeader(XyzParser.HeaderContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#header}.
   * @param ctx the parse tree
   */
  void exitHeader(XyzParser.HeaderContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#fieldnumber}.
   * @param ctx the parse tree
   */
  void enterFieldnumber(XyzParser.FieldnumberContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#fieldnumber}.
   * @param ctx the parse tree
   */
  void exitFieldnumber(XyzParser.FieldnumberContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#fieldtitle}.
   * @param ctx the parse tree
   */
  void enterFieldtitle(XyzParser.FieldtitleContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#fieldtitle}.
   * @param ctx the parse tree
   */
  void exitFieldtitle(XyzParser.FieldtitleContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#otherfields}.
   * @param ctx the parse tree
   */
  void enterOtherfields(XyzParser.OtherfieldsContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#otherfields}.
   * @param ctx the parse tree
   */
  void exitOtherfields(XyzParser.OtherfieldsContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#fieldcomposer}.
   * @param ctx the parse tree
   */
  void enterFieldcomposer(XyzParser.FieldcomposerContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#fieldcomposer}.
   * @param ctx the parse tree
   */
  void exitFieldcomposer(XyzParser.FieldcomposerContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#fielddefaultlength}.
   * @param ctx the parse tree
   */
  void enterFielddefaultlength(XyzParser.FielddefaultlengthContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#fielddefaultlength}.
   * @param ctx the parse tree
   */
  void exitFielddefaultlength(XyzParser.FielddefaultlengthContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#fieldmeter}.
   * @param ctx the parse tree
   */
  void enterFieldmeter(XyzParser.FieldmeterContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#fieldmeter}.
   * @param ctx the parse tree
   */
  void exitFieldmeter(XyzParser.FieldmeterContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#fieldtempo}.
   * @param ctx the parse tree
   */
  void enterFieldtempo(XyzParser.FieldtempoContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#fieldtempo}.
   * @param ctx the parse tree
   */
  void exitFieldtempo(XyzParser.FieldtempoContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#fieldvoice}.
   * @param ctx the parse tree
   */
  void enterFieldvoice(XyzParser.FieldvoiceContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#fieldvoice}.
   * @param ctx the parse tree
   */
  void exitFieldvoice(XyzParser.FieldvoiceContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#fieldkey}.
   * @param ctx the parse tree
   */
  void enterFieldkey(XyzParser.FieldkeyContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#fieldkey}.
   * @param ctx the parse tree
   */
  void exitFieldkey(XyzParser.FieldkeyContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#key}.
   * @param ctx the parse tree
   */
  void enterKey(XyzParser.KeyContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#key}.
   * @param ctx the parse tree
   */
  void exitKey(XyzParser.KeyContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#tempo}.
   * @param ctx the parse tree
   */
  void enterTempo(XyzParser.TempoContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#tempo}.
   * @param ctx the parse tree
   */
  void exitTempo(XyzParser.TempoContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#meter}.
   * @param ctx the parse tree
   */
  void enterMeter(XyzParser.MeterContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#meter}.
   * @param ctx the parse tree
   */
  void exitMeter(XyzParser.MeterContext ctx);
  /**
   * Enter a parse tree produced by {@link XyzParser#filler}.
   * @param ctx the parse tree
   */
  void enterFiller(XyzParser.FillerContext ctx);
  /**
   * Exit a parse tree produced by {@link XyzParser#filler}.
   * @param ctx the parse tree
   */
  void exitFiller(XyzParser.FillerContext ctx);
}