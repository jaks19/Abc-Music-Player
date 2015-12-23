/*
 * Compile all your grammars using
 *       java -jar ../../../lib/antlr.jar *.g4
 * then Refresh in Eclipse.
 */
grammar VoiceIdentifier;
import Configuration;

// Header
root : music EOF;
music : nonvoiced | (voiced (NEWLINE voiced)* NEWLINE* );
voiced: voiceid NEWLINE musicline;
nonvoiced: musicline (NEWLINE musicline)* NEWLINE*;

voiceid: V ':' WHITESPACE? name WHITESPACE* comment?;
musicline: TEXT WHITESPACE* comment?;

comment: '%' (WHITESPACE | TEXT)*;
NEWLINE : '\n' | '\r\n' | '\r';
WHITESPACE: ' ';
V: 'V';
name: (TEXT | V | 'v');
TEXT: ([a-u] | [w-z] | [A-U] | [W-Z] | [0-9]
        | '[1' | '[2' | '|' | '||' | '[|' | '|]' | ':|' | '|:'
        | '^' | '^^' | '_' | '__' | '=' | '\'' | '/' | ',' | '(' | '[' | ']' 
        |WHITESPACE)+;
//NAME: ([a-z] | [A-Z] | [0-9])+;