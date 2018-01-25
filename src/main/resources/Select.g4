grammar Select;


query           : SELECT select_list WHERE filter_expr              #QueryExpression
                ;

select_list     : select_element (',' select_element)*              #SelectList
                ;

select_element  : COL_N_WSTAR                                       #SelectElement
                ;

filter_expr     : filter_expr AND filter_expr                       #AndFilterExpr
                | filter_expr OR filter_expr                        #OrFilterExpr
                | OPENPAREN filter_expr CLOSEPAREN                  #ParenExprt
                | filter                                            #SimpleFilter
                ;

filter          : literal OP literal                                #BasicFilter
                | COL_NAME INOP literal_list                        #InopFilter
                | COL_NAME LIKE WORD                                #LikeFilter
                ;

literal         : SLITERAL                                          #StringLiteral
                | INT                                               #IntLiteral
                | FLOAT                                             #FloatLiteral
                | BOOL                                              #BoolLiteral
                | COL_NAME                                          #LiteralColName
                ;

literal_list    : OPENPAREN SLITERAL (',' SLITERAL)* CLOSEPAREN      #LiteralListExpr
                ;

SELECT          : 'select';
WHERE           : 'where';
COL_NAME        : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-')*;
COL_N_WSTAR     : ('a'..'z'|'A'..'Z'|'_'|'*') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-'|'*')*;

DIGIT           : ('0'..'9');
INT             : '-'? DIGIT+;
FLOAT           : '-'? DIGIT+ '.' DIGIT+;
BOOL            : ('true'|'false');
SLITERAL        : '\'' WORD '\'';
OP              : ('>'|'<'|'>='|'<='|'='|'!=');

ESC             : [ \t\n\r]+ -> skip;
WORD            : ~[ \t\r\n")(=,]+;
OPENPAREN       : '(';
CLOSEPAREN      : ')';

OR              : 'or';
AND             : 'and';
INOP            : 'in';
LIKE            : 'like';

fragment
SGUTS           : (ESC | ~('\\' | '"'))*;
