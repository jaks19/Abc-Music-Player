/*
 * Compile all your grammars using
 *       java -jar ../../../lib/antlr.jar *.g4
 * then Refresh in Eclipse.
 */
grammar Xyz;
import Configuration;

// Header
root : header EOF;
header : fieldnumber fieldtitle otherfields* fieldkey filler*;

fieldnumber        : 'X:' DIGIT ENDOFLINE;
fieldtitle         : 'T:' (TEXT | DIGIT)* ENDOFLINE;
otherfields        : fieldcomposer | fielddefaultlength | fieldmeter | fieldtempo |fieldvoice;
fieldcomposer      : 'C:' (TEXT | DIGIT)* ENDOFLINE;
fielddefaultlength : 'L:' METERFRACTION ENDOFLINE;
fieldmeter         : 'M:' meter ENDOFLINE;
fieldtempo         : 'Q:' tempo ENDOFLINE;
fieldvoice         : 'V:' (TEXT | DIGIT)* ENDOFLINE;	
fieldkey           : 'K:' key ENDOFLINE;

DIGIT : [0-9]+;
C:'C';
ENDOFLINE : '\n' | '\r' '\n'?;
METERFRACTION : DIGIT+ '/' DIGIT+;

key : (TEXT | '#' | C)+;

tempo : METERFRACTION '=' DIGIT+;
meter : C | 'C|' | METERFRACTION;

TEXT : ([a-z] | [A-Z] | '.' | ',' | '-' | ['])+;

filler: .+?;
/* tell Antlr to ignore spaces around tokens. */
SPACES: [ ]+ -> skip;