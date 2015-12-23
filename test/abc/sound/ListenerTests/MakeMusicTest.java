package abc.sound.ListenerTests;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import abc.parser.AbcLexer;
import abc.parser.AbcParser;
import abc.sound.ADTs.Bar;
import abc.sound.ClassCodeUsed.SequencePlayer;
import abc.sound.Listeners.MakeMusic;

public class MakeMusicTest {
    
    // Testing strategy
    //    input contains notes, rests, chords, tuplets, multiple measures, single repeats, alternate repeats, section endings
    //    input contains uppercase letters, lowercase letters, commas, and apostrophes
    //    input contains sharp, double sharp, natural, flat, double flat
    //    input contains key signature with sharps, flats, or only naturals
    //    input has no notelength written, has only denominator, has only numerator, has only slash, has both
    //    
    
    // input contains notes, multiple measures, uppercase letters, lowercase letters, commas, apostrophes, sharp, flat, natural,
    // natural key signature, no notelength written, only numerator, both numerator and denominator 
    @Test
    public void makeMusicTest1() throws IOException {
        // chromatic scale
        String str = "C,,/4 ^C,,1/4 D,,/4 ^D,,1/4 E,,1/4 F,,/4 ^F,,/4 G,,/4 ^G,,/4 A,,/4 ^A,,/4 B,,/4 =C, |"
                + "C,/4 ^C,1/4 D,/4 ^D,1/4 E,1/4 F,/4 ^F,/4 G,/4 ^G,/4 A,/4 ^A,/4 B,/4 =C |"
                + "C/4 ^C1/4 D/4 ^D1/4 E1/4 F/4 ^F/4 G/4 ^G/4 A/4 ^A/4 B/4 =c |"
                + "c/4 ^c1/4 D'/4 ^d1/4 E'1/4 F'/4 ^f/4 G'/4 ^g/4 A'/4 ^a/4 b/4 =c' |"
                + "C''/4 ^c'1/4 D''/4 ^d'1/4 E''1/4 F''/4 ^f'/4 G''/4 ^g'/4 A''/4 ^a'/4 B''/4 =C''' |]"
                + "C'''/4 B''/4 _b'/4 A''/4 _a'/4 G''/4 _g'/4 F''/4 E''1/4 _e'1/4 D''/4 _d'1/4 C'' | "
                + "=c'/4 b/4 _b/4 A'/4 _a/4 G'/4 _g/4 F'/4 E'1/4 _e1/4 D'/4 _d1/4 c | "
                + "=c/4 B/4 _B/4 A/4 _A/4 G/4 _G/4 F/4 E1/4 _E1/4 D/4 _D1/4 C | "
                + "=C/4 B,/4 _B,/4 A,/4 _A,/4 G,/4 _G,/4 F,/4 E,1/4 _E,1/4 D,/4 _D,1/4 C, | "
                + "=C,/4 B,,/4 _B,,/4 A,,/4 _A,,/4 G,,/4 _G,,/4 F,,/4 E,,1/4 _E,,1/4 D,,/4 _D,,1/4 C,,";
        String keyText = "C";
        int ticksPerBeat = 4;
        try {
            SequencePlayer player = new SequencePlayer(40, ticksPerBeat);
            Bar bar = parse(str, keyText, ticksPerBeat);
            bar.play(player, ticksPerBeat);
            player.play();
            System.in.read();
        } catch (MidiUnavailableException mue) {
            mue.printStackTrace();
        } catch (InvalidMidiDataException imde) {
            imde.printStackTrace();
        }
    }
    
    // input contains notes, rests, chords, tuplets, multiple measures, input contains uppercase letters, lowercase letters, 
    // input contains sharps and flats, natural key signature, input has no notelength written, and both num and denom written
    @Test
    public void makeMusicTest2() throws IOException {
        String str = "[^F1/2e1/2] [F1/2e1/2] z1/2 [F1/2e1/2] z1/2 [c1/2F1/2] [Fe] |"
                + "[GBg] z G z | c3/2 G1/2 z E | E1/2 A B _B1/2 A |"
                + "(3Geg a f1/2 g1/2 | z1/2 e c1/2 d1/2 B3/4 z3/4 |";
        String keyText = "C";
        int ticksPerBeat = 12;
        int tempo = 200;
        try {
            SequencePlayer player = new SequencePlayer(tempo, ticksPerBeat);
            Bar bar = parse(str, keyText, ticksPerBeat);
            bar.play(player, ticksPerBeat);
            player.play();
            System.in.read();
        } catch (MidiUnavailableException mue) {
            mue.printStackTrace();
        } catch (InvalidMidiDataException imde) {
            imde.printStackTrace();
        }
    }
    
