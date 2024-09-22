package test;

import static org.junit.Assert.fail;

import java.io.StringReader;

import lexer.Lexer;

import org.junit.Test;

import parser.Parser;

public class ParserTests {
	private void runtest(String src) {
		runtest(src, true);
	}

	private void runtest(String src, boolean succeed) {
		Parser parser = new Parser();
		try {
			parser.parse(new Lexer(new StringReader(src)));
			if (!succeed) {
				fail("Test was supposed to fail, but succeeded");
			}
		} catch (beaver.Parser.Exception e) {
			if (succeed) {
				e.printStackTrace();
				fail(e.getMessage());
			}
		} catch (Throwable e) {
			e.printStackTrace();
			fail(e.getMessage() + " (unexpected exception)");
		}
	}

	@Test
	public void testEmptyModule() {
		runtest("module Test { }");
	}

	@Test
	public void testPrimitiveType() {
		runtest("module Test { public int a; }");
		runtest("module Test { public void a; }");
		runtest("module Test { public boolean a; }");
	}

	@Test
	public void testArrayType() {
		runtest("module Test { public int[] a; }");
		runtest("module Test { public int[][] a; }");
		runtest("module Test { public int[]int[] a; }", false);
	}

	@Test
	public void testIdType() {
		runtest("module Test { public A a; }");
		runtest("module Test { public A[] a; }");
		runtest("module Test { public A[][] a; }");
		runtest("module Test { public A[]A[] a; }", false);
	}

	@Test
	public void testAssignment() {
		runtest("module Test { public void main() { a = 1; } }");
		runtest("module Test { public void main() { a[1] = 1; } }");
		runtest("module Test { public void main() { a[1][2] = 1; } }");
		runtest("module Test { public void main() { a[1][2][3] = 1; } }");
		runtest("module Test { public void main() { a[1+2][2*3][3+4][4*5][5/6][7%6] = 1; } }");
	}

	@Test
	public void testArithmetic() {
		runtest("module Test { public void main() { a = 1 + 1; } }");
		runtest("module Test { public void main() { a = 1 - 1; } }");
		runtest("module Test { public void main() { a = 1 * 1; } }");
		runtest("module Test { public void main() { a = 1 / 1; } }");
		runtest("module Test { public void main() { a = 1 % 1; } }");
		runtest("module Test { public void main() { a = 1 + 1 + 1 * (3 + 2) / 4 * 2; } }");
		runtest("module Test { public void main() { a = 1 + 1 + 1 * (3 + 2) / 4 * 2 + test() + anotherTest(1, 2) + hahaha(1, \"hello\"); } }");
	}
}
