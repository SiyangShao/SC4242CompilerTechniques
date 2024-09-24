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
		runtest(
				"module Test { public void main() { a = 1 + 1 + 1 * (3 + 2) / 4 * 2 + test() + anotherTest(1, 2) + hahaha(1, \"hello\"); } }");
	}

	@Test
	public void testFunctionDefine() {
		runtest("module Test { public int def() { return 1; } }");
		runtest("module Test { public int def(1) { return 1; } }", false);
		runtest("module Test { public int def(int a) { return 1; } }");
		runtest("module Test { public int def(int a, int b) { return 1; } }");
		runtest("module Test { public int def(int a, int b, c d) { return 1; } }");
		runtest("module Test { public int def(int a int b, c d) { return 1; } }", false);
		runtest("module Test { public int def(int 1, int b, c d) { return 1; } }", false);
	}

	@Test
	public void testModule() {
		runtest("md Test { public int def() { return 1; } }", false);
		runtest("module 1 { public int def() { return 1; } }", false);
		runtest("module test }", false);
		runtest("module Test { import 12x;}", false);
		runtest("module Test { import Test;}");
	}

	@Test
	public void testStatement() {
		// empty statement
		runtest("module Test { public void main() { } }");
		// var declaration
		runtest("module Test { public void main() { int x; }}");
		// block statements
		runtest("module Test { public void main() { {int x;} }}");
		// If statement
		runtest("module Test { public void main() { if (true) {int x;} }}");
		// If-else statement
		runtest("module Test { public void main() { if (true) {int x;} else {int y;} }}");
		// If-else if-else statement
		runtest("module Test { public void main() { if (true) {int x;} else if (false) {int y;} else {int z;} }}");
		// while statement
		runtest("module Test { public void main() { while (true) {int x;} }}");
		// break statement
		runtest("module Test { public void main() { break; }}");
		// return statement
		runtest("module Test { public void main() { return; }}");
		// return expression statement
		runtest("module Test { public void main() { return 1+1; }}");
	}
}
