// Generated from Abc.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AbcParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, OCTAVE=5, ACCIDENTAL=6, BASENOTE=7, 
    REST=8, BARLINE=9, NTHREPEAT=10, DIGIT=11, WHITESPACE=12, NEWLINE=13;
  public static final int
    RULE_root = 0, RULE_abcmusic = 1, RULE_measureandbar = 2, RULE_measure = 3, 
    RULE_element = 4, RULE_note = 5, RULE_pitch = 6, RULE_notelength = 7, 
    RULE_notelengthstrict = 8, RULE_numerator = 9, RULE_denominator = 10, 
    RULE_tupletelement = 11, RULE_tupletspec = 12, RULE_chord = 13, RULE_firstbarline = 14;
  public static final String[] ruleNames = {
    "root", "abcmusic", "measureandbar", "measure", "element", "note", "pitch", 
    "notelength", "notelengthstrict", "numerator", "denominator", "tupletelement", 
    "tupletspec", "chord", "firstbarline"
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

  @Override
  public String getGrammarFileName() { return "Abc.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public ATN getATN() { return _ATN; }


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

  public AbcParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class RootContext extends ParserRuleContext {
    public AbcmusicContext abcmusic() {
      return getRuleContext(AbcmusicContext.class,0);
    }
    public TerminalNode EOF() { return getToken(AbcParser.EOF, 0); }
    public RootContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_root; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterRoot(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitRoot(this);
    }
  }

  public final RootContext root() throws RecognitionException {
    RootContext _localctx = new RootContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_root);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(30);
      abcmusic();
      setState(31);
      match(EOF);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class AbcmusicContext extends ParserRuleContext {
    public MeasureContext measure() {
      return getRuleContext(MeasureContext.class,0);
    }
    public FirstbarlineContext firstbarline() {
      return getRuleContext(FirstbarlineContext.class,0);
    }
    public List<TerminalNode> WHITESPACE() { return getTokens(AbcParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(AbcParser.WHITESPACE, i);
    }
    public List<MeasureandbarContext> measureandbar() {
      return getRuleContexts(MeasureandbarContext.class);
    }
    public MeasureandbarContext measureandbar(int i) {
      return getRuleContext(MeasureandbarContext.class,i);
    }
    public TerminalNode BARLINE() { return getToken(AbcParser.BARLINE, 0); }
    public TerminalNode NEWLINE() { return getToken(AbcParser.NEWLINE, 0); }
    public AbcmusicContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_abcmusic; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterAbcmusic(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitAbcmusic(this);
    }
  }

  public final AbcmusicContext abcmusic() throws RecognitionException {
    AbcmusicContext _localctx = new AbcmusicContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_abcmusic);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(34);
      _la = _input.LA(1);
      if (_la==BARLINE) {
        {
        setState(33);
        firstbarline();
        }
      }

      setState(39);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==WHITESPACE) {
        {
        {
        setState(36);
        match(WHITESPACE);
        }
        }
        setState(41);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(42);
      measure();
      setState(46);
      _errHandler.sync(this);
      _alt = getInterpreter().adaptivePredict(_input,2,_ctx);
      while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
        if ( _alt==1 ) {
          {
          {
          setState(43);
          measureandbar();
          }
          } 
        }
        setState(48);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,2,_ctx);
      }
      setState(50);
      _la = _input.LA(1);
      if (_la==BARLINE) {
        {
        setState(49);
        match(BARLINE);
        }
      }

      setState(53);
      _la = _input.LA(1);
      if (_la==NEWLINE) {
        {
        setState(52);
        match(NEWLINE);
        }
      }

      setState(58);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==WHITESPACE) {
        {
        {
        setState(55);
        match(WHITESPACE);
        }
        }
        setState(60);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class MeasureandbarContext extends ParserRuleContext {
    public TerminalNode BARLINE() { return getToken(AbcParser.BARLINE, 0); }
    public MeasureContext measure() {
      return getRuleContext(MeasureContext.class,0);
    }
    public TerminalNode NTHREPEAT() { return getToken(AbcParser.NTHREPEAT, 0); }
    public List<TerminalNode> WHITESPACE() { return getTokens(AbcParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(AbcParser.WHITESPACE, i);
    }
    public MeasureandbarContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_measureandbar; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterMeasureandbar(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitMeasureandbar(this);
    }
  }

  public final MeasureandbarContext measureandbar() throws RecognitionException {
    MeasureandbarContext _localctx = new MeasureandbarContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_measureandbar);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(61);
      match(BARLINE);
      setState(63);
      _la = _input.LA(1);
      if (_la==NTHREPEAT) {
        {
        setState(62);
        match(NTHREPEAT);
        }
      }

      setState(68);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==WHITESPACE) {
        {
        {
        setState(65);
        match(WHITESPACE);
        }
        }
        setState(70);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(71);
      measure();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class MeasureContext extends ParserRuleContext {
    public List<ElementContext> element() {
      return getRuleContexts(ElementContext.class);
    }
    public ElementContext element(int i) {
      return getRuleContext(ElementContext.class,i);
    }
    public MeasureContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_measure; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterMeasure(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitMeasure(this);
    }
  }

  public final MeasureContext measure() throws RecognitionException {
    MeasureContext _localctx = new MeasureContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_measure);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(74); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(73);
        element();
        }
        }
        setState(76); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << ACCIDENTAL) | (1L << BASENOTE) | (1L << REST))) != 0) );
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class ElementContext extends ParserRuleContext {
    public NoteContext note() {
      return getRuleContext(NoteContext.class,0);
    }
    public ChordContext chord() {
      return getRuleContext(ChordContext.class,0);
    }
    public TupletelementContext tupletelement() {
      return getRuleContext(TupletelementContext.class,0);
    }
    public List<TerminalNode> WHITESPACE() { return getTokens(AbcParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(AbcParser.WHITESPACE, i);
    }
    public ElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterElement(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitElement(this);
    }
  }

  public final ElementContext element() throws RecognitionException {
    ElementContext _localctx = new ElementContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_element);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(81);
      switch (_input.LA(1)) {
      case ACCIDENTAL:
      case BASENOTE:
      case REST:
        {
        setState(78);
        note();
        }
        break;
      case T__2:
        {
        setState(79);
        chord();
        }
        break;
      case T__1:
        {
        setState(80);
        tupletelement();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(86);
      _errHandler.sync(this);
      _alt = getInterpreter().adaptivePredict(_input,10,_ctx);
      while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
        if ( _alt==1 ) {
          {
          {
          setState(83);
          match(WHITESPACE);
          }
          } 
        }
        setState(88);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,10,_ctx);
      }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class NoteContext extends ParserRuleContext {
    public PitchContext pitch() {
      return getRuleContext(PitchContext.class,0);
    }
    public TerminalNode REST() { return getToken(AbcParser.REST, 0); }
    public NotelengthContext notelength() {
      return getRuleContext(NotelengthContext.class,0);
    }
    public NoteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterNote(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitNote(this);
    }
  }

  public final NoteContext note() throws RecognitionException {
    NoteContext _localctx = new NoteContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_note);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(91);
      switch (_input.LA(1)) {
      case ACCIDENTAL:
      case BASENOTE:
        {
        setState(89);
        pitch();
        }
        break;
      case REST:
        {
        setState(90);
        match(REST);
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(94);
      _la = _input.LA(1);
      if (_la==T__0 || _la==DIGIT) {
        {
        setState(93);
        notelength();
        }
      }

      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class PitchContext extends ParserRuleContext {
    public TerminalNode BASENOTE() { return getToken(AbcParser.BASENOTE, 0); }
    public TerminalNode ACCIDENTAL() { return getToken(AbcParser.ACCIDENTAL, 0); }
    public TerminalNode OCTAVE() { return getToken(AbcParser.OCTAVE, 0); }
    public PitchContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_pitch; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterPitch(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitPitch(this);
    }
  }

  public final PitchContext pitch() throws RecognitionException {
    PitchContext _localctx = new PitchContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_pitch);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(97);
      _la = _input.LA(1);
      if (_la==ACCIDENTAL) {
        {
        setState(96);
        match(ACCIDENTAL);
        }
      }

      setState(99);
      match(BASENOTE);
      setState(101);
      _la = _input.LA(1);
      if (_la==OCTAVE) {
        {
        setState(100);
        match(OCTAVE);
        }
      }

      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class NotelengthContext extends ParserRuleContext {
    public NumeratorContext numerator() {
      return getRuleContext(NumeratorContext.class,0);
    }
    public DenominatorContext denominator() {
      return getRuleContext(DenominatorContext.class,0);
    }
    public NotelengthContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_notelength; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterNotelength(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitNotelength(this);
    }
  }

  public final NotelengthContext notelength() throws RecognitionException {
    NotelengthContext _localctx = new NotelengthContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_notelength);
    try {
      setState(114);
      switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
      case 1:
        enterOuterAlt(_localctx, 1);
        {
        setState(103);
        numerator();
        }
        break;
      case 2:
        enterOuterAlt(_localctx, 2);
        {
        setState(104);
        match(T__0);
        }
        break;
      case 3:
        enterOuterAlt(_localctx, 3);
        {
        {
        setState(105);
        numerator();
        setState(106);
        match(T__0);
        }
        }
        break;
      case 4:
        enterOuterAlt(_localctx, 4);
        {
        setState(108);
        match(T__0);
        setState(109);
        denominator();
        }
        break;
      case 5:
        enterOuterAlt(_localctx, 5);
        {
        {
        setState(110);
        numerator();
        setState(111);
        match(T__0);
        setState(112);
        denominator();
        }
        }
        break;
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class NotelengthstrictContext extends ParserRuleContext {
    public NumeratorContext numerator() {
      return getRuleContext(NumeratorContext.class,0);
    }
    public DenominatorContext denominator() {
      return getRuleContext(DenominatorContext.class,0);
    }
    public NotelengthstrictContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_notelengthstrict; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterNotelengthstrict(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitNotelengthstrict(this);
    }
  }

  public final NotelengthstrictContext notelengthstrict() throws RecognitionException {
    NotelengthstrictContext _localctx = new NotelengthstrictContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_notelengthstrict);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(116);
      numerator();
      setState(117);
      denominator();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class NumeratorContext extends ParserRuleContext {
    public List<TerminalNode> DIGIT() { return getTokens(AbcParser.DIGIT); }
    public TerminalNode DIGIT(int i) {
      return getToken(AbcParser.DIGIT, i);
    }
    public NumeratorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_numerator; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterNumerator(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitNumerator(this);
    }
  }

  public final NumeratorContext numerator() throws RecognitionException {
    NumeratorContext _localctx = new NumeratorContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_numerator);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(120); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          {
          setState(119);
          match(DIGIT);
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(122); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,16,_ctx);
      } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class DenominatorContext extends ParserRuleContext {
    public List<TerminalNode> DIGIT() { return getTokens(AbcParser.DIGIT); }
    public TerminalNode DIGIT(int i) {
      return getToken(AbcParser.DIGIT, i);
    }
    public DenominatorContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_denominator; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterDenominator(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitDenominator(this);
    }
  }

  public final DenominatorContext denominator() throws RecognitionException {
    DenominatorContext _localctx = new DenominatorContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_denominator);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(125); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(124);
        match(DIGIT);
        }
        }
        setState(127); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( _la==DIGIT );
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class TupletelementContext extends ParserRuleContext {
    public TupletspecContext tupletspec() {
      return getRuleContext(TupletspecContext.class,0);
    }
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public List<ChordContext> chord() {
      return getRuleContexts(ChordContext.class);
    }
    public ChordContext chord(int i) {
      return getRuleContext(ChordContext.class,i);
    }
    public TupletelementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tupletelement; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterTupletelement(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitTupletelement(this);
    }
  }

  public final TupletelementContext tupletelement() throws RecognitionException {
    TupletelementContext _localctx = new TupletelementContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_tupletelement);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(129);
      tupletspec();
      setState(132); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          setState(132);
          switch (_input.LA(1)) {
          case ACCIDENTAL:
          case BASENOTE:
          case REST:
            {
            setState(130);
            note();
            }
            break;
          case T__2:
            {
            setState(131);
            chord();
            }
            break;
          default:
            throw new NoViableAltException(this);
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(134); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,19,_ctx);
      } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class TupletspecContext extends ParserRuleContext {
    public TerminalNode DIGIT() { return getToken(AbcParser.DIGIT, 0); }
    public TupletspecContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tupletspec; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterTupletspec(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitTupletspec(this);
    }
  }

  public final TupletspecContext tupletspec() throws RecognitionException {
    TupletspecContext _localctx = new TupletspecContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_tupletspec);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(136);
      match(T__1);
      setState(137);
      match(DIGIT);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class ChordContext extends ParserRuleContext {
    public List<TerminalNode> WHITESPACE() { return getTokens(AbcParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(AbcParser.WHITESPACE, i);
    }
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public ChordContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_chord; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterChord(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitChord(this);
    }
  }

  public final ChordContext chord() throws RecognitionException {
    ChordContext _localctx = new ChordContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_chord);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(139);
      match(T__2);
      setState(143);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==WHITESPACE) {
        {
        {
        setState(140);
        match(WHITESPACE);
        }
        }
        setState(145);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(153); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(146);
        note();
        setState(150);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la==WHITESPACE) {
          {
          {
          setState(147);
          match(WHITESPACE);
          }
          }
          setState(152);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        }
        }
        setState(155); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ACCIDENTAL) | (1L << BASENOTE) | (1L << REST))) != 0) );
      setState(157);
      match(T__3);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class FirstbarlineContext extends ParserRuleContext {
    public TerminalNode BARLINE() { return getToken(AbcParser.BARLINE, 0); }
    public FirstbarlineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_firstbarline; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).enterFirstbarline(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof AbcListener ) ((AbcListener)listener).exitFirstbarline(this);
    }
  }

  public final FirstbarlineContext firstbarline() throws RecognitionException {
    FirstbarlineContext _localctx = new FirstbarlineContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_firstbarline);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(159);
      match(BARLINE);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17\u00a4\4\2\t"+
      "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
      "\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3"+
      "\2\3\3\5\3%\n\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\3\3\3\7\3/\n\3\f\3\16"+
      "\3\62\13\3\3\3\5\3\65\n\3\3\3\5\38\n\3\3\3\7\3;\n\3\f\3\16\3>\13\3"+
      "\3\4\3\4\5\4B\n\4\3\4\7\4E\n\4\f\4\16\4H\13\4\3\4\3\4\3\5\6\5M\n\5"+
      "\r\5\16\5N\3\6\3\6\3\6\5\6T\n\6\3\6\7\6W\n\6\f\6\16\6Z\13\6\3\7\3"+
      "\7\5\7^\n\7\3\7\5\7a\n\7\3\b\5\bd\n\b\3\b\3\b\5\bh\n\b\3\t\3\t\3\t"+
      "\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tu\n\t\3\n\3\n\3\n\3\13\6\13{\n"+
      "\13\r\13\16\13|\3\f\6\f\u0080\n\f\r\f\16\f\u0081\3\r\3\r\3\r\6\r\u0087"+
      "\n\r\r\r\16\r\u0088\3\16\3\16\3\16\3\17\3\17\7\17\u0090\n\17\f\17"+
      "\16\17\u0093\13\17\3\17\3\17\7\17\u0097\n\17\f\17\16\17\u009a\13\17"+
      "\6\17\u009c\n\17\r\17\16\17\u009d\3\17\3\17\3\20\3\20\3\20\2\2\21"+
      "\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\u00af\2 \3\2\2\2\4$\3"+
      "\2\2\2\6?\3\2\2\2\bL\3\2\2\2\nS\3\2\2\2\f]\3\2\2\2\16c\3\2\2\2\20"+
      "t\3\2\2\2\22v\3\2\2\2\24z\3\2\2\2\26\177\3\2\2\2\30\u0083\3\2\2\2"+
      "\32\u008a\3\2\2\2\34\u008d\3\2\2\2\36\u00a1\3\2\2\2 !\5\4\3\2!\"\7"+
      "\2\2\3\"\3\3\2\2\2#%\5\36\20\2$#\3\2\2\2$%\3\2\2\2%)\3\2\2\2&(\7\16"+
      "\2\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2"+
      ",\60\5\b\5\2-/\5\6\4\2.-\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2"+
      "\2\2\61\64\3\2\2\2\62\60\3\2\2\2\63\65\7\13\2\2\64\63\3\2\2\2\64\65"+
      "\3\2\2\2\65\67\3\2\2\2\668\7\17\2\2\67\66\3\2\2\2\678\3\2\2\28<\3"+
      "\2\2\29;\7\16\2\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\5\3\2\2"+
      "\2><\3\2\2\2?A\7\13\2\2@B\7\f\2\2A@\3\2\2\2AB\3\2\2\2BF\3\2\2\2CE"+
      "\7\16\2\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2"+
      "\2\2IJ\5\b\5\2J\7\3\2\2\2KM\5\n\6\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2"+
      "NO\3\2\2\2O\t\3\2\2\2PT\5\f\7\2QT\5\34\17\2RT\5\30\r\2SP\3\2\2\2S"+
      "Q\3\2\2\2SR\3\2\2\2TX\3\2\2\2UW\7\16\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2"+
      "\2\2XY\3\2\2\2Y\13\3\2\2\2ZX\3\2\2\2[^\5\16\b\2\\^\7\n\2\2][\3\2\2"+
      "\2]\\\3\2\2\2^`\3\2\2\2_a\5\20\t\2`_\3\2\2\2`a\3\2\2\2a\r\3\2\2\2"+
      "bd\7\b\2\2cb\3\2\2\2cd\3\2\2\2de\3\2\2\2eg\7\t\2\2fh\7\7\2\2gf\3\2"+
      "\2\2gh\3\2\2\2h\17\3\2\2\2iu\5\24\13\2ju\7\3\2\2kl\5\24\13\2lm\7\3"+
      "\2\2mu\3\2\2\2no\7\3\2\2ou\5\26\f\2pq\5\24\13\2qr\7\3\2\2rs\5\26\f"+
      "\2su\3\2\2\2ti\3\2\2\2tj\3\2\2\2tk\3\2\2\2tn\3\2\2\2tp\3\2\2\2u\21"+
      "\3\2\2\2vw\5\24\13\2wx\5\26\f\2x\23\3\2\2\2y{\7\r\2\2zy\3\2\2\2{|"+
      "\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\25\3\2\2\2~\u0080\7\r\2\2\177~\3\2\2"+
      "\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
      "\27\3\2\2\2\u0083\u0086\5\32\16\2\u0084\u0087\5\f\7\2\u0085\u0087"+
      "\5\34\17\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2"+
      "\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\31\3\2\2\2\u008a"+
      "\u008b\7\4\2\2\u008b\u008c\7\r\2\2\u008c\33\3\2\2\2\u008d\u0091\7"+
      "\5\2\2\u008e\u0090\7\16\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2"+
      "\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u009b\3\2\2\2\u0093"+
      "\u0091\3\2\2\2\u0094\u0098\5\f\7\2\u0095\u0097\7\16\2\2\u0096\u0095"+
      "\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2"+
      "\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u0094\3\2\2\2\u009c"+
      "\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f"+
      "\3\2\2\2\u009f\u00a0\7\6\2\2\u00a0\35\3\2\2\2\u00a1\u00a2\7\13\2\2"+
      "\u00a2\37\3\2\2\2\31$)\60\64\67<AFNSX]`cgt|\u0081\u0086\u0088\u0091"+
      "\u0098\u009d";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}