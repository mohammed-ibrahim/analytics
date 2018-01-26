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
		LT=11, LE=12, EQ=13, LPAREN=14, RPAREN=15, DECIMAL=16, IDENTIFIER=17, 
		SLITERAL=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", 
		"LT", "LE", "EQ", "LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", "SLITERAL", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'where'", "','", "'AND'", "'OR'", "'NOT'", "'TRUE'", 
		"'FALSE'", "'>'", "'>='", "'<'", "'<='", "'='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", 
		"LT", "LE", "EQ", "LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", "SLITERAL", 
		"WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u0080\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\5\21`\n\21\3\21\6\21c\n\21"+
		"\r\21\16\21d\3\21\3\21\6\21i\n\21\r\21\16\21j\5\21m\n\21\3\22\3\22\7\22"+
		"q\n\22\f\22\16\22t\13\22\3\23\3\23\3\23\3\23\3\24\6\24{\n\24\r\24\16\24"+
		"|\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\6\3\2\62;\6\2,,C\\aac|\7"+
		"\2,,\62;C\\aac|\5\2\13\f\16\17\"\"\u0085\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)"+
		"\3\2\2\2\5\60\3\2\2\2\7\66\3\2\2\2\t8\3\2\2\2\13<\3\2\2\2\r?\3\2\2\2\17"+
		"C\3\2\2\2\21H\3\2\2\2\23N\3\2\2\2\25P\3\2\2\2\27S\3\2\2\2\31U\3\2\2\2"+
		"\33X\3\2\2\2\35Z\3\2\2\2\37\\\3\2\2\2!_\3\2\2\2#n\3\2\2\2%u\3\2\2\2\'"+
		"z\3\2\2\2)*\7u\2\2*+\7g\2\2+,\7n\2\2,-\7g\2\2-.\7e\2\2./\7v\2\2/\4\3\2"+
		"\2\2\60\61\7y\2\2\61\62\7j\2\2\62\63\7g\2\2\63\64\7t\2\2\64\65\7g\2\2"+
		"\65\6\3\2\2\2\66\67\7.\2\2\67\b\3\2\2\289\7C\2\29:\7P\2\2:;\7F\2\2;\n"+
		"\3\2\2\2<=\7Q\2\2=>\7T\2\2>\f\3\2\2\2?@\7P\2\2@A\7Q\2\2AB\7V\2\2B\16\3"+
		"\2\2\2CD\7V\2\2DE\7T\2\2EF\7W\2\2FG\7G\2\2G\20\3\2\2\2HI\7H\2\2IJ\7C\2"+
		"\2JK\7N\2\2KL\7U\2\2LM\7G\2\2M\22\3\2\2\2NO\7@\2\2O\24\3\2\2\2PQ\7@\2"+
		"\2QR\7?\2\2R\26\3\2\2\2ST\7>\2\2T\30\3\2\2\2UV\7>\2\2VW\7?\2\2W\32\3\2"+
		"\2\2XY\7?\2\2Y\34\3\2\2\2Z[\7*\2\2[\36\3\2\2\2\\]\7+\2\2] \3\2\2\2^`\7"+
		"/\2\2_^\3\2\2\2_`\3\2\2\2`b\3\2\2\2ac\t\2\2\2ba\3\2\2\2cd\3\2\2\2db\3"+
		"\2\2\2de\3\2\2\2el\3\2\2\2fh\7\60\2\2gi\t\2\2\2hg\3\2\2\2ij\3\2\2\2jh"+
		"\3\2\2\2jk\3\2\2\2km\3\2\2\2lf\3\2\2\2lm\3\2\2\2m\"\3\2\2\2nr\t\3\2\2"+
		"oq\t\4\2\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s$\3\2\2\2tr\3\2\2\2"+
		"uv\7)\2\2vw\5#\22\2wx\7)\2\2x&\3\2\2\2y{\t\5\2\2zy\3\2\2\2{|\3\2\2\2|"+
		"z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\b\24\2\2\177(\3\2\2\2\t\2_djlr|\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}