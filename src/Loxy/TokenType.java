package Loxy;

enum TokenType {
    //punctuation
    LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE,
    COMMA, DOT, SEMICOLON,
    //ops
    PLUS, MINUS, STAR, SLASH,
    //comparisons
    EQUAL, EQUAL_EQUAL,
    BANG, BANG_EQUAL,
    LESS, LESS_EQUAL,
    GREAT, GREAT_EQUAL,
    //literal
    IDENTIFIER, NUMBER, STRING,
    //keywords
    AND, OR,
    IF, ELSE, WHILE, FOR, RETURN,
    TRUE, FALSE, NIL,
    VAR, FUN,
    SUPER, THIS, CLASS,
    PRINT,

    EOF
}
