grammar Select;

parse
 : 'select' select_list 'where' expression EOF
 ;

select_list
 : IDENTIFIER (',' IDENTIFIER)*                               #selectElement
 ;

expression
 : LPAREN expression RPAREN                       #parenExpression
 | NOT expression                                 #notExpression
 | left=expression op=comparator right=expression #comparatorExpression
 | left=expression op=binary right=expression     #binaryExpression
 | IDENTIFIER LIKE SLITERAL                       #likeExpression
 | IDENTIFIER IN obj_list                         #inExpression
 | bool                                           #boolExpression
 | IDENTIFIER                                     #identifierExpression
 | DECIMAL                                        #decimalExpression
 | SLITERAL                                       #sliteralExpression
 ;

obj_list
 : LPAREN SLITERAL (',' SLITERAL)* RPAREN         #sliteralList
 | LPAREN DECIMAL (',' DECIMAL)* RPAREN           #decimalList
 ;

comparator
 : GT | GE | LT | LE | EQ | NE | IS
 ;

binary
 : AND | OR
 ;

bool
 : TRUE | FALSE
 ;

AND        : A N D;
OR         : O R;
NOT        : N O T;
TRUE       : T R U E ;
FALSE      : F A L S E ;
LIKE       : L I K E;
IN         : I N;
GT         : '>' ;
GE         : '>=' ;
LT         : '<' ;
LE         : '<=' ;
EQ         : '=' ;
NE         : '!=' ;
IS         : 'is' ;
LPAREN     : '(' ;
RPAREN     : ')' ;
DECIMAL    : '-'? [0-9]+ ( '.' [0-9]+ )? ;
IDENTIFIER : [a-zA-Z_*] [a-zA-Z_0-9*]* ;
SLITERAL   : '\'' (~'\'')* '\'' ;
WS         : [ \r\t\u000C\n]+ -> skip;

fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');
