package abc.sound.LinkingClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import abc.parser.AbcLexer;
import abc.parser.AbcParser;
import abc.parser.VoiceIdentifierLexer;
import abc.parser.VoiceIdentifierParser;
import abc.parser.XyzLexer;
import abc.parser.XyzParser;
import abc.sound.ADTs.Bar;
import abc.sound.ADTs.Voice;
import abc.sound.ClassCodeUsed.SequencePlayer;
import abc.sound.Listeners.MakeHeader;
import abc.sound.Listeners.MakeLcm;
import abc.sound.Listeners.MakeMusic;
import abc.sound.Listeners.MakeVoiceContent;

/**
 * This static class provides static helper methods that enable connection between 
 *      all the parts of the project and that are called in Main.java for the user
 *      to play music
 */
public class SystemWrapper {

    /**
     * Play the input file using Java MIDI API and displays
     * header information to the standard output stream.
     * @param filename Valid file containing abc music
     * @param player The abc music player to play the piece in
     * @param atTick The tick at which to  start playing the piece
     * @throws InvalidMidiDataException 
     * @throws MidiUnavailableException 
     * @throws IOException 
     */
    public static void play(File filename, int atTick) 
            throws MidiUnavailableException, InvalidMidiDataException, IOException{
        List<String> splitText = splitMusic(filename);
        String header = splitText.get(0);
        String body = splitText.get(1);
        HeaderHolder headerObject = parseHeader(header);
        String keyText = headerObject.getKey();
        int numL = headerObject.getLength().get(0);
        int denL = headerObject.getLength().get(1);
        int numQ = headerObject.getBeatsGivenLength().get(0);
        int denQ = headerObject.getBeatsGivenLength().get(1);
        int overallLcm = parseOverallLcm(body); 
        overallLcm = overallLcm * denL * numQ;
        Voice voiceToPlay = parseAllVoices(parseFileForVoiceMap(body),
                keyText, overallLcm, numL, denL, numQ, denQ);
        SequencePlayer player = new SequencePlayer(headerObject.getTempo(), overallLcm);
        voiceToPlay.play(player, atTick);
        printConsole(headerObject);
        player.play();
        System.in.read();
    }

    //-------------------------------Header Operations---------------------------------------------------
    /**
     * Parse the header of an abcFile and gives out a HeaderHolder object
     * with all the data extracted from the header.
     * @param headerText abcFile's header text to parse
     *      input respects all abc notation rules
     * @return HeaderHolder the Object containing all the extracted data
     */
    public static HeaderHolder parseHeader(String headerText){
        String content = headerText;
        CharStream stream = new ANTLRInputStream(content);
        XyzLexer lexer = new XyzLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        XyzParser parser = new XyzParser(tokens);
        ParseTree tree = parser.header();
        ParseTreeWalker walker = new ParseTreeWalker();
        MakeHeader listener = new MakeHeader();
        walker.walk(listener, tree);
        return listener.getResult();
    }

    /**
     * Splices a piece of abc music into a header and a body
     * @param filename Valid filename of file containing abc music
     * @return List A String list of length 2 where entry at index 0 is the head, 
     *      and entry at index 1 represents the body.
     * @throws FileNotFoundException
     */
    public static List<String> splitMusic(File filename) 
            throws FileNotFoundException{
        List<String> result= new ArrayList<>();
        boolean enter=false;
        String header="";
        String body="";
        Scanner scanner= new Scanner(filename);
        while (scanner.hasNext()){
            String nextLine=scanner.nextLine();
            if (!nextLine.startsWith("%")){
                if(enter){
                    body=body+nextLine+"\r\n";
                }
                else{header=header+nextLine+"\r\n";}

                if(nextLine.startsWith("K:")){
                    enter=true;
                }
            }
        }
        //replace '||' by '|]' as they are dealt with in the same way
        //avoiding two '|' from different lines from being confused as '||'
        body=body.replace("||","|]");
        result.add(header);
        result.add(body);
        scanner.close();
        return result;
    }

    //-------------------------------Body Operations---------------------------------------------------
    /**
     * Takes in the map of voice labels to the content of each voice and gives
     *  out a playable Voice object which is a combination of playable Objects
     *  generated from each voice's content
     * @param map the map of voice labels to the content to be played by each voice
     * @param keyText the key to play the piece in 
     * @param lcm the least common multiple to be used for ticks per beat
     * @return Voice the playable object 
     */
    public static Voice parseAllVoices(Map<String, String> map, String keyText, 
            int lcm, int numL, int denL, int numQ, int denQ){
        List<Bar> allBars = new ArrayList<Bar>();
        for (String voiceLabel : map.keySet()){
            Bar barRetrieved = parseVoiceContent(map.get(voiceLabel), 
                    keyText, lcm, numL, denL, numQ, denQ);
            allBars.add(barRetrieved);
        }
        return new Voice(allBars);
    }

    /**
     * Parse the body of an abcFile and gives out a map of:
     *      voice label mapped to the voice music content.
     * @param bodyText abcFile's body text to parse
     *      input respects all abc notation rules
     * @return Map<String, String> a map of voice label mapped to music content
     */
    public static Map<String, String> parseFileForVoiceMap(String bodyText){
        String content = bodyText;
        CharStream stream = new ANTLRInputStream(content);
        VoiceIdentifierLexer lexer = new VoiceIdentifierLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        VoiceIdentifierParser parser = new VoiceIdentifierParser(tokens);
        ParseTree tree = parser.root();
        ParseTreeWalker walker = new ParseTreeWalker();
        MakeVoiceContent listener = new MakeVoiceContent();
        walker.walk(listener, tree);
        return correctVoiceText(listener.getMap());
    }

