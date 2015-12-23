package abc.player;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import abc.sound.LinkingClasses.SystemWrapper;

/**
 * Main entry point of application.
 */
public class Main {
    public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException, IOException {
        
        //Musical file being played (Change the file directory to play different pieces)
        File file = new File("sample_abc/fur_elise.abc");
        //Launches the SequencePlayer and plays the music
        SystemWrapper.play(file, 50);
    }
}