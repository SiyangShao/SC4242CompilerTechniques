/* You do not need to change anything up here. */
package lexer;

import frontend.Token;
import javax.print.DocFlavor;import static frontend.Token.Type.*;

%%

%public
%final
%class Lexer
%function nextToken
%type Token
%unicode
%line
%column

%{
	/* These two methods are for the convenience of rules to create toke objects.
	* If you do not want to use them, delete them
	* otherwise add the code in 
	*/
	
	private Token token(Token.Type type) {
        return new Token(type, yyline, yycolumn, yytext());
	}
	
	/* Use this method for rules where you need to process yytext() to get the lexeme of the token.
	 *
	 * Useful for string literals; e.g., the quotes around the literal are part of yytext(),
	 *       but they should not be part of the lexeme. 
	*/
	private Token token(Token.Type type, String text) {
	    return new Token(type, yyline, yycolumn, text);
	}
%}

/* This definition may come in handy. If you wish, you can add more definitions here. */
WhiteSpace = [ ] | \t | \f | \n | \r


%%
/* put in your rules here.    */

"boolean" {return token(BOOLEAN, yytext());}
"break" {return token(BREAK, yytext());}
"else" {return token(ELSE, yytext());}
"false" {return token(FALSE, yytext());}
"if" {return token(IF, yytext());}
"import" {return token(IMPORT, yytext());}
"int" {return token(INT, yytext());}
"module" {return token(MODULE, yytext());}
"public" {return token(PUBLIC, yytext());}
"return" {return token(RETURN, yytext());}
"true" {return token(TRUE, yytext());}
"type" {return token(TYPE, yytext());}
"void" {return token(VOID, yytext());}
"while" {return token(WHILE, yytext());}
{WhiteSpace} {/* ignore whitespace */}
(\"[^\"]*\") {
    var text = yytext();
    return token(STRING_LITERAL, text.substring(1, text.length() - 1));
}

// If the character is not matched by any of the rules above, return null.
. {return null;}



/* You don't need to change anything below this line. */
.							{ throw new Error("unexpected character '" + yytext() + "'"); }
<<EOF>>						{ return token(EOF); }
