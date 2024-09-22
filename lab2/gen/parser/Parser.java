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
		static public final short LBRACKET = 2;
		static public final short LPAREN = 3;
		static public final short MINUS = 4;
		static public final short STRING_LITERAL = 5;
		static public final short INT_LITERAL = 6;
		static public final short TRUE = 7;
		static public final short FALSE = 8;
		static public final short RCURLY = 9;
		static public final short RPAREN = 10;
		static public final short SEMICOLON = 11;
		static public final short RBRACKET = 12;
		static public final short LCURLY = 13;
		static public final short INT = 14;
		static public final short BOOLEAN = 15;
		static public final short VOID = 16;
		static public final short IF = 17;
		static public final short WHILE = 18;
		static public final short BREAK = 19;
		static public final short RETURN = 20;
		static public final short COMMA = 21;
		static public final short EQL = 22;
		static public final short IMPORT = 23;
		static public final short PUBLIC = 24;
		static public final short EQEQ = 25;
		static public final short NEQ = 26;
		static public final short LT = 27;
		static public final short LEQ = 28;
		static public final short GT = 29;
		static public final short GEQ = 30;
		static public final short PLUS = 31;
		static public final short TIMES = 32;
		static public final short DIV = 33;
		static public final short MOD = 34;
		static public final short TYPE = 35;
		static public final short MODULE = 36;
		static public final short ELSE = 37;
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pDLcTqL4KOlMyJ4r9MGaa1WSGaf9564a9w9J6a1n11m8g2YXMneOAYOWHi$EJuotDi4H5" +
		"1KL6neOAe88WACTWLR34eQ2oVzytExdcyNL8qdEFkkVDzS#VEDz$CUpFp0CTqp48#9g4Qfw" +
		"4UPw082p4HUOZ6jLY4Qn21A8p0I9o2KHYDCHZUJtraF$LnlUZ7sVGzgpDjwfin6#UY0ZMOZ" +
		"5hKIIVcenWbYCMjM8RRC1Qf68zi7xePc8ap1qg7atL#lUdcus9cv$3IsMUTgsPjPwVuPCzM" +
		"R8Djf1mlNQBIDNlnwOgVuyKN#XpjT9$iUJxP2tfWxVdEHPDqs5bfaxLUoWMO9WzZgHTlh$l" +
		"XKbo6ot45hiHLkAHN$OckpqALPHqkuZoiJ2cSqeubQ88$Ja80xiOW12C4eT9jcuTJFi5riX" +
		"kBSI#2iCgjGxabMgN5Ny48WGWpUoYqSPoLk5r4luEhC0tto1ySSJ26oFiOYd3v6J4OXbCHZ" +
		"mGa8Hbt80Lfo40P6f652N80Kz620da2qycTXNFaCPpFE7Dn8URXQlb8FiJrk44#m8suIVQm" +
		"roso5ylHYZlvvEx2VG2plv$H4rNy59u3gHmXdMDaSaTaSK$aO8BU1$aeuDjOn9tz$zBtJsr" +
		"mt$lffnl8fnR4TwEIJyd9qsCmmZ24Ap#Cvx6tBePF8dR0TExyUjEvieltqlcUTNzO#qXDnz" +
		"4r7uTl6O0S$ak#PYt4Ymtctyxv8vodTgWNxrsttchHVT2VsBfz7VnjJBdkuLHdZFk4g#SxU" +
		"EmyN3eJaTH5UNJMQ5RVO8GWndNtSgrS24yBrpiOnVMifgA6V8DQSLDlC8yGrI#O9qqSRrNJ" +
		"g#AP6gB#PQn546NaGbc6qWzNqKlLSpJebNZAKbKQN8i8CcpdIHcfSbYz5Egt5Z2M4Rk93k8" +
		"0u328uGIR7KDDdHki1nAZY454E151HB9X4MsKZjbAVuIrdnriZoL6Qlq3z4ThFfv5D#qO8a" +
		"2thzTjoSnl8MqSArirDzPbZIdq4pINQ1adccsBjMQ1jYjOC8wXry1OqrEkn#PjpDHs3cEdQ" +
		"7ys$LJQ1scJTCxBVVHjOtkQpikVo22tWJPBjs#cdqqKwVfhnCw#vUN8rRQSg62$JjeysYxQ" +
		"AgAGu7Dtr91h9#RHTn9rFcBL4$d4PA9QSs749EqNQzj2r5hc5sFnrrZNbVuwxt7GQcdVvVP" +
		"5P9$5x#hB$2qnWstr3Xr$lwx7MjeEQPjlwxEnX$X7j2rspuiuIEpLzVQ#vsfqwbXRBDnXRR" +
		"a7ZQDMpfR7TakVRcr3BLoaopeCNN#8nSg#vkOxNqUWnG$Mbk#KOUvbvx#BQUpnCRVLq3$vI" +
		"xgKPIc$oszo5BQV757bJ$AZ$23VotToI0ugvbjLVgDLNyhNBB$ozFg2#5nvdn6xPATiedrF" +
		"jidRjAyGBn7FoREoIPwHfsMZR92dPBqyAJlaNTLldOxK9e$Bg$A2R9RdvKN5FEePvH5Lxf1" +
		"tM6wJxVAoR96tv4rvGxRAwyBTBP$QvsFgjTql##HZ#TN3$wBAmroJlvNt9uiPl943U8iu2F" +
		"0cyUFDv230sydme9RtIHtllNfgpLkCPmI$3nq4#6Ld71UvZ3UHoEFzqKXz8$Nvz0le5v8le" +
		"csYhebyDgs9B0l6Q#HmR1Cbx5D2RGEHJjv41hb4nYbbUodvJFgLv2hfLx3T5z8K$FX5PoYa" +
		"qa#bhR8WWN4IQ9DwGJB7RQQscUELCKuPRGlhAVJ74LF$0LrVIoe=");

	static final Action RETURN6 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 6];
		}
	};

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
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

	// turn off automated error recovery
	@Override
	protected void recoverFromError(Symbol token, TokenStream in) throws java.io.IOException, Exception {
		super.recoverFromError(new Symbol(0), in);
	}

	private final Action[] actions;

	public Parser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			RETURN6,	// [0] Module = MODULE ID LCURLY Imports Declarations RCURLY; returns 'RCURLY' although none is marked
			RETURN2,	// [1] Imports = Import Imports; returns 'Imports' although none is marked
			Action.NONE,  	// [2] Imports = 
			RETURN3,	// [3] Import = IMPORT ID SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN2,	// [4] Declarations = Declaration Declarations; returns 'Declarations' although none is marked
			Action.NONE,  	// [5] Declarations = 
			Action.RETURN,	// [6] Declaration = FunctionDeclaration
			Action.RETURN,	// [7] Declaration = FieldDeclaration
			Action.RETURN,	// [8] Declaration = TypeDeclaration
			RETURN9,	// [9] FunctionDeclaration = Accessibility TypeName ID LPAREN ParamList RPAREN LCURLY Statements RCURLY; returns 'RCURLY' although none is marked
			RETURN4,	// [10] FieldDeclaration = Accessibility TypeName ID SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN6,	// [11] TypeDeclaration = Accessibility TYPE ID EQL STRING_LITERAL SEMICOLON; returns 'SEMICOLON' although none is marked
			Action.RETURN,	// [12] Accessibility = PUBLIC
			Action.NONE,  	// [13] Accessibility = 
			RETURN2,	// [14] Statements = Statement Statements; returns 'Statements' although none is marked
			Action.NONE,  	// [15] Statements = 
			Action.RETURN,	// [16] Statement = VarDeclaration
			Action.RETURN,	// [17] Statement = BlockStatements
			Action.RETURN,	// [18] Statement = IfStatement
			Action.RETURN,	// [19] Statement = WhileStatement
			Action.RETURN,	// [20] Statement = BreakStatement
			Action.RETURN,	// [21] Statement = ReturnStatement
			Action.RETURN,	// [22] Statement = ExpressionStatement
			RETURN3,	// [23] VarDeclaration = TypeName ID SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN3,	// [24] BlockStatements = LCURLY Statements RCURLY; returns 'RCURLY' although none is marked
			RETURN5,	// [25] IfStatement = IF LPAREN Expression RPAREN OptionalElse; returns 'OptionalElse' although none is marked
			RETURN2,	// [26] OptionalElse = ELSE Statement; returns 'Statement' although none is marked
			Action.NONE,  	// [27] OptionalElse = 
			RETURN5,	// [28] WhileStatement = WHILE LPAREN Expression RPAREN Statement; returns 'Statement' although none is marked
			RETURN2,	// [29] BreakStatement = BREAK SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN3,	// [30] ReturnStatement = RETURN OptionalExpression SEMICOLON; returns 'SEMICOLON' although none is marked
			RETURN2,	// [31] ExpressionStatement = Expression SEMICOLON; returns 'SEMICOLON' although none is marked
			Action.RETURN,	// [32] OptionalExpression = Expression
			Action.NONE,  	// [33] OptionalExpression = 
			Action.RETURN,	// [34] BaseType = PrimitiveType
			Action.RETURN,	// [35] BaseType = ID
			Action.RETURN,	// [36] PrimitiveType = INT
			Action.RETURN,	// [37] PrimitiveType = BOOLEAN
			Action.RETURN,	// [38] PrimitiveType = VOID
			Action.RETURN,	// [39] TypeName = BaseType
			Action.RETURN,	// [40] TypeName = ArrayType
			RETURN4,	// [41] ArrayType = ID LBRACKET RBRACKET ArraySuffix; returns 'ArraySuffix' although none is marked
			RETURN4,	// [42] ArrayType = PrimitiveType LBRACKET RBRACKET ArraySuffix; returns 'ArraySuffix' although none is marked
			RETURN3,	// [43] ArraySuffix = LBRACKET RBRACKET ArraySuffix; returns 'ArraySuffix' although none is marked
			Action.NONE,  	// [44] ArraySuffix = 
			Action.NONE,  	// [45] ParamList = 
			Action.RETURN,	// [46] Expression = Assignment
			Action.RETURN,	// [47] Expression = RHSExpression
			RETURN3,	// [48] Assignment = LHSExpression EQL Expression; returns 'Expression' although none is marked
			RETURN2,	// [49] LHSExpression = ID ArrayAccess; returns 'ArrayAccess' although none is marked
			RETURN4,	// [50] ArrayAccess = LBRACKET Expression RBRACKET ArrayAccess; returns 'ArrayAccess' although none is marked
			Action.NONE,  	// [51] ArrayAccess = 
			RETURN2,	// [52] RHSExpression = ArithmeticExpression ComparisonExpressionTail; returns 'ComparisonExpressionTail' although none is marked
			RETURN3,	// [53] ComparisonExpressionTail = ComparisonOperator ArithmeticExpression ComparisonExpressionTail; returns 'ComparisonExpressionTail' although none is marked
			Action.NONE,  	// [54] ComparisonExpressionTail = 
			Action.RETURN,	// [55] ComparisonOperator = EQEQ
			Action.RETURN,	// [56] ComparisonOperator = NEQ
			Action.RETURN,	// [57] ComparisonOperator = LT
			Action.RETURN,	// [58] ComparisonOperator = LEQ
			Action.RETURN,	// [59] ComparisonOperator = GT
			Action.RETURN,	// [60] ComparisonOperator = GEQ
			new Action() {	// [61] ArithmeticExpression = Term
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			new Action() {	// [62] ArithmeticExpression = ArithmeticExpression AdditiveOperator Term
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
				}
			},
			Action.RETURN,	// [63] AdditiveOperator = PLUS
			Action.RETURN,	// [64] AdditiveOperator = MINUS
			new Action() {	// [65] Term = Term MultiplicativeOperator Factor
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [66] Term = Factor
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			Action.RETURN,	// [67] MultiplicativeOperator = TIMES
			Action.RETURN,	// [68] MultiplicativeOperator = DIV
			Action.RETURN,	// [69] MultiplicativeOperator = MOD
			RETURN2,	// [70] Factor = MINUS Factor; returns 'Factor' although none is marked
			Action.RETURN,	// [71] Factor = PrimaryExpression
			Action.RETURN,	// [72] PrimaryExpression = LHSExpression
			Action.RETURN,	// [73] PrimaryExpression = FunctionCall
			Action.RETURN,	// [74] PrimaryExpression = ArrayExpression
			Action.RETURN,	// [75] PrimaryExpression = STRING_LITERAL
			Action.RETURN,	// [76] PrimaryExpression = INT_LITERAL
			Action.RETURN,	// [77] PrimaryExpression = TRUE
			Action.RETURN,	// [78] PrimaryExpression = FALSE
			Action.RETURN,	// [79] PrimaryExpression = ParenthesisedExpression
			RETURN4,	// [80] FunctionCall = ID LPAREN ArgumentList RPAREN; returns 'RPAREN' although none is marked
			RETURN2,	// [81] ArgumentList = Expression ArgumentListTail; returns 'ArgumentListTail' although none is marked
			Action.NONE,  	// [82] ArgumentList = 
			RETURN3,	// [83] ArgumentListTail = COMMA Expression ArgumentListTail; returns 'ArgumentListTail' although none is marked
			Action.NONE,  	// [84] ArgumentListTail = 
			RETURN2,	// [85] NonEmptyArgumentList = Expression ArgumentListTail; returns 'ArgumentListTail' although none is marked
			RETURN3,	// [86] ArrayExpression = LBRACKET NonEmptyArgumentList RBRACKET; returns 'RBRACKET' although none is marked
			RETURN3	// [87] ParenthesisedExpression = LPAREN Expression RPAREN; returns 'RPAREN' although none is marked
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
