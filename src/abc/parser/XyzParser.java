// Generated from Xyz.g4 by ANTLR 4.5.1

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
public class XyzParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, DIGIT=12, C=13, ENDOFLINE=14, METERFRACTION=15, TEXT=16, 
    SPACES=17;
  public static final int
    RULE_root = 0, RULE_header = 1, RULE_fieldnumber = 2, RULE_fieldtitle = 3, 
    RULE_otherfields = 4, RULE_fieldcomposer = 5, RULE_fielddefaultlength = 6, 
    RULE_fieldmeter = 7, RULE_fieldtempo = 8, RULE_fieldvoice = 9, RULE_fieldkey = 10, 
    RULE_key = 11, RULE_tempo = 12, RULE_meter = 13, RULE_filler = 14;
  public static final String[] ruleNames = {
    "root", "header", "fieldnumber", "fieldtitle", "otherfields", "fieldcomposer", 
    "fielddefaultlength", "fieldmeter", "fieldtempo", "fieldvoice", "fieldkey", 
    "key", "tempo", "meter", "filler"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'X:'", "'T:'", "'C:'", "'L:'", "'M:'", "'Q:'", "'V:'", "'K:'", 
    "'#'", "'='", "'C|'", null, "'C'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, null, null, null, null, null, 
    "DIGIT", "C", "ENDOFLINE", "METERFRACTION", "TEXT", "SPACES"
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
  public String getGrammarFileName() { return "Xyz.g4"; }

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

  public XyzParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class RootContext extends ParserRuleContext {
    public HeaderContext header() {
      return getRuleContext(HeaderContext.class,0);
    }
    public TerminalNode EOF() { return getToken(XyzParser.EOF, 0); }
    public RootContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_root; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterRoot(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitRoot(this);
    }
  }

  public final RootContext root() throws RecognitionException {
    RootContext _localctx = new RootContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_root);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(30);
      header();
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

  public static class HeaderContext extends ParserRuleContext {
    public FieldnumberContext fieldnumber() {
      return getRuleContext(FieldnumberContext.class,0);
    }
    public FieldtitleContext fieldtitle() {
      return getRuleContext(FieldtitleContext.class,0);
    }
    public FieldkeyContext fieldkey() {
      return getRuleContext(FieldkeyContext.class,0);
    }
    public List<OtherfieldsContext> otherfields() {
      return getRuleContexts(OtherfieldsContext.class);
    }
    public OtherfieldsContext otherfields(int i) {
      return getRuleContext(OtherfieldsContext.class,i);
    }
    public List<FillerContext> filler() {
      return getRuleContexts(FillerContext.class);
    }
    public FillerContext filler(int i) {
      return getRuleContext(FillerContext.class,i);
    }
    public HeaderContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_header; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterHeader(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitHeader(this);
    }
  }

  public final HeaderContext header() throws RecognitionException {
    HeaderContext _localctx = new HeaderContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_header);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(33);
      fieldnumber();
      setState(34);
      fieldtitle();
      setState(38);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6))) != 0)) {
        {
        {
        setState(35);
        otherfields();
        }
        }
        setState(40);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(41);
      fieldkey();
      setState(45);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << DIGIT) | (1L << C) | (1L << ENDOFLINE) | (1L << METERFRACTION) | (1L << TEXT) | (1L << SPACES))) != 0)) {
        {
        {
        setState(42);
        filler();
        }
        }
        setState(47);
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

  public static class FieldnumberContext extends ParserRuleContext {
    public TerminalNode DIGIT() { return getToken(XyzParser.DIGIT, 0); }
    public TerminalNode ENDOFLINE() { return getToken(XyzParser.ENDOFLINE, 0); }
    public FieldnumberContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_fieldnumber; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterFieldnumber(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitFieldnumber(this);
    }
  }

  public final FieldnumberContext fieldnumber() throws RecognitionException {
    FieldnumberContext _localctx = new FieldnumberContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_fieldnumber);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(48);
      match(T__0);
      setState(49);
      match(DIGIT);
      setState(50);
      match(ENDOFLINE);
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

  public static class FieldtitleContext extends ParserRuleContext {
    public TerminalNode ENDOFLINE() { return getToken(XyzParser.ENDOFLINE, 0); }
    public List<TerminalNode> TEXT() { return getTokens(XyzParser.TEXT); }
    public TerminalNode TEXT(int i) {
      return getToken(XyzParser.TEXT, i);
    }
    public List<TerminalNode> DIGIT() { return getTokens(XyzParser.DIGIT); }
    public TerminalNode DIGIT(int i) {
      return getToken(XyzParser.DIGIT, i);
    }
    public FieldtitleContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_fieldtitle; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterFieldtitle(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitFieldtitle(this);
    }
  }

  public final FieldtitleContext fieldtitle() throws RecognitionException {
    FieldtitleContext _localctx = new FieldtitleContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_fieldtitle);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(52);
      match(T__1);
      setState(56);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==DIGIT || _la==TEXT) {
        {
        {
        setState(53);
        _la = _input.LA(1);
        if ( !(_la==DIGIT || _la==TEXT) ) {
        _errHandler.recoverInline(this);
        } else {
          consume();
        }
        }
        }
        setState(58);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(59);
      match(ENDOFLINE);
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

  public static class OtherfieldsContext extends ParserRuleContext {
    public FieldcomposerContext fieldcomposer() {
      return getRuleContext(FieldcomposerContext.class,0);
    }
    public FielddefaultlengthContext fielddefaultlength() {
      return getRuleContext(FielddefaultlengthContext.class,0);
    }
    public FieldmeterContext fieldmeter() {
      return getRuleContext(FieldmeterContext.class,0);
    }
    public FieldtempoContext fieldtempo() {
      return getRuleContext(FieldtempoContext.class,0);
    }
    public FieldvoiceContext fieldvoice() {
      return getRuleContext(FieldvoiceContext.class,0);
    }
    public OtherfieldsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_otherfields; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterOtherfields(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitOtherfields(this);
    }
  }

  public final OtherfieldsContext otherfields() throws RecognitionException {
    OtherfieldsContext _localctx = new OtherfieldsContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_otherfields);
    try {
      setState(66);
      switch (_input.LA(1)) {
      case T__2:
        enterOuterAlt(_localctx, 1);
        {
        setState(61);
        fieldcomposer();
        }
        break;
      case T__3:
        enterOuterAlt(_localctx, 2);
        {
        setState(62);
        fielddefaultlength();
        }
        break;
      case T__4:
        enterOuterAlt(_localctx, 3);
        {
        setState(63);
        fieldmeter();
        }
        break;
      case T__5:
        enterOuterAlt(_localctx, 4);
        {
        setState(64);
        fieldtempo();
        }
        break;
      case T__6:
        enterOuterAlt(_localctx, 5);
        {
        setState(65);
        fieldvoice();
        }
        break;
      default:
        throw new NoViableAltException(this);
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

  public static class FieldcomposerContext extends ParserRuleContext {
    public TerminalNode ENDOFLINE() { return getToken(XyzParser.ENDOFLINE, 0); }
    public List<TerminalNode> TEXT() { return getTokens(XyzParser.TEXT); }
    public TerminalNode TEXT(int i) {
      return getToken(XyzParser.TEXT, i);
    }
    public List<TerminalNode> DIGIT() { return getTokens(XyzParser.DIGIT); }
    public TerminalNode DIGIT(int i) {
      return getToken(XyzParser.DIGIT, i);
    }
    public FieldcomposerContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_fieldcomposer; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterFieldcomposer(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitFieldcomposer(this);
    }
  }

  public final FieldcomposerContext fieldcomposer() throws RecognitionException {
    FieldcomposerContext _localctx = new FieldcomposerContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_fieldcomposer);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(68);
      match(T__2);
      setState(72);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==DIGIT || _la==TEXT) {
        {
        {
        setState(69);
        _la = _input.LA(1);
        if ( !(_la==DIGIT || _la==TEXT) ) {
        _errHandler.recoverInline(this);
        } else {
          consume();
        }
        }
        }
        setState(74);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(75);
      match(ENDOFLINE);
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

  public static class FielddefaultlengthContext extends ParserRuleContext {
    public TerminalNode METERFRACTION() { return getToken(XyzParser.METERFRACTION, 0); }
    public TerminalNode ENDOFLINE() { return getToken(XyzParser.ENDOFLINE, 0); }
    public FielddefaultlengthContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_fielddefaultlength; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterFielddefaultlength(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitFielddefaultlength(this);
    }
  }

  public final FielddefaultlengthContext fielddefaultlength() throws RecognitionException {
    FielddefaultlengthContext _localctx = new FielddefaultlengthContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_fielddefaultlength);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(77);
      match(T__3);
      setState(78);
      match(METERFRACTION);
      setState(79);
      match(ENDOFLINE);
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

  public static class FieldmeterContext extends ParserRuleContext {
    public MeterContext meter() {
      return getRuleContext(MeterContext.class,0);
    }
    public TerminalNode ENDOFLINE() { return getToken(XyzParser.ENDOFLINE, 0); }
    public FieldmeterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_fieldmeter; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterFieldmeter(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitFieldmeter(this);
    }
  }

  public final FieldmeterContext fieldmeter() throws RecognitionException {
    FieldmeterContext _localctx = new FieldmeterContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_fieldmeter);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(81);
      match(T__4);
      setState(82);
      meter();
      setState(83);
      match(ENDOFLINE);
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

  public static class FieldtempoContext extends ParserRuleContext {
    public TempoContext tempo() {
      return getRuleContext(TempoContext.class,0);
    }
    public TerminalNode ENDOFLINE() { return getToken(XyzParser.ENDOFLINE, 0); }
    public FieldtempoContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_fieldtempo; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterFieldtempo(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitFieldtempo(this);
    }
  }

  public final FieldtempoContext fieldtempo() throws RecognitionException {
    FieldtempoContext _localctx = new FieldtempoContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_fieldtempo);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(85);
      match(T__5);
      setState(86);
      tempo();
      setState(87);
      match(ENDOFLINE);
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

  public static class FieldvoiceContext extends ParserRuleContext {
    public TerminalNode ENDOFLINE() { return getToken(XyzParser.ENDOFLINE, 0); }
    public List<TerminalNode> TEXT() { return getTokens(XyzParser.TEXT); }
    public TerminalNode TEXT(int i) {
      return getToken(XyzParser.TEXT, i);
    }
    public List<TerminalNode> DIGIT() { return getTokens(XyzParser.DIGIT); }
    public TerminalNode DIGIT(int i) {
      return getToken(XyzParser.DIGIT, i);
    }
    public FieldvoiceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_fieldvoice; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterFieldvoice(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitFieldvoice(this);
    }
  }

  public final FieldvoiceContext fieldvoice() throws RecognitionException {
    FieldvoiceContext _localctx = new FieldvoiceContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_fieldvoice);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(89);
      match(T__6);
      setState(93);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==DIGIT || _la==TEXT) {
        {
        {
        setState(90);
        _la = _input.LA(1);
        if ( !(_la==DIGIT || _la==TEXT) ) {
        _errHandler.recoverInline(this);
        } else {
          consume();
        }
        }
        }
        setState(95);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(96);
      match(ENDOFLINE);
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

  public static class FieldkeyContext extends ParserRuleContext {
    public KeyContext key() {
      return getRuleContext(KeyContext.class,0);
    }
    public TerminalNode ENDOFLINE() { return getToken(XyzParser.ENDOFLINE, 0); }
    public FieldkeyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_fieldkey; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterFieldkey(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitFieldkey(this);
    }
  }

  public final FieldkeyContext fieldkey() throws RecognitionException {
    FieldkeyContext _localctx = new FieldkeyContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_fieldkey);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(98);
      match(T__7);
      setState(99);
      key();
      setState(100);
      match(ENDOFLINE);
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

  public static class KeyContext extends ParserRuleContext {
    public List<TerminalNode> TEXT() { return getTokens(XyzParser.TEXT); }
    public TerminalNode TEXT(int i) {
      return getToken(XyzParser.TEXT, i);
    }
    public List<TerminalNode> C() { return getTokens(XyzParser.C); }
    public TerminalNode C(int i) {
      return getToken(XyzParser.C, i);
    }
    public KeyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_key; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterKey(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitKey(this);
    }
  }

  public final KeyContext key() throws RecognitionException {
    KeyContext _localctx = new KeyContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_key);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(103); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(102);
        _la = _input.LA(1);
        if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << C) | (1L << TEXT))) != 0)) ) {
        _errHandler.recoverInline(this);
        } else {
          consume();
        }
        }
        }
        setState(105); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << C) | (1L << TEXT))) != 0) );
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

  public static class TempoContext extends ParserRuleContext {
    public TerminalNode METERFRACTION() { return getToken(XyzParser.METERFRACTION, 0); }
    public List<TerminalNode> DIGIT() { return getTokens(XyzParser.DIGIT); }
    public TerminalNode DIGIT(int i) {
      return getToken(XyzParser.DIGIT, i);
    }
    public TempoContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tempo; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterTempo(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitTempo(this);
    }
  }

  public final TempoContext tempo() throws RecognitionException {
    TempoContext _localctx = new TempoContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_tempo);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(107);
      match(METERFRACTION);
      setState(108);
      match(T__9);
      setState(110); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(109);
        match(DIGIT);
        }
        }
        setState(112); 
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

  public static class MeterContext extends ParserRuleContext {
    public TerminalNode C() { return getToken(XyzParser.C, 0); }
    public TerminalNode METERFRACTION() { return getToken(XyzParser.METERFRACTION, 0); }
    public MeterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_meter; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterMeter(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitMeter(this);
    }
  }

  public final MeterContext meter() throws RecognitionException {
    MeterContext _localctx = new MeterContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_meter);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(114);
      _la = _input.LA(1);
      if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << C) | (1L << METERFRACTION))) != 0)) ) {
      _errHandler.recoverInline(this);
      } else {
        consume();
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

  public static class FillerContext extends ParserRuleContext {
    public FillerContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_filler; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).enterFiller(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof XyzListener ) ((XyzListener)listener).exitFiller(this);
    }
  }

  public final FillerContext filler() throws RecognitionException {
    FillerContext _localctx = new FillerContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_filler);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(117); 
      _errHandler.sync(this);
      _alt = 1+1;
      do {
        switch (_alt) {
        case 1+1:
          {
          {
          setState(116);
          matchWildcard();
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(119); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,8,_ctx);
      } while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23|\4\2\t\2\4\3"+
      "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
      "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3"+
      "\3\3\3\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13"+
      "\3\3\4\3\4\3\4\3\4\3\5\3\5\7\59\n\5\f\5\16\5<\13\5\3\5\3\5\3\6\3\6"+
      "\3\6\3\6\3\6\5\6E\n\6\3\7\3\7\7\7I\n\7\f\7\16\7L\13\7\3\7\3\7\3\b"+
      "\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\7\13^\n\13"+
      "\f\13\16\13a\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\6\rj\n\r\r\r\16\r"+
      "k\3\16\3\16\3\16\6\16q\n\16\r\16\16\16r\3\17\3\17\3\20\6\20x\n\20"+
      "\r\20\16\20y\3\20\3y\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2"+
      "\5\4\2\16\16\22\22\5\2\13\13\17\17\22\22\5\2\r\r\17\17\21\21x\2 \3"+
      "\2\2\2\4#\3\2\2\2\6\62\3\2\2\2\b\66\3\2\2\2\nD\3\2\2\2\fF\3\2\2\2"+
      "\16O\3\2\2\2\20S\3\2\2\2\22W\3\2\2\2\24[\3\2\2\2\26d\3\2\2\2\30i\3"+
      "\2\2\2\32m\3\2\2\2\34t\3\2\2\2\36w\3\2\2\2 !\5\4\3\2!\"\7\2\2\3\""+
      "\3\3\2\2\2#$\5\6\4\2$(\5\b\5\2%\'\5\n\6\2&%\3\2\2\2\'*\3\2\2\2(&\3"+
      "\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+/\5\26\f\2,.\5\36\20\2-,\3\2"+
      "\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\5\3\2\2\2\61/\3\2\2\2\62"+
      "\63\7\3\2\2\63\64\7\16\2\2\64\65\7\20\2\2\65\7\3\2\2\2\66:\7\4\2\2"+
      "\679\t\2\2\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<"+
      ":\3\2\2\2=>\7\20\2\2>\t\3\2\2\2?E\5\f\7\2@E\5\16\b\2AE\5\20\t\2BE"+
      "\5\22\n\2CE\5\24\13\2D?\3\2\2\2D@\3\2\2\2DA\3\2\2\2DB\3\2\2\2DC\3"+
      "\2\2\2E\13\3\2\2\2FJ\7\5\2\2GI\t\2\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2"+
      "\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7\20\2\2N\r\3\2\2\2OP\7\6\2\2P"+
      "Q\7\21\2\2QR\7\20\2\2R\17\3\2\2\2ST\7\7\2\2TU\5\34\17\2UV\7\20\2\2"+
      "V\21\3\2\2\2WX\7\b\2\2XY\5\32\16\2YZ\7\20\2\2Z\23\3\2\2\2[_\7\t\2"+
      "\2\\^\t\2\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a"+
      "_\3\2\2\2bc\7\20\2\2c\25\3\2\2\2de\7\n\2\2ef\5\30\r\2fg\7\20\2\2g"+
      "\27\3\2\2\2hj\t\3\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\31"+
      "\3\2\2\2mn\7\21\2\2np\7\f\2\2oq\7\16\2\2po\3\2\2\2qr\3\2\2\2rp\3\2"+
      "\2\2rs\3\2\2\2s\33\3\2\2\2tu\t\4\2\2u\35\3\2\2\2vx\13\2\2\2wv\3\2"+
      "\2\2xy\3\2\2\2yz\3\2\2\2yw\3\2\2\2z\37\3\2\2\2\13(/:DJ_kry";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}