    /**
     * Takes the body belonging to a voice and corrects situations where bar lines
     * appear back to back keeping musical equivalence and simplifying parsing
     * @param a map of voice label mapped to music content
     * @return Map<String, String> a map of voice label mapped to music content with
     *      back to back bars replaced while keeping musical meaning intact
     */
    public static Map<String, String> correctVoiceText(Map<String, String> voiceToMaterial){
        Map<List<String>, String> barToBar = new HashMap<List<String>, String>();
        barToBar.put(Arrays.asList("||"), "|");
        barToBar.put(Arrays.asList("|[|", "[|[|", "[||"), "[|");
        barToBar.put(Arrays.asList("]||", "||]", "[||]", "|]|]"), "|]");
        barToBar.put(Arrays.asList(":||", ":|[|", ":||]", ":|:|", "|::|", "|:|", "[|:|", "|]:|"), ":|");
        barToBar.put(Arrays.asList("||:", "[||:", "|]|:", "|:|", "|:[|", "|:|]", "|:|:"), "|:");
        for (String voiceLabel : voiceToMaterial.keySet()){
            String text = voiceToMaterial.get(voiceLabel);
            for (List<String> list : barToBar.keySet()){
                for (String entry : list){
                    text = text.replace(entry, barToBar.get(list));
                }
            }
            voiceToMaterial.put(voiceLabel, text);
        }
        return voiceToMaterial;
    }

    /**
     * Parse the music belonging to a voice and return a playable Object
     * @param input String to parse
     *      input respects all abc notation rules
     * @return Bar the playable musical Bar
     */
    public static Bar parseVoiceContent(String contents, String keyText, int lcm,
            int numL, int denL, int numQ, int denQ){
        CharStream stream = new ANTLRInputStream(contents);
        AbcLexer lexer = new AbcLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        AbcParser parser = new AbcParser(tokens);
        lexer.reportErrorsAsExceptions();
        parser.reportErrorsAsExceptions();
        ParseTree tree = parser.root();
        MakeMusic listener = new MakeMusic(keyText, lcm, numL, denL, numQ, denQ);
        new ParseTreeWalker().walk(listener, tree);
        return listener.getBar();
    }

    //-------------------------------LCM Operations---------------------------------------------------
    /**
     * Parse an abc file to get the (voice:content) map and parse each
     *      voice content to find the Lcm for note duration denominators across
     *      all the voice contents
     * @param input abcFile to parse
     *      input respects all abc notation rules
     * @return int the LCM for note duration denominators across all voices
     */
    public static int parseOverallLcm(String abcText){ 
        Map<String, String> voiceToContent = parseFileForVoiceMap(abcText);
        List<Integer> individualLcms = new ArrayList<Integer>();
        for (String voiceLabel : voiceToContent.keySet()){
            individualLcms.add(parseVoiceContentForLcm(voiceToContent.get(voiceLabel)));
        }
        if (individualLcms.size() == 1){
            return individualLcms.get(0);
        }
        else if (individualLcms.size() == 2){
            return lcmTwoIntegers(individualLcms.get(0), individualLcms.get(1));
        }
        else{
            int counter = 1;
            int tempLcm = individualLcms.get(0);
            while (counter <= individualLcms.size()-1){
                tempLcm = lcmTwoIntegers(tempLcm, individualLcms.get(counter));
                counter += 1;
            }
            return tempLcm;
        }
    }

    /**
     * Parse the music belonging to a voice and return the LCM for 
     *      note duration denominators to use as ticks per beat
     * @param input String to parse
     *      input respects all abc notation rules
     * @return int the LCM for note duration denominators in this voice
     */
    public static int parseVoiceContentForLcm(String contents){
        CharStream stream = new ANTLRInputStream(contents);
        AbcLexer lexer = new AbcLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        AbcParser parser = new AbcParser(tokens);
        ParseTree tree = parser.root();
        ParseTreeWalker walker = new ParseTreeWalker();
        MakeLcm listener = new MakeLcm();
        walker.walk(listener, tree);
        return listener.getLcm();
    }

    /**
     * Find LCM of 2 integers
     * @param integer1 the first integer
     * @param integer2 the second integer
     * @return int the LCM 
     */
    public static int lcmTwoIntegers(int integer1, int integer2){
        if ((integer1 > integer2) && (integer1 % integer2 == 0)){
            return integer1;
        }
        else if ((integer2 > integer1) && (integer2 % integer1 == 0)){
            return integer2;
        }
        else if (integer1 == integer2){
            return integer1;
        }
        else {return integer1 * integer2;}
    }

    //--------------------------Generating Console Text Operations------------------------------------------
    /**
     * Print information about the musical piece being played to the console
     * @param integer1 the first integer
     * @param integer2 the second integer
     * @return int the LCM 
     */
    public static void printConsole(HeaderHolder headerObject){
        String symbol = "\u266C" + "\u266B" + "\u2669" + "\u266A";
        System.out.print(symbol + " Playing Track: " + headerObject.getTitle().toUpperCase() + " ");
        System.out.println("");
        System.out.println(symbol + " Composer: " + headerObject.getComposer());
        System.out.println(symbol + " Piece Index: " + headerObject.getIndexNumber());
        System.out.println(symbol + " Key: " + headerObject.getKey());
        System.out.println(symbol + " Default Note Length: " + headerObject.getLength().get(0)
                + "/" + headerObject.getLength().get(1));
        System.out.println(symbol + " Meter: " + headerObject.getMeter().get(0) 
                + "/" + headerObject.getMeter().get(1));
        System.out.println(symbol + " Tempo: " + headerObject.getTempo());
    }
}
