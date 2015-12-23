/*
 * Compile all your grammars using
 *       java -jar ../../../lib/antlr.jar *.g4
 * then Refresh in Eclipse.
 */
grammar Abc;
import Configuration;

// Header
root : abcmusic EOF;
abcmusic : firstbarline? WHITESPACE* measure measureandbar* BARLINE? NEWLINE? WHITESPACE*;
measureandbar : BARLINE NTHREPEAT? WHITESPACE* measure;
measure : element+;
element : (note | chord | tupletelement) WHITESPACE*;

// note is either a pitch or a rest
note : (pitch | REST) notelength?;
pitch : ACCIDENTAL? BASENOTE OCTAVE?;
OCTAVE : '\''+ | ','+;
notelength : numerator | '/' | (numerator '/') | '/' denominator | (numerator '/' denominator);
notelengthstrict : numerator denominator;

numerator : DIGIT+;
denominator : DIGIT+;
// '^' is sharp, '_' is flat, and '=' is neutral
ACCIDENTAL : '^' | '^^' | '_' | '__' | '=';

BASENOTE : 'C' | 'D' | 'E' | 'F' | 'G' | 'A' | 'B'
        | 'c' | 'd' | 'e' | 'f' | 'g' | 'a' | 'b';

REST : 'z';

// tuplets
tupletelement : tupletspec (note | chord)+;
tupletspec : '(' DIGIT;

// chords
chord : '[' WHITESPACE* (note WHITESPACE*)+ ']';

firstbarline : BARLINE;
BARLINE : '|' | '||' | '[|' | '|]' | ':|' | '|:';
NTHREPEAT : '[1' | '[2';

DIGIT : [0-9];
WHITESPACE : ' ';
NEWLINE : '\n' | '\r\n' | '\r';
