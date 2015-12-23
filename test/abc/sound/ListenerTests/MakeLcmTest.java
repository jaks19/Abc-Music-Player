package abc.sound.ListenerTests;

import static org.junit.Assert.assertTrue;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import abc.parser.AbcLexer;
import abc.parser.AbcParser;
import abc.sound.Listeners.MakeLcm;

public class MakeLcmTest {
    /*
     * Test Strategy:
     * The MakeLCM Class calculated the LCM of the denominators of all the 
     *  note durations in the abc music of one voice of a musical piece
     * The test method will be to provide different Strings of abc text to
     *  MakeLCM and see if the returned LCM is correct
     *  
     *  Partitioning:
     *  - All durations are the default note lengths (No modifications)
     *  - Durations are varied
     *      Scenario1: Use usual denominators: 
     *          2, 4, 8, 16
     *      Scenario2: Use usual denominators with numbers in between:
     *          2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
     *      Scenario3 (medley): Use unrelated numbers (Prime and no-prime and varying sizes)
     *          2, 7, 13, 17, 19, 27, 34, 35, 99
     *  - Include accidentals, rests and repeat symbols with Scenario1
     */

    /**
     * Helper method used in the tests below which 
     *  returns the LCM calculated from the note durations in the 
     *  input text
     * @param input the input String of abc music belonging to one voice
     * @return int the LCM obtained
     */
    public static int returnLcm(String input){
        String content = input;
        CharStream stream = new ANTLRInputStream(content);
        AbcLexer lexer = new AbcLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        AbcParser parser = new AbcParser(tokens);
        ParseTree tree = parser.abcmusic();
        ParseTreeWalker walker = new ParseTreeWalker();
        MakeLcm listener = new MakeLcm();
        walker.walk(listener, tree);
        return listener.getLcm();
    }

    //All durations are default lengths
    @Test
    public void makeLcmDefaultLengths(){
        String input = "ABCD|EFAB|GGGG|ABAB|";
        assertTrue(returnLcm(input) == 12);
    }
    //Varied lengths: Scenario1
    @Test
    public void makeLcmScenario1(){
        String input = "A/2BC/4D|EF/2AB/8|G/16GG/16G|A2B/4AB|";
        assertTrue(returnLcm(input) == 96);
    }

    //Varied lengths: Scenario2
    @Test
    public void makeLcmScenario2(){
        String input = "A/2BC/3D|EF/5GA/6|C/7DE/8F/9|GA/10F/11A/12|C/13EE/14FF/15G/16|";
        assertTrue(returnLcm(input) == 4324320);
    }

    //Varied lengths: Scenario3
    @Test
    public void makeLcmScenario3(){
        String input = "A/2BC/7D|EF/13AB/17|G/19GG/27G|A/34B/35AB/9|";
        assertTrue(returnLcm(input) == 333316620);
    }

    //Scenario1 with gimmicks
    @Test
    public void makeLcmScenario1Gimmicks(){
        String input = "^A/2BC/4D,,|EF/2A'B/8|G/16G'''G/16^^G|A2B/4AB|";
        assertTrue(returnLcm(input) == 96);
    }
}