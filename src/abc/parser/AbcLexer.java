// Generated from Abc.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AbcLexer extends Lexer {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, OCTAVE=5, ACCIDENTAL=6, BASENOTE=7, 
    REST=8, BARLINE=9, NTHREPEAT=10, DIGIT=11, WHITESPACE=12, NEWLINE=13;
  public static String[] modeNames = {
    "DEFAULT_MODE"
  };

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "OCTAVE", "ACCIDENTAL", "BASENOTE", 
    "REST", "BARLINE", "NTHREPEAT", "DIGIT", "WHITESPACE", "NEWLINE"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'/'", "'('", "'['", "']'", null, null, null, "'z'", null, null, 
    null, "' '"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, "OCTAVE", "ACCIDENTAL", "BASENOTE", "REST", 
    "BARLINE", "NTHREPEAT", "DIGIT", "WHITESPACE", "NEWLINE"
  };
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated
  public static final String[] tokenNames;
  static {
    tokenNames = new String[_SYMBOLIC_NAMES.length];
    for (int i = 0; i < tokenNames.length; i++) {
      tokenNames[i] = VOCABULARY.getLiteralName(i);
      if (tokenNames[i] == null) {
        tokenNames[i] = VOCABULARY.getSymbolicName(i);
      }

      if (tokenNames[i] == null) {
        tokenNames[i] = "<INVALID>";
      }
    }
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override

  public Vocabulary getVocabulary() {
    return VOCABULARY;
  }


      // This method makes the parser stop running if it encounters
      // invalid input and throw a RuntimeException.
      public void reportErrorsAsExceptions() {
          // To prevent any reports to standard error, add this line:
          //removeErrorListeners();
          
          addErrorListener(new BaseErrorListener() {
              public void syntaxError(Recognizer<?, ?> recognizer,
                                      Object offendingSymbol, 
                                      int line, int charPositionInLine,
                                      String msg, RecognitionException e) {
                  throw new ParseCancellationException(msg, e);
              }
          });
      }


  public AbcLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }

  @Override
  public String getGrammarFileName() { return "Abc.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public String[] getModeNames() { return modeNames; }

  @Override
  public ATN getATN() { return _ATN; }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17[\b\1\4\2\t\2"+
      "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
      "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5"+
      "\3\6\6\6\'\n\6\r\6\16\6(\3\6\6\6,\n\6\r\6\16\6-\5\6\60\n\6\3\7\3\7"+
      "\3\7\3\7\3\7\3\7\3\7\5\79\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
      "\3\n\3\n\3\n\3\n\3\n\3\n\5\nJ\n\n\3\13\3\13\3\13\3\13\5\13P\n\13\3"+
      "\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\5\16Z\n\16\2\2\17\3\3\5\4\7\5\t"+
      "\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\4\4\2CIci\3"+
      "\2\62;i\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
      "\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
      "\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2"+
      "\7!\3\2\2\2\t#\3\2\2\2\13/\3\2\2\2\r8\3\2\2\2\17:\3\2\2\2\21<\3\2"+
      "\2\2\23I\3\2\2\2\25O\3\2\2\2\27Q\3\2\2\2\31S\3\2\2\2\33Y\3\2\2\2\35"+
      "\36\7\61\2\2\36\4\3\2\2\2\37 \7*\2\2 \6\3\2\2\2!\"\7]\2\2\"\b\3\2"+
      "\2\2#$\7_\2\2$\n\3\2\2\2%\'\7)\2\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2"+
      "()\3\2\2\2)\60\3\2\2\2*,\7.\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3"+
      "\2\2\2.\60\3\2\2\2/&\3\2\2\2/+\3\2\2\2\60\f\3\2\2\2\619\7`\2\2\62"+
      "\63\7`\2\2\639\7`\2\2\649\7a\2\2\65\66\7a\2\2\669\7a\2\2\679\7?\2"+
      "\28\61\3\2\2\28\62\3\2\2\28\64\3\2\2\28\65\3\2\2\28\67\3\2\2\29\16"+
      "\3\2\2\2:;\t\2\2\2;\20\3\2\2\2<=\7|\2\2=\22\3\2\2\2>J\7~\2\2?@\7~"+
      "\2\2@J\7~\2\2AB\7]\2\2BJ\7~\2\2CD\7~\2\2DJ\7_\2\2EF\7<\2\2FJ\7~\2"+
      "\2GH\7~\2\2HJ\7<\2\2I>\3\2\2\2I?\3\2\2\2IA\3\2\2\2IC\3\2\2\2IE\3\2"+
      "\2\2IG\3\2\2\2J\24\3\2\2\2KL\7]\2\2LP\7\63\2\2MN\7]\2\2NP\7\64\2\2"+
      "OK\3\2\2\2OM\3\2\2\2P\26\3\2\2\2QR\t\3\2\2R\30\3\2\2\2ST\7\"\2\2T"+
      "\32\3\2\2\2UZ\7\f\2\2VW\7\17\2\2WZ\7\f\2\2XZ\7\17\2\2YU\3\2\2\2YV"+
      "\3\2\2\2YX\3\2\2\2Z\34\3\2\2\2\n\2(-/8IOY\2";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}