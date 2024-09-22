package parser;

import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "parser.beaver".
 */
public class Parser extends beaver.Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short ID = 1;
		static public final short RCURLY = 2;
		static public final short SEMICOLON = 3;
		static public final short MINUS = 4;
		static public final short LCURLY = 5;
		static public final short INT = 6;
		static public final short VOID = 7;
		static public final short BOOLEAN = 8;
		static public final short IF = 9;
		static public final short WHILE = 10;
		static public final short RETURN = 11;
		static public final short BREAK = 12;
		static public final short RPAREN = 13;
		static public final short LPAREN = 14;
		static public final short PUBLIC = 15;
		static public final short IMPORT = 16;
		static public final short LBRACKET = 17;
		static public final short MODULE = 18;
		static public final short ELSE = 19;
		static public final short STRING_LITERAL = 20;
		static public final short TYPE = 21;
		static public final short RBRACKET = 22;
		static public final short EQL = 23;
		static public final short TRUE = 24;
		static public final short FALSE = 25;
		static public final short INT_LITERAL = 26;
		static public final short PLUS = 27;
		static public final short TIMES = 28;
		static public final short DIV = 29;
		static public final short MOD = 30;
		static public final short EQEQ = 31;
		static public final short NEQ = 32;
		static public final short LEQ = 33;
		static public final short GEQ = 34;
		static public final short LT = 35;
		static public final short GT = 36;
		static public final short COMMA = 37;
	}
	static public class AltGoals {
		static public final short Dummy = 38;
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pDbLTmLLKKXlzpRcxKa9jG50H4YeQ440YOK08X823D1Y88M2WMG14hofF38oyes52A28W" +
		"LHSeC80#M9yjG3Rs92W8AYYWgbkLtjpkPCvTxCyECpdZkV7ljyw#rsrddhYFfbCPfe2Peeg" +
		"hKHrUhh$gflwxH05LczFJEwBcsrZCynLEZZqhH9zb9CutL44tMVRfNr#jctQhHILtn37fMM" +
		"dqVQZhzBnMdqRkeWphg4NMoNtMLobIE4bDdtQ5EckILX$sOhcxd8P7PjaLJhDggTO4UrVsC" +
		"lr0NwJOYkoj72TLJld9r5x$wQgGyDL4pNQu6kaGDTQKkLe7QsbRxKstKNetLMaMwL2LggbB" +
		"xJSrLgCiqJItKJUtKqhQfbIhKGptLoxxN5HgamRfED#X6JZDKmpH2Dz4RgJ6wtVRh5etNdR" +
		"P3T#iUswwfpFEW7j83UaoFCsyHCnQpPeaxTIbdxEpE#6zwCkc1GecSnPNDKqi#hnoUKwxJ6" +
		"sRG#wJLOwZfTAMT9vdHhZpBxioNV8gLA6rH2b42h#JxCV$il3UHsRoRCVm1UXVoretv6l76" +
		"vfFD72BhaR5SCjg0h0MeMUIt3LckJtP3ukECJbu9lCs9oYEdSN8Qycj9pbiHsHfV4pAQu9t" +
		"eHHjttW9tmf0HXSoQuB#LnyfPtCNSBm4Ln3HsRU1MZ35Fu5QSFiCjoniXTYjE9zu0QJOy2y" +
		"$3B9W7ys41B8INu2bu6kR28dWBNeObi1ZUXANm2io1PV0gl0PFmklm1Yo7j#4TM0KhOGsiW" +
		"7TXDQo3zs03h8Kdu0DO3y$0XybprC0r4pw6v#1z#0W#WohOx6E6m9Rek5IuFeTjlZyIgdt$" +
		"4zWE6#5JhqtmTXFiWHqmrMlxlHqF1tp$eBU7l7q13iDMU16Erh6lOx0JTi7nYBxNsvDm8gA" +
		"FyBPfNUVzFy0rC4daVcYQcCcH$foQlfdjZlIFdC#wn9zEMMEbjmkzZVhMUPkRCcPS7UTQ7k" +
		"clE9#zHSPDJADDrtzqsU$sWxEqzekTiP$FYVZ9jIViE$lMZjinEshVEEM8Qm$xg2$jQzglQ" +
		"aSTWYzSxo3m7xC3aJdtsXxRRRjifvskrNwqK#pc3zS$IrDAlGqWfFfcKt5345KtHgKEGQvQ" +
		"rz23QjoJcbX9R3dtvVZBY2l3jkS#4oNCrm4wKckhYAzoAyVvGeLyes9yfKAgPk0gPpjiak8" +
		"8HVWhNFqLzJYWQejlL87w$GtnTLYU");

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
		}
	};

	static final Action RETURN6 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 6];
		}
	};

	static final Action RETURN3 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 3];
		}
	};

	static final Action RETURN9 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 9];
		}
	};

	static final Action RETURN4 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 4];
		}
	};

	static final Action RETURN5 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 5];
		}
	};

	static final Action RETURN37 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 37];
		}
	};

	// turn off automated error recovery
	@Override
	protected void recoverFromError(Symbol token, TokenStream in) throws java.io.IOException, Exception {
		super.recoverFromError(new Symbol(0), in);
	}

	private final Action[] actions;

	public Parser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			Action.RETURN,	// [0] $goal = Module
			RETURN2,	// [1] $goal = $Dummy Dummy; returns 'Dummy' although none is marked
			RETURN6,	// [2] Module = MODULE ID LCURLY Imports Declarations RCURLY; returns 'RCURLY' although none is marked
			RETURN2,	// [3] Imports = Import Imports; returns 'Imports' although none is marked
			Action.NONE,  	// [4] Imports = 
			RETURN3,	// [5] Import = IMPORT ID SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN2,	// [6] Declarations = Declaration Declarations; returns 'Declarations' although none is marked
			Action.NONE,  	// [7] Declarations = 
			Action.RETURN,	// [8] Declaration = FunctionDeclaration
			Action.RETURN,	// [9] Declaration = FieldDeclaration
			Action.RETURN,	// [10] Declaration = TypeDeclaration
			RETURN9,	// [11] FunctionDeclaration = Accessibility TypeName ID LPAREN ParamList RPAREN LCURLY Statements RCURLY; returns 'RCURLY' although none is marked
			RETURN4,	// [12] FieldDeclaration = Accessibility TypeName ID SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN6,	// [13] TypeDeclaration = Accessibility TYPE ID EQL STRING_LITERAL SEMICOLON; returns 'SEMICOLON' although none is marked
			Action.RETURN,	// [14] Accessibility = PUBLIC
			Action.NONE,  	// [15] Accessibility = 
			RETURN2,	// [16] Statements = Statement Statements; returns 'Statements' although none is marked
			Action.NONE,  	// [17] Statements = 
			Action.RETURN,	// [18] Statement = VarDeclaration
			Action.RETURN,	// [19] Statement = BlockStatements
			Action.RETURN,	// [20] Statement = IfStatement
			Action.RETURN,	// [21] Statement = WhileStatement
			Action.RETURN,	// [22] Statement = BreakStatement
			Action.RETURN,	// [23] Statement = ReturnStatement
			Action.RETURN,	// [24] Statement = ExpressionStatement
			RETURN3,	// [25] VarDeclaration = TypeName ID SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN3,	// [26] BlockStatements = LCURLY Statements RCURLY; returns 'RCURLY' although none is marked
			RETURN5,	// [27] IfStatement = IF LPAREN Expression RPAREN OptionalElse; returns 'OptionalElse' although none is marked
			RETURN2,	// [28] OptionalElse = ELSE Statement; returns 'Statement' although none is marked
			Action.NONE,  	// [29] OptionalElse = 
			RETURN5,	// [30] WhileStatement = WHILE LPAREN Expression RPAREN Statement; returns 'Statement' although none is marked
			RETURN2,	// [31] BreakStatement = BREAK SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN3,	// [32] ReturnStatement = RETURN OptionalExpression SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN2,	// [33] ExpressionStatement = Expression SEMICOLON; returns 'SEMICOLON' although none is marked
			Action.RETURN,	// [34] OptionalExpression = Expression
			Action.NONE,  	// [35] OptionalExpression = 
			Action.RETURN,	// [36] BaseType = PrimitiveType
			Action.RETURN,	// [37] BaseType = ID
			Action.RETURN,	// [38] PrimitiveType = INT
			Action.RETURN,	// [39] PrimitiveType = BOOLEAN
			Action.RETURN,	// [40] PrimitiveType = VOID
			RETURN2,	// [41] TypeName = BaseType ArraySuffix; returns 'ArraySuffix' although none is marked
			RETURN3,	// [42] ArraySuffix = LBRACKET RBRACKET ArraySuffix; returns 'ArraySuffix' although none is marked
			Action.NONE,  	// [43] ArraySuffix = 
			Action.RETURN,	// [44] Expression = MINUS
			Action.NONE,  	// [45] ParamList = 
			RETURN37	// [46] Dummy = MODULE INT VOID IF ELSE WHILE RETURN BREAK BOOLEAN PUBLIC TRUE FALSE INT_LITERAL STRING_LITERAL ID TYPE IMPORT PLUS MINUS TIMES DIV MOD EQEQ NEQ LEQ GEQ LT GT LBRACKET RPAREN COMMA RCURLY LCURLY SEMICOLON RBRACKET LPAREN EQL; returns 'EQL' although none is marked
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
