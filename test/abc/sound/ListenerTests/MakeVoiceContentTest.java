package abc.sound.ListenerTests;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import abc.parser.VoiceIdentifierLexer;
import abc.parser.VoiceIdentifierParser;
import abc.sound.Listeners.MakeVoiceContent;

public class MakeVoiceContentTest {
    /*
     * Test Strategy:
     * The MakeVoiceContent class parses the body of an abc music 
     *      file and gives out a map of voice labels mapped to their 
     *      music they should be playing in abc as a String
     * It works for only one voice and gives out a map 
     *      {"noVoice" : String abcMusic}
     *      and for multiple voices giving a map like 
     *      {"1" : String abcMusic, "2" : String abcMusic}
     *  
     *  Partitioning:
     *  - Only one voice
     *  - 2 voices with simple labels--> V:1, V:2
     *  - 2 voices with elaborate labels--> V:Jake, V:Ron
     *  - More than 2 voices (e.g. 5) with a mix of numbers and words as labels
     */

    /**
     * Helper method used in the tests below which 
     *  returns the map of voice labels to their abc music 
     *  generated from the body of the abc music provided as
     *  input text
     * @param input the input String of abc music body
     * @return Map<String, String> the map of voice labels to abc music
     */
    public static Map<String, String> returnMap(String input){
        String content = input;
        CharStream stream = new ANTLRInputStream(content);
        VoiceIdentifierLexer lexer = new VoiceIdentifierLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        VoiceIdentifierParser parser = new VoiceIdentifierParser(tokens);
        ParseTree tree = parser.music();
        ParseTreeWalker walker = new ParseTreeWalker();
        MakeVoiceContent listener = new MakeVoiceContent();
        walker.walk(listener, tree);
        return listener.getMap();
    }    

    //Only one voice
    @Test
    public void makeVoiceContentOneVoice(){
        String input = "A^BCD|EF/4AB|GGG/8G|AB/8AB|";
        assertTrue(returnMap(input).toString()
                .equals("{noVoice=A^BCD|EF/4AB|GGG/8G|AB/8AB|}"));
    }

    //2 voices with simple labels--> V:1, V:2
    @Test
    public void makeVoiceContent2VoicesSimple(){
        String input = "V:1" + "\r" + "ABCD|CDEF|" + "\r" + "V:2" 
                + "\r" + "cccc|dddd|" + "\r" + "V:1" + "\r" + "CCCC|DDDD|" 
                + "\r" + "V:2" + "\r" + "abcd|cdef|";
        assertTrue(returnMap(input).toString()
                .equals("{1=ABCD|CDEF|CCCC|DDDD|, 2=cccc|dddd|abcd|cdef|}"));
    }

    //2 voices with elaborate labels--> V:Jake, V:Ron
    @Test
    public void makeVoiceContent2VoicesElaborate(){
        String input = "V:Jake" + "\r" + "ABCD|CDEF|" + "\r" + "V:Ron" 
                + "\r" + "cccc|dddd|" + "\r" + "V:Jake" + "\r" + "CCCC|DDDD|" 
                + "\r" + "V:Ron" + "\r" + "abcd|cdef|";
        assertTrue(returnMap(input).toString()
                .equals("{Ron=cccc|dddd|abcd|cdef|, Jake=ABCD|CDEF|CCCC|DDDD|}"));
    }

    //More than 2 voices (e.g. 5) with a mix of numbers and words as labels
    @Test
    public void makeVoiceContentManyVoicesMedley(){
        String input = "V:Jake" + "\r" + "ABCD|CDEF|" + "\r" + "V:Ron" 
                + "\r" + "cccc|dddd|" + "\r" + "V:1" + "\r" + "CCCC|DDDD|" 
                + "\r" + "V:2" + "\r" + "abcd|cdef|" + "\r" + "V:Jake" + "\r" 
                + "ABCD|CDEF|" + "\r" + "V:Ron" + "\r" + "cccc|dddd|"
                + "\r" + "V:1" + "\r" + "CCCC|DDDD|" + "\r" + "V:2" 
                + "\r" + "abcd|cdef|";
        assertTrue(returnMap(input).toString()
                .equals("{Ron=cccc|dddd|cccc|dddd|, 1=CCCC|DDDD|CCCC|DDDD|, "
                        + "Jake=ABCD|CDEF|ABCD|CDEF|, 2=abcd|cdef|abcd|cdef|}"));
    }
}