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
    public void testNumberLiteral() {
        runtest("123",
                new Token(INT_LITERAL, 0, 0, "123"),
                new Token(EOF, 0, 3, ""));
        runtest("123 645 1235\"14",
                new Token(INT_LITERAL, 0, 0, "123"),
                new Token(INT_LITERAL, 0, 4, "645"),
                new Token(INT_LITERAL, 0, 8, "1235"),
                null,
                new Token(INT_LITERAL, 0, 13, "14"),
                new Token(EOF, 0, 15, ""));
    }

    @Test
    public void testLiteral() {
        runtest("123 \"abc\" 123 \"124\"",
                new Token(INT_LITERAL, 0, 0, "123"),
                new Token(STRING_LITERAL, 0, 4, "abc"),
                new Token(INT_LITERAL, 0, 10, "123"),
                new Token(STRING_LITERAL, 0, 14, "124"),
                new Token(EOF, 0, 19, ""));
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
        runtest("1ab 2c 3d",
                new Token(INT_LITERAL, 0, 0, "1"),
                new Token(ID, 0, 1, "ab"),
                new Token(INT_LITERAL, 0, 4, "2"),
                new Token(ID, 0, 5, "c"),
                new Token(INT_LITERAL, 0, 7, "3"),
                new Token(ID, 0, 8, "d"),
                new Token(EOF, 0, 9, ""));
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
    public void testIdentifierWithNumber() {
        runtest("afc 13 1 a a12 \"hello world\"\n 2",
                new Token(ID, 0, 0, "afc"),
                new Token(INT_LITERAL, 0, 4, "13"),
                new Token(INT_LITERAL, 0, 7, "1"),
                new Token(ID, 0, 9, "a"),
                new Token(ID, 0, 11, "a12"),
                new Token(STRING_LITERAL, 0, 15, "hello world"),
                new Token(INT_LITERAL, 1, 1, "2"),
                new Token(EOF, 1, 2, ""));
        runtest("boolean a1 = true\nint b2 = 123",
                new Token(BOOLEAN, 0, 0, "boolean"),
                new Token(ID, 0, 8, "a1"),
                new Token(EQL, 0, 11, "="),
                new Token(TRUE, 0, 13, "true"),
                new Token(INT, 1, 0, "int"),
                new Token(ID, 1, 4, "b2"),
                new Token(EQL, 1, 7, "="),
                new Token(INT_LITERAL, 1, 9, "123"),
                new Token(EOF, 1, 12, ""));
        runtest("if (a1+a2>=3) {\n" +
                        "    return true;\n"
                        + "}",
                new Token(IF, 0, 0, "if"),
                new Token(LPAREN, 0, 3, "("),
                new Token(ID, 0, 4, "a1"),
                new Token(PLUS, 0, 6, "+"),
                new Token(ID, 0, 7, "a2"),
                new Token(GEQ, 0, 9, ">="),
                new Token(INT_LITERAL, 0, 11, "3"),
                new Token(RPAREN, 0, 12, ")"),
                new Token(LCURLY, 0, 14, "{"),
                new Token(RETURN, 1, 4, "return"),
                new Token(TRUE, 1, 11, "true"),
                new Token(SEMICOLON, 1, 15, ";"),
                new Token(RCURLY, 2, 0, "}"),
                new Token(EOF, 2, 1, ""));
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
    public void testOperators() {
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
