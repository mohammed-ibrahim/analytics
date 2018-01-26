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
		T__0=1, T__1=2, AND=3, OR=4, NOT=5, TRUE=6, FALSE=7, GT=8, GE=9, LT=10, 
		LE=11, EQ=12, LPAREN=13, RPAREN=14, DECIMAL=15, IDENTIFIER=16, SLITERAL=17, 
		WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", 
		"LE", "EQ", "LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", "SLITERAL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'where'", "'AND'", "'OR'", "'NOT'", "'TRUE'", "'FALSE'", 
		"'>'", "'>='", "'<'", "'<='", "'='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", 
		"LE", "EQ", "LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", "SLITERAL", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\24\u0080\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\5\20\\\n\20\3\20\6\20_\n\20\r\20\16\20`\3\20\3\20"+
		"\6\20e\n\20\r\20\16\20f\5\20i\n\20\3\21\3\21\7\21m\n\21\f\21\16\21p\13"+
		"\21\3\22\3\22\6\22t\n\22\r\22\16\22u\3\22\3\22\3\23\6\23{\n\23\r\23\16"+
		"\23|\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\7\3\2\62;\5\2C\\aac|\6\2\62"+
		";C\\aac|\t\2\13\f\17\17\"\"$$*+..??\5\2\13\f\16\17\"\"\u0086\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\3\'\3\2\2\2\5.\3\2\2\2\7\64\3\2\2\2\t8\3\2\2\2\13;\3\2\2\2\r?\3\2"+
		"\2\2\17D\3\2\2\2\21J\3\2\2\2\23L\3\2\2\2\25O\3\2\2\2\27Q\3\2\2\2\31T\3"+
		"\2\2\2\33V\3\2\2\2\35X\3\2\2\2\37[\3\2\2\2!j\3\2\2\2#q\3\2\2\2%z\3\2\2"+
		"\2\'(\7u\2\2()\7g\2\2)*\7n\2\2*+\7g\2\2+,\7e\2\2,-\7v\2\2-\4\3\2\2\2."+
		"/\7y\2\2/\60\7j\2\2\60\61\7g\2\2\61\62\7t\2\2\62\63\7g\2\2\63\6\3\2\2"+
		"\2\64\65\7C\2\2\65\66\7P\2\2\66\67\7F\2\2\67\b\3\2\2\289\7Q\2\29:\7T\2"+
		"\2:\n\3\2\2\2;<\7P\2\2<=\7Q\2\2=>\7V\2\2>\f\3\2\2\2?@\7V\2\2@A\7T\2\2"+
		"AB\7W\2\2BC\7G\2\2C\16\3\2\2\2DE\7H\2\2EF\7C\2\2FG\7N\2\2GH\7U\2\2HI\7"+
		"G\2\2I\20\3\2\2\2JK\7@\2\2K\22\3\2\2\2LM\7@\2\2MN\7?\2\2N\24\3\2\2\2O"+
		"P\7>\2\2P\26\3\2\2\2QR\7>\2\2RS\7?\2\2S\30\3\2\2\2TU\7?\2\2U\32\3\2\2"+
		"\2VW\7*\2\2W\34\3\2\2\2XY\7+\2\2Y\36\3\2\2\2Z\\\7/\2\2[Z\3\2\2\2[\\\3"+
		"\2\2\2\\^\3\2\2\2]_\t\2\2\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2ah"+
		"\3\2\2\2bd\7\60\2\2ce\t\2\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2"+
		"gi\3\2\2\2hb\3\2\2\2hi\3\2\2\2i \3\2\2\2jn\t\3\2\2km\t\4\2\2lk\3\2\2\2"+
		"mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\"\3\2\2\2pn\3\2\2\2qs\7)\2\2rt\n\5\2\2"+
		"sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\7)\2\2x$\3\2\2\2"+
		"y{\t\6\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\b\23"+
		"\2\2\177&\3\2\2\2\n\2[`fhnu|\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}