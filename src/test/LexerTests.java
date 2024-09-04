package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import lexer.Lexer;

import org.junit.Test;

import frontend.Token;
import frontend.Token.Type;

import static frontend.Token.Type.*;

/**
 * This class contains unit tests for your lexer. Currently, there is only one test, but you
 * are strongly encouraged to write your own tests.
 */
public class LexerTests {
    // helper method to run tests; no need to change this
    private final void runtest(String input, Token... output) {
        Lexer lexer = new Lexer(new StringReader(input));
        int i = 0;
        Token actual = new Token(MODULE, 0, 0, ""), expected;
        try {
            do {
                assertTrue(i < output.length);
                expected = output[i++];
                try {
                    actual = lexer.nextToken();
                    System.out.println("Expected Token: " + expected + " ; Actual Token: " + actual);
                    assertEquals(expected, actual);
                } catch (Error e) {
                    if (expected != null)
                        fail(e.getMessage());
                    /* return; */
                }
                // Not sure check actual != null is correct or not here
            } while (!actual.isEOF());
        } catch (IOException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    /**
     * Example unit test.
     */
    @Test
    public void testKWs() {
        // first argument to runtest is the string to lex; the remaining arguments
        // are the expected tokens
        runtest("module false return while",
                new Token(MODULE, 0, 0, "module"),
                new Token(FALSE, 0, 7, "false"),
                new Token(RETURN, 0, 13, "return"),
                new Token(WHILE, 0, 20, "while"),
                new Token(EOF, 0, 25, ""));
    }

    @Test
    public void testStringLiteralWithDoubleQuote() {
        runtest("\"\"\"",
                new Token(STRING_LITERAL, 0, 0, ""),
                (Token)null,
                new Token(EOF, 0, 3, ""));
    }

    @Test
    public void testStringLiteral() {
        runtest("\"\\n\"",
                new Token(STRING_LITERAL, 0, 0, "\\n"),
                new Token(EOF, 0, 4, ""));
    }

    @Test
    public void testIdentifier() {
        runtest("a b c",
                new Token(ID, 0, 0, "a"),
                new Token(ID, 0, 2, "b"),
                new Token(ID, 0, 4, "c"),
                new Token(EOF, 0, 5, ""));
        runtest("a1 b2 c3",
                new Token(ID, 0, 0, "a1"),
                new Token(ID, 0, 3, "b2"),
                new Token(ID, 0, 6, "c3"),
                new Token(EOF, 0, 8, ""));
        runtest("a_ b_ c_",
                new Token(ID, 0, 0, "a_"),
                new Token(ID, 0, 3, "b_"),
                new Token(ID, 0, 6, "c_"),
                new Token(EOF, 0, 8, ""));
    }

    @Test
    public void testInvalidIdentifier() {
        runtest("a _a",
                new Token(ID, 0, 0, "a"),
                null,
                new Token(ID, 0, 3, "a"),
                new Token(EOF, 0, 4, ""));
    }

    @Test
    public void testPunctuationBracket() {
        runtest("[(), (), ()]; {\"value_1\", \"value_2\"}",
                new Token(LBRACKET, 0, 0, "["),
                new Token(LPAREN, 0, 1, "("),
                new Token(RPAREN, 0, 2, ")"),
                new Token(COMMA, 0, 3, ","),
                new Token(LPAREN, 0, 5, "("),
                new Token(RPAREN, 0, 6, ")"),
                new Token(COMMA, 0, 7, ","),
                new Token(LPAREN, 0, 9, "("),
                new Token(RPAREN, 0, 10, ")"),
                new Token(RBRACKET, 0, 11, "]"),
                new Token(SEMICOLON, 0, 12, ";"),
                new Token(LCURLY, 0, 14, "{"),
                new Token(STRING_LITERAL, 0, 15, "value_1"),
                new Token(COMMA, 0, 24, ","),
                new Token(STRING_LITERAL, 0, 26, "value_2"),
                new Token(RCURLY, 0, 35, "}"),
                new Token(EOF, 0, 36, ""));
    }

    @Test
    public void testOperators(){
        runtest("/ == = >= <= > < - + *",
                new Token(DIV, 0, 0, "/"),
                new Token(EQEQ, 0, 2, "=="),
                new Token(EQL, 0, 5, "="),
                new Token(GEQ, 0, 7, ">="),
                new Token(LEQ, 0, 10, "<="),
                new Token(GT, 0, 13, ">"),
                new Token(LT, 0, 15, "<"),
                new Token(MINUS, 0, 17, "-"),
                new Token(PLUS, 0, 19, "+"),
                new Token(TIMES, 0, 21, "*"),
                new Token(EOF, 0, 22, ""));
    }


}
