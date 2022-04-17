package Loxy;

import java.util.*;

class LoxLexer {
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    LoxLexer(String src) {
        source = src;
    }

    List<Token> tokenize() {
        while(!atEnd()) {
            start = current;
            scan();
        }

        tokens.add(new Token(TokenType.EOF, "", line, null));
        return tokens;
    }

    private boolean atEnd() {
        return current >= source.length();
    }

    private char advance() {
        return source.charAt(current++);
    }

    private char peek() {
        if(atEnd()) return 0;
        return source.charAt(current);
    }

    private void addToken(TokenType t) { return addToken(t, null); }

    private void addToken(TokenType t, Object o) {
        String txt = source.substring(start, current);
        tokens.add(new Token(t, txt, o, line));
    }

    private boolean match(char c) {
        if (atEnd()) return false;
        if (current != c) return false;
        current++;
        return true;
    }

    private void scan() {
        char c = advance();
        switch (c) {
            case '(': addToken(TokenType.LEFT_PAREN); break;
            case ')': addToken(TokenType.RIGHT_PAREN); break;
            case '{': addToken(TokenType.LEFT_BRACE); break;
            case '}': addToken(TokenType.RIGHT_BRACE); break;
            case '.': addToken(TokenType.DOT); break;
            case ',': addToken(TokenType.COMMA); break;
            case ';': addToken(TokenType.SEMICOLON); break;
            case '+': addToken(TokenType.PLUS); break;
            case '-': addToken(TokenType.MINUS); break;
            case '*': addToken(TokenType.STAR); break;
            case '/':
                if (match('/')) {
                    while (peek() != '\n' && !atEnd()) advance();
                } else {
                    addToken(TokenType.SLASH);
                }
                break;
        }
    }

    private
}
