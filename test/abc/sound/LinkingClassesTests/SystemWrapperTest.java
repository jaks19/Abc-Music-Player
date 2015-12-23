package abc.sound.LinkingClassesTests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;

import abc.sound.LinkingClasses.SystemWrapper;

public class SystemWrapperTest {
    /*
     * Overall Test Strategy:
     * This static class provides static helper methods that combine 
     *      MakeVoiceContent, MakeMusic, HeaderHolder and MakeLcm
     *      as a wrap-up class
     * It also contains all the Parsing methods used in the project 
     * 
     * The Methods found in it are:
     * play() - A combination of all methods found below (Tested by ear in Main.java)
     * parseHeader() - Tested in HeaderHolderTest.java and MakeHeaderTest.java
     * splitMusic() - TESTED BELOW *
     * parseAllVoices() - Returns a playable musical Voice (Tested by ear in Main.java)
     * parseFileForVoiceMap() - Tested in MakeVoiceContentTest
     * parseVoiceContent() - Tested in MakeMusicTest
     * parseVoiceContentForLcm() - Tested in MakeLcmTest
     * parseOverallLcm() - TESTED BELOW
     * lcmTwoIntegers() - TESTED BELOW
     * printConsole() - Visual addendum tested in Main.java
     */   

    /*
     * Test Strategy for splitMusic(): 
     * This method takes in a whole abc music file and chops off the header from the
     *  body. It then returns both in a List with index 0 being the Header text and 
     *  index 1 being the body text
     *  
     * Partitioning:
     *  - Header and Body present (Only partition as this is the official abc file rule)
     */

    //Header and Body present
    @Test
    public void testSplitMusic() throws FileNotFoundException{
        File testFile = new File("sample_abc/piece1.abc");
        assertTrue(SystemWrapper.splitMusic(testFile).get(1).toString()
                .equals("C C C3/4 D/4 E | E3/4 D/4 E3/4 F/4 G2 | (3ccc "
                        + "(3GGG (3EEE (3CCC | G3/4 F1/4 E3/4 D1/4 C2" + "\r\n"));

    }

    /*
     * Test Strategy for parseOverallLcm():
     * This method takes in a map of voice labels to the voice's abc music content
     *  and it produces an Overall LCM of the note duration denominators found in 
     *  the voice content of all the voices
     *  
     * We have already tested finding LCM of one voice in MakeLcmTest so here we will
     *  agree that finding LCM of one voice content works and try to vary the number
     *  of voices and their respective LCMs
     *  
     * Partitioning:
     *  - Only one voice so map is in form --> {noVoice : abcMusic String}
     *  - Two voices with same LCMs
     *  - Two voices with different LCMs
     *  - More than two voices with some varying and some equal LCMs
     */

    //Only one voice so map is in form --> {noVoice : abcMusic String}
    @Test
    public void parseOverallLcmOneVoice(){
        String input = "A^BCD|EF/3AB|GGG/5G|AB/2AB|";
        assertTrue(SystemWrapper.parseOverallLcm(input) == 60);
    }

    //Two voices with same LCMs
    @Test
    public void parseOverallLcm2VoicesSame(){
        String input = "V:1" + "\r" + "AB/3CD/3|CD/5EF|" + "\r" + "V:2" 
                + "\r" + "cc/2cc|dddd|" + "\r" + "V:1" + "\r" + "CCC/5C|D/2DDD|" 
                + "\r" + "V:2" + "\r" + "abcd/3|cd/3e/5f|";
        assertTrue(SystemWrapper.parseOverallLcm(input) == 60);
    }

    //Two voices with different LCMs
    @Test
    public void parseOverallLcm2VoicesDiff(){
        String input = "V:1" + "\r" + "AB/3CD/3|CD/5EF|" + "\r" + "V:2" 
                + "\r" + "cccc/4|dd/8dd|" + "\r" + "V:1" + "\r" + "CCC/5C|D/2DDD|" 
                + "\r" + "V:2" + "\r" + "a/4bcd|c/8def|";
        assertTrue(SystemWrapper.parseOverallLcm(input) == 5760);
    }

    //More than two voices with some varying and some equal LCMs
    @Test
    public void parseOverallLcmManyVoices(){
        String input = "V: Jake" + "\r" + "AB/4CD|C/8DEF|" + "\r" + "V: Ron" 
                + "\r" + "cc/3cc|d/6ddd|" + "\r" + "V: 1" + "\r" + "CCCC|DDDD|" 
                + "\r" + "V:2" + "\r" + "ab/7cd|c/8def|" + "\r" + "V: Jake" + "\r" 
                + "ABCD|C/16DE/8F|" + "\r" + "V:Ron" + "\r" + "ccc/2c|d/6ddd|"
                + "\r" + "V: 1" + "\r" + "CCCC|DDDD|" + "\r" + "V: 2" 
                + "\r" + "abc/5d|c/13def|";
        assertTrue(SystemWrapper.parseOverallLcm(input) == 524160);
    }

    /*
     * Test Strategy for lcmTwoIntegers():
     * This method returns the LCM of 2 integers
     * 
     * Partitioning:
     * - 2 Numbers that are equal
     * - 2 Numbers where one is the factor of the other
     * - 2 Numbers which are prime
     */

    //2 Numbers that are equal
    @Test
    public void lcmTwoIntegersTest1(){
        assertTrue(SystemWrapper.lcmTwoIntegers(5, 5) == 5);
    }

    //2 Numbers where one is the factor of the other
    @Test
    public void lcmTwoIntegersTest2(){
        assertTrue(SystemWrapper.lcmTwoIntegers(5, 15) == 15);
    }

    //2 Numbers which are prime
    @Test
    public void lcmTwoIntegersTest4(){
        assertTrue(SystemWrapper.lcmTwoIntegers(13, 17) == 221);
    }
}
