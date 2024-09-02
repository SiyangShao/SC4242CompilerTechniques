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
                    assertEquals(expected, actual);
                } catch (Error e) {
                    if (expected != null)
                        fail(e.getMessage());
                    /* return; */
                }
                // Not sure check actual != null is correct or not here
            } while (actual != null &&!actual.isEOF());
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
                (Token) null,
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
                new Token(EOF, 0, 4, ""));
    }


}
