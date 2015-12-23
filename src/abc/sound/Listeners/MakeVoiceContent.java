package abc.sound.Listeners;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import abc.parser.VoiceIdentifierListener;
import abc.parser.VoiceIdentifierParser.CommentContext;
import abc.parser.VoiceIdentifierParser.MusicContext;
import abc.parser.VoiceIdentifierParser.MusiclineContext;
import abc.parser.VoiceIdentifierParser.NameContext;
import abc.parser.VoiceIdentifierParser.NonvoicedContext;
import abc.parser.VoiceIdentifierParser.RootContext;
import abc.parser.VoiceIdentifierParser.VoicedContext;
import abc.parser.VoiceIdentifierParser.VoiceidContext;

public class MakeVoiceContent implements VoiceIdentifierListener {
    private boolean voiced = false;
    private String currentVoice = "";
    //If no voices, just one key: noVoice with music as String
    //If voices, keys are voice labels and their entries are the music Strings
    private final Map<String, String> voiceContent = new HashMap<>();

    /**
     * Returns the Map of voice labels to their abc music String they
     *  need to play, generated from this input
     * @return the Map obtained
     */
    public Map<String, String> getMap(){
        return voiceContent;
    }

    @Override public void enterEveryRule(ParserRuleContext arg0) {}
    @Override public void exitEveryRule(ParserRuleContext arg0) {}
    @Override public void visitErrorNode(ErrorNode arg0) {}
    @Override public void visitTerminal(TerminalNode arg0) {}
    @Override public void enterRoot(RootContext ctx) {}
    @Override public void exitRoot(RootContext ctx) {}
    @Override public void enterVoiced(VoicedContext ctx) {
        this.voiced = true;
    }
    @Override public void exitVoiced(VoicedContext ctx) {}
    @Override public void enterNonvoiced(NonvoicedContext ctx) {
        voiceContent.putIfAbsent("noVoice", "");
    }
    @Override public void exitNonvoiced(NonvoicedContext ctx) {}
    @Override public void enterVoiceid(VoiceidContext ctx) {}
    @Override public void exitVoiceid(VoiceidContext ctx) {
        currentVoice = ctx.name().getText();
        voiceContent.putIfAbsent(currentVoice, "");
    }
    @Override public void enterMusicline(MusiclineContext ctx) {}
    @Override public void exitMusicline(MusiclineContext ctx) {
        if (voiced == true){
            voiceContent.put(currentVoice, voiceContent.get(currentVoice).concat(ctx.getText().toString()));
        }
        if (voiced == false){
            voiceContent.put("noVoice", voiceContent.get("noVoice").concat(ctx.getText().toString()));
        }
    }
    @Override public void enterComment(CommentContext ctx) {}
    @Override public void exitComment(CommentContext ctx) {}
    @Override public void enterMusic(MusicContext ctx) {}
    @Override public void exitMusic(MusicContext ctx) {}

    @Override
    public void enterName(NameContext ctx) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exitName(NameContext ctx) {
        // TODO Auto-generated method stub
        
    }
}