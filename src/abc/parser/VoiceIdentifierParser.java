// Generated from VoiceIdentifier.g4 by ANTLR 4.5.1

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
public class VoiceIdentifierParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, NEWLINE=4, WHITESPACE=5, V=6, TEXT=7;
  public static final int
    RULE_root = 0, RULE_music = 1, RULE_voiced = 2, RULE_nonvoiced = 3, 
    RULE_voiceid = 4, RULE_musicline = 5, RULE_comment = 6, RULE_name = 7;
  public static final String[] ruleNames = {
    "root", "music", "voiced", "nonvoiced", "voiceid", "musicline", "comment", 
    "name"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "':'", "'%'", "'v'", null, "' '", "'V'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, "NEWLINE", "WHITESPACE", "V", "TEXT"
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
  public String getGrammarFileName() { return "VoiceIdentifier.g4"; }

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

  public VoiceIdentifierParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class RootContext extends ParserRuleContext {
    public MusicContext music() {
      return getRuleContext(MusicContext.class,0);
    }
    public TerminalNode EOF() { return getToken(VoiceIdentifierParser.EOF, 0); }
    public RootContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_root; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).enterRoot(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).exitRoot(this);
    }
  }

  public final RootContext root() throws RecognitionException {
    RootContext _localctx = new RootContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_root);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(16);
      music();
      setState(17);
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

  public static class MusicContext extends ParserRuleContext {
    public NonvoicedContext nonvoiced() {
      return getRuleContext(NonvoicedContext.class,0);
    }
    public List<VoicedContext> voiced() {
      return getRuleContexts(VoicedContext.class);
    }
    public VoicedContext voiced(int i) {
      return getRuleContext(VoicedContext.class,i);
    }
    public List<TerminalNode> NEWLINE() { return getTokens(VoiceIdentifierParser.NEWLINE); }
    public TerminalNode NEWLINE(int i) {
      return getToken(VoiceIdentifierParser.NEWLINE, i);
    }
    public MusicContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_music; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).enterMusic(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).exitMusic(this);
    }
  }

  public final MusicContext music() throws RecognitionException {
    MusicContext _localctx = new MusicContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_music);
    int _la;
    try {
      int _alt;
      setState(34);
      switch (_input.LA(1)) {
      case TEXT:
        enterOuterAlt(_localctx, 1);
        {
        setState(19);
        nonvoiced();
        }
        break;
      case V:
        enterOuterAlt(_localctx, 2);
        {
        {
        setState(20);
        voiced();
        setState(25);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,0,_ctx);
        while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
          if ( _alt==1 ) {
            {
            {
            setState(21);
            match(NEWLINE);
            setState(22);
            voiced();
            }
            } 
          }
          setState(27);
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input,0,_ctx);
        }
        setState(31);
        _errHandler.sync(this);
        _la = _input.LA(1);
        while (_la==NEWLINE) {
          {
          {
          setState(28);
          match(NEWLINE);
          }
          }
          setState(33);
          _errHandler.sync(this);
          _la = _input.LA(1);
        }
        }
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

  public static class VoicedContext extends ParserRuleContext {
    public VoiceidContext voiceid() {
      return getRuleContext(VoiceidContext.class,0);
    }
    public TerminalNode NEWLINE() { return getToken(VoiceIdentifierParser.NEWLINE, 0); }
    public MusiclineContext musicline() {
      return getRuleContext(MusiclineContext.class,0);
    }
    public VoicedContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_voiced; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).enterVoiced(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).exitVoiced(this);
    }
  }

  public final VoicedContext voiced() throws RecognitionException {
    VoicedContext _localctx = new VoicedContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_voiced);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(36);
      voiceid();
      setState(37);
      match(NEWLINE);
      setState(38);
      musicline();
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

  public static class NonvoicedContext extends ParserRuleContext {
    public List<MusiclineContext> musicline() {
      return getRuleContexts(MusiclineContext.class);
    }
    public MusiclineContext musicline(int i) {
      return getRuleContext(MusiclineContext.class,i);
    }
    public List<TerminalNode> NEWLINE() { return getTokens(VoiceIdentifierParser.NEWLINE); }
    public TerminalNode NEWLINE(int i) {
      return getToken(VoiceIdentifierParser.NEWLINE, i);
    }
    public NonvoicedContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_nonvoiced; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).enterNonvoiced(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).exitNonvoiced(this);
    }
  }

  public final NonvoicedContext nonvoiced() throws RecognitionException {
    NonvoicedContext _localctx = new NonvoicedContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_nonvoiced);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(40);
      musicline();
      setState(45);
      _errHandler.sync(this);
      _alt = getInterpreter().adaptivePredict(_input,3,_ctx);
      while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
        if ( _alt==1 ) {
          {
          {
          setState(41);
          match(NEWLINE);
          setState(42);
          musicline();
          }
          } 
        }
        setState(47);
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,3,_ctx);
      }
      setState(51);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==NEWLINE) {
        {
        {
        setState(48);
        match(NEWLINE);
        }
        }
        setState(53);
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

  public static class VoiceidContext extends ParserRuleContext {
    public TerminalNode V() { return getToken(VoiceIdentifierParser.V, 0); }
    public NameContext name() {
      return getRuleContext(NameContext.class,0);
    }
    public List<TerminalNode> WHITESPACE() { return getTokens(VoiceIdentifierParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(VoiceIdentifierParser.WHITESPACE, i);
    }
    public CommentContext comment() {
      return getRuleContext(CommentContext.class,0);
    }
    public VoiceidContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_voiceid; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).enterVoiceid(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).exitVoiceid(this);
    }
  }

  public final VoiceidContext voiceid() throws RecognitionException {
    VoiceidContext _localctx = new VoiceidContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_voiceid);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(54);
      match(V);
      setState(55);
      match(T__0);
      setState(57);
      _la = _input.LA(1);
      if (_la==WHITESPACE) {
        {
        setState(56);
        match(WHITESPACE);
        }
      }

      setState(59);
      name();
      setState(63);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==WHITESPACE) {
        {
        {
        setState(60);
        match(WHITESPACE);
        }
        }
        setState(65);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(67);
      _la = _input.LA(1);
      if (_la==T__1) {
        {
        setState(66);
        comment();
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

  public static class MusiclineContext extends ParserRuleContext {
    public TerminalNode TEXT() { return getToken(VoiceIdentifierParser.TEXT, 0); }
    public List<TerminalNode> WHITESPACE() { return getTokens(VoiceIdentifierParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(VoiceIdentifierParser.WHITESPACE, i);
    }
    public CommentContext comment() {
      return getRuleContext(CommentContext.class,0);
    }
    public MusiclineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_musicline; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).enterMusicline(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).exitMusicline(this);
    }
  }

  public final MusiclineContext musicline() throws RecognitionException {
    MusiclineContext _localctx = new MusiclineContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_musicline);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(69);
      match(TEXT);
      setState(73);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==WHITESPACE) {
        {
        {
        setState(70);
        match(WHITESPACE);
        }
        }
        setState(75);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(77);
      _la = _input.LA(1);
      if (_la==T__1) {
        {
        setState(76);
        comment();
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

  public static class CommentContext extends ParserRuleContext {
    public List<TerminalNode> WHITESPACE() { return getTokens(VoiceIdentifierParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(VoiceIdentifierParser.WHITESPACE, i);
    }
    public List<TerminalNode> TEXT() { return getTokens(VoiceIdentifierParser.TEXT); }
    public TerminalNode TEXT(int i) {
      return getToken(VoiceIdentifierParser.TEXT, i);
    }
    public CommentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_comment; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).enterComment(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).exitComment(this);
    }
  }

  public final CommentContext comment() throws RecognitionException {
    CommentContext _localctx = new CommentContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_comment);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(79);
      match(T__1);
      setState(83);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==WHITESPACE || _la==TEXT) {
        {
        {
        setState(80);
        _la = _input.LA(1);
        if ( !(_la==WHITESPACE || _la==TEXT) ) {
        _errHandler.recoverInline(this);
        } else {
          consume();
        }
        }
        }
        setState(85);
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

  public static class NameContext extends ParserRuleContext {
    public TerminalNode TEXT() { return getToken(VoiceIdentifierParser.TEXT, 0); }
    public TerminalNode V() { return getToken(VoiceIdentifierParser.V, 0); }
    public NameContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_name; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).enterName(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof VoiceIdentifierListener ) ((VoiceIdentifierListener)listener).exitName(this);
    }
  }

  public final NameContext name() throws RecognitionException {
    NameContext _localctx = new NameContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_name);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(86);
      _la = _input.LA(1);
      if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << V) | (1L << TEXT))) != 0)) ) {
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

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t[\4\2\t\2\4\3"+
      "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3"+
      "\3\3\3\3\3\3\3\7\3\32\n\3\f\3\16\3\35\13\3\3\3\7\3 \n\3\f\3\16\3#"+
      "\13\3\5\3%\n\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5.\n\5\f\5\16\5\61\13"+
      "\5\3\5\7\5\64\n\5\f\5\16\5\67\13\5\3\6\3\6\3\6\5\6<\n\6\3\6\3\6\7"+
      "\6@\n\6\f\6\16\6C\13\6\3\6\5\6F\n\6\3\7\3\7\7\7J\n\7\f\7\16\7M\13"+
      "\7\3\7\5\7P\n\7\3\b\3\b\7\bT\n\b\f\b\16\bW\13\b\3\t\3\t\3\t\2\2\n"+
      "\2\4\6\b\n\f\16\20\2\4\4\2\7\7\t\t\4\2\5\5\b\t]\2\22\3\2\2\2\4$\3"+
      "\2\2\2\6&\3\2\2\2\b*\3\2\2\2\n8\3\2\2\2\fG\3\2\2\2\16Q\3\2\2\2\20"+
      "X\3\2\2\2\22\23\5\4\3\2\23\24\7\2\2\3\24\3\3\2\2\2\25%\5\b\5\2\26"+
      "\33\5\6\4\2\27\30\7\6\2\2\30\32\5\6\4\2\31\27\3\2\2\2\32\35\3\2\2"+
      "\2\33\31\3\2\2\2\33\34\3\2\2\2\34!\3\2\2\2\35\33\3\2\2\2\36 \7\6\2"+
      "\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"%\3\2\2\2#!\3\2"+
      "\2\2$\25\3\2\2\2$\26\3\2\2\2%\5\3\2\2\2&\'\5\n\6\2\'(\7\6\2\2()\5"+
      "\f\7\2)\7\3\2\2\2*/\5\f\7\2+,\7\6\2\2,.\5\f\7\2-+\3\2\2\2.\61\3\2"+
      "\2\2/-\3\2\2\2/\60\3\2\2\2\60\65\3\2\2\2\61/\3\2\2\2\62\64\7\6\2\2"+
      "\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\t\3\2"+
      "\2\2\67\65\3\2\2\289\7\b\2\29;\7\3\2\2:<\7\7\2\2;:\3\2\2\2;<\3\2\2"+
      "\2<=\3\2\2\2=A\5\20\t\2>@\7\7\2\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB"+
      "\3\2\2\2BE\3\2\2\2CA\3\2\2\2DF\5\16\b\2ED\3\2\2\2EF\3\2\2\2F\13\3"+
      "\2\2\2GK\7\t\2\2HJ\7\7\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2"+
      "LO\3\2\2\2MK\3\2\2\2NP\5\16\b\2ON\3\2\2\2OP\3\2\2\2P\r\3\2\2\2QU\7"+
      "\4\2\2RT\t\2\2\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\17\3\2\2"+
      "\2WU\3\2\2\2XY\t\3\2\2Y\21\3\2\2\2\r\33!$/\65;AEKOU";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}