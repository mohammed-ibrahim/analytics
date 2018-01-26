// Generated from ./src/main/resources/Select.g4 by ANTLR 4.5.1
package org.tools.csv.format.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SelectLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, AND=4, OR=5, NOT=6, TRUE=7, FALSE=8, GT=9, GE=10, 
		LT=11, LE=12, EQ=13, NE=14, IS=15, LPAREN=16, RPAREN=17, DECIMAL=18, IDENTIFIER=19, 
		SLITERAL=20, WS=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", 
		"LT", "LE", "EQ", "NE", "IS", "LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", 
		"SLITERAL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'where'", "','", "'AND'", "'OR'", "'NOT'", "'TRUE'", 
		"'FALSE'", "'>'", "'>='", "'<'", "'<='", "'='", "'!='", "'is'", "'('", 
		"')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", 
		"LT", "LE", "EQ", "NE", "IS", "LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", 
		"SLITERAL", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SelectLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Select.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\27\u008a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\5\23j\n\23\3\23\6\23m\n\23\r\23\16\23n\3\23\3"+
		"\23\6\23s\n\23\r\23\16\23t\5\23w\n\23\3\24\3\24\7\24{\n\24\f\24\16\24"+
		"~\13\24\3\25\3\25\3\25\3\25\3\26\6\26\u0085\n\26\r\26\16\26\u0086\3\26"+
		"\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3\2\6\3\2\62;\6\2,,C\\aac"+
		"|\7\2,,\62;C\\aac|\5\2\13\f\16\17\"\"\u008f\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\64\3\2\2\2\7:\3\2\2\2\t<\3\2\2\2"+
		"\13@\3\2\2\2\rC\3\2\2\2\17G\3\2\2\2\21L\3\2\2\2\23R\3\2\2\2\25T\3\2\2"+
		"\2\27W\3\2\2\2\31Y\3\2\2\2\33\\\3\2\2\2\35^\3\2\2\2\37a\3\2\2\2!d\3\2"+
		"\2\2#f\3\2\2\2%i\3\2\2\2\'x\3\2\2\2)\177\3\2\2\2+\u0084\3\2\2\2-.\7u\2"+
		"\2./\7g\2\2/\60\7n\2\2\60\61\7g\2\2\61\62\7e\2\2\62\63\7v\2\2\63\4\3\2"+
		"\2\2\64\65\7y\2\2\65\66\7j\2\2\66\67\7g\2\2\678\7t\2\289\7g\2\29\6\3\2"+
		"\2\2:;\7.\2\2;\b\3\2\2\2<=\7C\2\2=>\7P\2\2>?\7F\2\2?\n\3\2\2\2@A\7Q\2"+
		"\2AB\7T\2\2B\f\3\2\2\2CD\7P\2\2DE\7Q\2\2EF\7V\2\2F\16\3\2\2\2GH\7V\2\2"+
		"HI\7T\2\2IJ\7W\2\2JK\7G\2\2K\20\3\2\2\2LM\7H\2\2MN\7C\2\2NO\7N\2\2OP\7"+
		"U\2\2PQ\7G\2\2Q\22\3\2\2\2RS\7@\2\2S\24\3\2\2\2TU\7@\2\2UV\7?\2\2V\26"+
		"\3\2\2\2WX\7>\2\2X\30\3\2\2\2YZ\7>\2\2Z[\7?\2\2[\32\3\2\2\2\\]\7?\2\2"+
		"]\34\3\2\2\2^_\7#\2\2_`\7?\2\2`\36\3\2\2\2ab\7k\2\2bc\7u\2\2c \3\2\2\2"+
		"de\7*\2\2e\"\3\2\2\2fg\7+\2\2g$\3\2\2\2hj\7/\2\2ih\3\2\2\2ij\3\2\2\2j"+
		"l\3\2\2\2km\t\2\2\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2ov\3\2\2\2"+
		"pr\7\60\2\2qs\t\2\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2"+
		"\2vp\3\2\2\2vw\3\2\2\2w&\3\2\2\2x|\t\3\2\2y{\t\4\2\2zy\3\2\2\2{~\3\2\2"+
		"\2|z\3\2\2\2|}\3\2\2\2}(\3\2\2\2~|\3\2\2\2\177\u0080\7)\2\2\u0080\u0081"+
		"\5\'\24\2\u0081\u0082\7)\2\2\u0082*\3\2\2\2\u0083\u0085\t\5\2\2\u0084"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u0088\3\2\2\2\u0088\u0089\b\26\2\2\u0089,\3\2\2\2\t\2intv|"+
		"\u0086\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}