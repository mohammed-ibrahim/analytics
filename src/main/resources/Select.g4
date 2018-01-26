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
 | bool                                           #boolExpression
 | IDENTIFIER                                     #identifierExpression
 | DECIMAL                                        #decimalExpression
 | SLITERAL                                       #sliteralExpression
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

AND        : 'AND' ;
OR         : 'OR' ;
NOT        : 'NOT';
TRUE       : 'TRUE' ;
FALSE      : 'FALSE' ;
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
SLITERAL   : '\'' IDENTIFIER '\'';
WS         : [ \r\t\u000C\n]+ -> skip;
