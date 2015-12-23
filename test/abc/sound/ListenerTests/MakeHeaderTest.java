package abc.sound.ListenerTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import abc.parser.XyzLexer;
import abc.parser.XyzParser;
import abc.sound.LinkingClasses.SystemWrapper;
import abc.sound.Listeners.MakeHeader;

public class MakeHeaderTest {
    //TESTING STRATEGY:
    //All fields present,all fields present but some are empty (e.g string list)
    //some fields have a valid Optional.isPresent()==true and some fields have it false
    //All fields other than necessary have Optional.isPresent()==false;
    
    @Test
    public void testAllFieldsPresent() throws FileNotFoundException{
        List<Integer> meter=new ArrayList<>();
        meter.add(3);
        meter.add(8);
        List<Integer> length= new ArrayList<>();
        length.add(1);
        length.add(16);
        List<Integer> tempoStuff= new ArrayList<>();
        tempoStuff.add(1);
        tempoStuff.add(8);
        List<String> voices= new ArrayList<>();
        voices.add("1");
        voices.add("2");
        File testFile= new File("sample_abc/fur_elise.abc");
        CharStream stream= new ANTLRInputStream(SystemWrapper.splitMusic(testFile).get(0));
        XyzLexer lexer=new XyzLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        XyzParser parser = new XyzParser(tokens);
        ParseTree tree = parser.root();
        MakeHeader nuts=new MakeHeader();
        ParseTreeWalker walker= new ParseTreeWalker();
        walker.walk(nuts, tree);
        assertEquals(1,nuts.getResult().getIndexNumber());
        assertEquals("Bagatelle No. 25 in A, WoO. 59",nuts.getResult().getTitle());
        assertEquals("Ludwig van Beethoven",nuts.getResult().getComposer());
        assertEquals(meter,nuts.getResult().getMeter());
        assertEquals(length,nuts.getResult().getLength());
        assertEquals(tempoStuff,nuts.getResult().getBeatsGivenLength());
        assertEquals(140,nuts.getResult().getTempo());
        assertEquals("Am",nuts.getResult().getKey());
        assertEquals(voices,nuts.getResult().getVoices());
    }
    @Test
    public void testSomeFieldsPresent() throws FileNotFoundException{
        List<Integer> meter= new ArrayList<>();
        meter.add(4);
        meter.add(4);
        List<Integer> length= new ArrayList<>();
        length.add(1);
        length.add(8);
        List<String> voices= new ArrayList<>();
        List<Integer> tempoStuff= new ArrayList<>();
        tempoStuff.add(1);
        tempoStuff.add(4);
        File testFile= new File("sample_abc/waxies_dargle.abc");
        CharStream stream= new ANTLRInputStream(SystemWrapper.splitMusic(testFile).get(0));
        XyzLexer lexer=new XyzLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        XyzParser parser = new XyzParser(tokens);
        ParseTree tree = parser.root();
        MakeHeader nuts=new MakeHeader();
        ParseTreeWalker walker= new ParseTreeWalker();
        walker.walk(nuts, tree);
        assertEquals("Waxie's Dargle",nuts.getResult().getTitle());
        assertEquals(meter,nuts.getResult().getMeter());
        assertEquals(length,nuts.getResult().getLength());
        assertEquals(tempoStuff,nuts.getResult().getBeatsGivenLength());
        assertEquals(voices,nuts.getResult().getVoices());
        assertEquals("G",nuts.getResult().getKey());
        assertEquals("Unknown",nuts.getResult().getComposer());
        assertEquals(180,nuts.getResult().getTempo());
        assertEquals(2167,nuts.getResult().getIndexNumber());
    }
    
    @Test
    public void testAllOptionalFieldsMissing() throws FileNotFoundException{
        List<Integer> meter= new ArrayList<>();
        meter.add(4);
        meter.add(4);
        List<Integer> length= new ArrayList<>();
        length.add(1);
        length.add(8);
        List<String> voices= new ArrayList<>();
        List<Integer> tempoStuff= new ArrayList<>();
        tempoStuff.add(1);
        tempoStuff.add(8);
        File testFile= new File("sample_abc/test.abc");
        CharStream stream= new ANTLRInputStream(SystemWrapper.splitMusic(testFile).get(0));
        XyzLexer lexer=new XyzLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        XyzParser parser = new XyzParser(tokens);
        ParseTree tree = parser.root();
        MakeHeader nuts=new MakeHeader();
        ParseTreeWalker walker= new ParseTreeWalker();
        walker.walk(nuts, tree);
        assertEquals(5646,nuts.getResult().getIndexNumber());
        assertEquals("Deez Nuts",nuts.getResult().getTitle());
        assertEquals("C",nuts.getResult().getKey());
        assertEquals(100,nuts.getResult().getTempo());
        assertEquals(voices,nuts.getResult().getVoices());
        assertEquals(meter,nuts.getResult().getMeter());
        assertEquals(length,nuts.getResult().getLength());
        assertEquals(tempoStuff,nuts.getResult().getBeatsGivenLength());
        assertEquals("Unknown",nuts.getResult().getComposer());
    }

}