    // input contains notes, multiple measures, alternate repeats, section endings, input contains uppercase letters,
    // lowercase letters, commas, and apostrophes, natural key signature, input has no notelength written
    @Test
    public void makeMusicTest3() throws IOException {
        String str = "A, A, A, A, |: B, B, B, B, | C C C C | D D D D |"
                + " E E E E |[1 F F F F | G G G G | AAAA |A,A,A,A, :|"
                + "[2 DDDD | CCCC | B,B,B,B, |] A,A,A,A,|"
                + "[1 eeee :|[2 a a a a |]";
        String keyText = "C";
        int ticksPerBeat = 12;
        int tempo = 120;

        try {
            SequencePlayer player = new SequencePlayer(tempo, ticksPerBeat);
            Bar bar = parse(str, keyText, ticksPerBeat);
            bar.play(player, ticksPerBeat);
            player.play();
            System.in.read();
        } catch (MidiUnavailableException mue) {
            mue.printStackTrace();
        } catch (InvalidMidiDataException imde) {
            imde.printStackTrace();
        }
    }
    
    // input contains notes, multiple measures, single repeat, uppercase letters, key signature sharp,
    // notelength not written or only numerator written 
    @Test
    public void makeMusicTest4() throws IOException {
        String str = "| D D A A|B B A2|G G F F|E/2E/2E/2E/2 D2|"
                + "A A G2 | F F E2|A       A  G  G | F F E2|"
                + "D   D    A    A |B B A2 | G    G  F    F | E     E  D2:|";
        String keyText = "D";
        int ticksPerBeat = 12;
        int tempo = 120;

        try {
            SequencePlayer player = new SequencePlayer(tempo, ticksPerBeat);
            Bar bar = parse(str, keyText, ticksPerBeat);
            bar.play(player, ticksPerBeat);
            player.play();
            System.in.read();
        } catch (MidiUnavailableException mue) {
            mue.printStackTrace();
        } catch (InvalidMidiDataException imde) {
            imde.printStackTrace();
        }
    }
    
    // input contains notes, multiple measures, single repeat, uppercase letters, key signature flat,
    // notelength not written or only numerator written, contains double sharp and double flat
    @Test
    public void makeMusicTest5() throws IOException {
        String str = "B, B, B, B, |: [C __d] C C C | D D D D | [E__f]  E E E |"
                + " F F F F |[1 G G G G | A A A A | BBBB |B,B,B,B, :|"
                + "[2 EEEE | DDDD | CCCC |] B,B,B,B,|"
                + "[1 ffff :|[2 b b b b |]";
        String keyText = "Bb";
        int ticksPerBeat = 12;
        int tempo = 120;

        try {
            SequencePlayer player = new SequencePlayer(tempo, ticksPerBeat);
            Bar bar = parse(str, keyText, ticksPerBeat);
            bar.play(player, ticksPerBeat);
            player.play();
            System.in.read();
        } catch (MidiUnavailableException mue) {
            mue.printStackTrace();
        } catch (InvalidMidiDataException imde) {
            imde.printStackTrace();
        }
    }
    
    /**
     * Parse an abcFile.
     * @param input abcFile to parse
     *      input respects all abc notation rules
     * @return Element AST for the input
     * @throws FileNotFoundException 
     * @throws IllegalArgumentException if the expression is invalid
     */
    public static Bar parse(String content, String keyText, int ticksPerBeat) {
        CharStream stream = new ANTLRInputStream(content);
        AbcLexer lexer = new AbcLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        AbcParser parser = new AbcParser(tokens);
        lexer.reportErrorsAsExceptions();
        parser.reportErrorsAsExceptions();
        ParseTree tree = parser.root();
        MakeMusic listener = new MakeMusic(keyText, ticksPerBeat, 1, 4, 1, 4);
        new ParseTreeWalker().walk(listener, tree);
        Trees.inspect(tree, parser);
        return listener.getBar();
    }
    
}