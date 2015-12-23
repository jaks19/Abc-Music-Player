// Generated from VoiceIdentifier.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VoiceIdentifierParser}.
 */
public interface VoiceIdentifierListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link VoiceIdentifierParser#root}.
   * @param ctx the parse tree
   */
  void enterRoot(VoiceIdentifierParser.RootContext ctx);
  /**
   * Exit a parse tree produced by {@link VoiceIdentifierParser#root}.
   * @param ctx the parse tree
   */
  void exitRoot(VoiceIdentifierParser.RootContext ctx);
  /**
   * Enter a parse tree produced by {@link VoiceIdentifierParser#music}.
   * @param ctx the parse tree
   */
  void enterMusic(VoiceIdentifierParser.MusicContext ctx);
  /**
   * Exit a parse tree produced by {@link VoiceIdentifierParser#music}.
   * @param ctx the parse tree
   */
  void exitMusic(VoiceIdentifierParser.MusicContext ctx);
  /**
   * Enter a parse tree produced by {@link VoiceIdentifierParser#voiced}.
   * @param ctx the parse tree
   */
  void enterVoiced(VoiceIdentifierParser.VoicedContext ctx);
  /**
   * Exit a parse tree produced by {@link VoiceIdentifierParser#voiced}.
   * @param ctx the parse tree
   */
  void exitVoiced(VoiceIdentifierParser.VoicedContext ctx);
  /**
   * Enter a parse tree produced by {@link VoiceIdentifierParser#nonvoiced}.
   * @param ctx the parse tree
   */
  void enterNonvoiced(VoiceIdentifierParser.NonvoicedContext ctx);
  /**
   * Exit a parse tree produced by {@link VoiceIdentifierParser#nonvoiced}.
   * @param ctx the parse tree
   */
  void exitNonvoiced(VoiceIdentifierParser.NonvoicedContext ctx);
  /**
   * Enter a parse tree produced by {@link VoiceIdentifierParser#voiceid}.
   * @param ctx the parse tree
   */
  void enterVoiceid(VoiceIdentifierParser.VoiceidContext ctx);
  /**
   * Exit a parse tree produced by {@link VoiceIdentifierParser#voiceid}.
   * @param ctx the parse tree
   */
  void exitVoiceid(VoiceIdentifierParser.VoiceidContext ctx);
  /**
   * Enter a parse tree produced by {@link VoiceIdentifierParser#musicline}.
   * @param ctx the parse tree
   */
  void enterMusicline(VoiceIdentifierParser.MusiclineContext ctx);
  /**
   * Exit a parse tree produced by {@link VoiceIdentifierParser#musicline}.
   * @param ctx the parse tree
   */
  void exitMusicline(VoiceIdentifierParser.MusiclineContext ctx);
  /**
   * Enter a parse tree produced by {@link VoiceIdentifierParser#comment}.
   * @param ctx the parse tree
   */
  void enterComment(VoiceIdentifierParser.CommentContext ctx);
  /**
   * Exit a parse tree produced by {@link VoiceIdentifierParser#comment}.
   * @param ctx the parse tree
   */
  void exitComment(VoiceIdentifierParser.CommentContext ctx);
  /**
   * Enter a parse tree produced by {@link VoiceIdentifierParser#name}.
   * @param ctx the parse tree
   */
  void enterName(VoiceIdentifierParser.NameContext ctx);
  /**
   * Exit a parse tree produced by {@link VoiceIdentifierParser#name}.
   * @param ctx the parse tree
   */
  void exitName(VoiceIdentifierParser.NameContext ctx);
}