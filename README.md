# Abc-Music-Player
Software parses musical pieces in abc notation (.abc files) and plays them

How to play a song:

- abcplayer/src/abc.player/Main.java is the main entry point of the application

- Through abstraction, the Main.java class is very simple and has 2 lines of code:

        File file = new File("sample_abc/fur_elise.abc");
        SystemWrapper.play(file, 0);

- For different abc files to be played, the file directory (which in this example
     is "sample_abc/fur_elise.abc") should be changed to the file directory of the 
     file that needs to be played.
     
- On the second line of code, the '50' starts for the tick at which to start the song.
    The number can be altered as long as it is >= 0 if different startTicks are needed.
    
- Click 'Run' in eclipse and have fun!