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
		"SLITERAL", "WS", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
		"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", 
		"Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'where'", "','", null, null, null, null, null, "'>'", 
		"'>='", "'<'", "'<='", "'='", "'!='", "'is'", "'('", "')'"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\27\u00f7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\3\23\5\23\u009e\n\23\3\23\6\23\u00a1\n\23\r\23\16\23\u00a2\3"+
		"\23\3\23\6\23\u00a7\n\23\r\23\16\23\u00a8\5\23\u00ab\n\23\3\24\3\24\7"+
		"\24\u00af\n\24\f\24\16\24\u00b2\13\24\3\25\3\25\7\25\u00b6\n\25\f\25\16"+
		"\25\u00b9\13\25\3\25\3\25\3\26\6\26\u00be\n\26\r\26\16\26\u00bf\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3"+
		"\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\2\2\61"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2"+
		"A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2\3\2!\3\2\62;\6\2,,C\\"+
		"aac|\7\2,,\62;C\\aac|\3\2))\5\2\13\f\16\17\"\"\4\2CCcc\4\2DDdd\4\2EEe"+
		"e\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2"+
		"NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4"+
		"\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\u00e3\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3a\3\2\2\2\5h\3\2\2\2\7n\3\2\2\2\tp\3"+
		"\2\2\2\13t\3\2\2\2\rw\3\2\2\2\17{\3\2\2\2\21\u0080\3\2\2\2\23\u0086\3"+
		"\2\2\2\25\u0088\3\2\2\2\27\u008b\3\2\2\2\31\u008d\3\2\2\2\33\u0090\3\2"+
		"\2\2\35\u0092\3\2\2\2\37\u0095\3\2\2\2!\u0098\3\2\2\2#\u009a\3\2\2\2%"+
		"\u009d\3\2\2\2\'\u00ac\3\2\2\2)\u00b3\3\2\2\2+\u00bd\3\2\2\2-\u00c3\3"+
		"\2\2\2/\u00c5\3\2\2\2\61\u00c7\3\2\2\2\63\u00c9\3\2\2\2\65\u00cb\3\2\2"+
		"\2\67\u00cd\3\2\2\29\u00cf\3\2\2\2;\u00d1\3\2\2\2=\u00d3\3\2\2\2?\u00d5"+
		"\3\2\2\2A\u00d7\3\2\2\2C\u00d9\3\2\2\2E\u00db\3\2\2\2G\u00dd\3\2\2\2I"+
		"\u00df\3\2\2\2K\u00e1\3\2\2\2M\u00e3\3\2\2\2O\u00e5\3\2\2\2Q\u00e7\3\2"+
		"\2\2S\u00e9\3\2\2\2U\u00eb\3\2\2\2W\u00ed\3\2\2\2Y\u00ef\3\2\2\2[\u00f1"+
		"\3\2\2\2]\u00f3\3\2\2\2_\u00f5\3\2\2\2ab\7u\2\2bc\7g\2\2cd\7n\2\2de\7"+
		"g\2\2ef\7e\2\2fg\7v\2\2g\4\3\2\2\2hi\7y\2\2ij\7j\2\2jk\7g\2\2kl\7t\2\2"+
		"lm\7g\2\2m\6\3\2\2\2no\7.\2\2o\b\3\2\2\2pq\5-\27\2qr\5G$\2rs\5\63\32\2"+
		"s\n\3\2\2\2tu\5I%\2uv\5O(\2v\f\3\2\2\2wx\5G$\2xy\5I%\2yz\5S*\2z\16\3\2"+
		"\2\2{|\5S*\2|}\5O(\2}~\5U+\2~\177\5\65\33\2\177\20\3\2\2\2\u0080\u0081"+
		"\5\67\34\2\u0081\u0082\5-\27\2\u0082\u0083\5C\"\2\u0083\u0084\5Q)\2\u0084"+
		"\u0085\5\65\33\2\u0085\22\3\2\2\2\u0086\u0087\7@\2\2\u0087\24\3\2\2\2"+
		"\u0088\u0089\7@\2\2\u0089\u008a\7?\2\2\u008a\26\3\2\2\2\u008b\u008c\7"+
		">\2\2\u008c\30\3\2\2\2\u008d\u008e\7>\2\2\u008e\u008f\7?\2\2\u008f\32"+
		"\3\2\2\2\u0090\u0091\7?\2\2\u0091\34\3\2\2\2\u0092\u0093\7#\2\2\u0093"+
		"\u0094\7?\2\2\u0094\36\3\2\2\2\u0095\u0096\7k\2\2\u0096\u0097\7u\2\2\u0097"+
		" \3\2\2\2\u0098\u0099\7*\2\2\u0099\"\3\2\2\2\u009a\u009b\7+\2\2\u009b"+
		"$\3\2\2\2\u009c\u009e\7/\2\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u00a0\3\2\2\2\u009f\u00a1\t\2\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00aa\3\2\2\2\u00a4"+
		"\u00a6\7\60\2\2\u00a5\u00a7\t\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00a8\3"+
		"\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa"+
		"\u00a4\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab&\3\2\2\2\u00ac\u00b0\t\3\2\2"+
		"\u00ad\u00af\t\4\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1(\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3"+
		"\u00b7\7)\2\2\u00b4\u00b6\n\5\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bb\7)\2\2\u00bb*\3\2\2\2\u00bc\u00be\t\6\2\2\u00bd"+
		"\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\b\26\2\2\u00c2,\3\2\2\2\u00c3\u00c4"+
		"\t\7\2\2\u00c4.\3\2\2\2\u00c5\u00c6\t\b\2\2\u00c6\60\3\2\2\2\u00c7\u00c8"+
		"\t\t\2\2\u00c8\62\3\2\2\2\u00c9\u00ca\t\n\2\2\u00ca\64\3\2\2\2\u00cb\u00cc"+
		"\t\13\2\2\u00cc\66\3\2\2\2\u00cd\u00ce\t\f\2\2\u00ce8\3\2\2\2\u00cf\u00d0"+
		"\t\r\2\2\u00d0:\3\2\2\2\u00d1\u00d2\t\16\2\2\u00d2<\3\2\2\2\u00d3\u00d4"+
		"\t\17\2\2\u00d4>\3\2\2\2\u00d5\u00d6\t\20\2\2\u00d6@\3\2\2\2\u00d7\u00d8"+
		"\t\21\2\2\u00d8B\3\2\2\2\u00d9\u00da\t\22\2\2\u00daD\3\2\2\2\u00db\u00dc"+
		"\t\23\2\2\u00dcF\3\2\2\2\u00dd\u00de\t\24\2\2\u00deH\3\2\2\2\u00df\u00e0"+
		"\t\25\2\2\u00e0J\3\2\2\2\u00e1\u00e2\t\26\2\2\u00e2L\3\2\2\2\u00e3\u00e4"+
		"\t\27\2\2\u00e4N\3\2\2\2\u00e5\u00e6\t\30\2\2\u00e6P\3\2\2\2\u00e7\u00e8"+
		"\t\31\2\2\u00e8R\3\2\2\2\u00e9\u00ea\t\32\2\2\u00eaT\3\2\2\2\u00eb\u00ec"+
		"\t\33\2\2\u00ecV\3\2\2\2\u00ed\u00ee\t\34\2\2\u00eeX\3\2\2\2\u00ef\u00f0"+
		"\t\35\2\2\u00f0Z\3\2\2\2\u00f1\u00f2\t\36\2\2\u00f2\\\3\2\2\2\u00f3\u00f4"+
		"\t\37\2\2\u00f4^\3\2\2\2\u00f5\u00f6\t \2\2\u00f6`\3\2\2\2\n\2\u009d\u00a2"+
		"\u00a8\u00aa\u00b0\u00b7\u00bf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}