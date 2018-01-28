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
		T__0=1, T__1=2, T__2=3, AND=4, OR=5, NOT=6, TRUE=7, FALSE=8, LIKE=9, IN=10, 
		GT=11, GE=12, LT=13, LE=14, EQ=15, NE=16, IS=17, LPAREN=18, RPAREN=19, 
		DECIMAL=20, IDENTIFIER=21, SLITERAL=22, WS=23;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "AND", "OR", "NOT", "TRUE", "FALSE", "LIKE", "IN", 
		"GT", "GE", "LT", "LE", "EQ", "NE", "IS", "LPAREN", "RPAREN", "DECIMAL", 
		"IDENTIFIER", "SLITERAL", "WS", "A", "B", "C", "D", "E", "F", "G", "H", 
		"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", 
		"W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'where'", "','", null, null, null, null, null, null, 
		null, "'>'", "'>='", "'<'", "'<='", "'='", "'!='", "'is'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "AND", "OR", "NOT", "TRUE", "FALSE", "LIKE", "IN", 
		"GT", "GE", "LT", "LE", "EQ", "NE", "IS", "LPAREN", "RPAREN", "DECIMAL", 
		"IDENTIFIER", "SLITERAL", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\31\u0103\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\5\25\u00aa\n\25\3\25\6\25\u00ad\n\25\r\25\16\25\u00ae\3\25\3\25\6\25"+
		"\u00b3\n\25\r\25\16\25\u00b4\5\25\u00b7\n\25\3\26\3\26\7\26\u00bb\n\26"+
		"\f\26\16\26\u00be\13\26\3\27\3\27\7\27\u00c2\n\27\f\27\16\27\u00c5\13"+
		"\27\3\27\3\27\3\30\6\30\u00ca\n\30\r\30\16\30\u00cb\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!"+
		"\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3"+
		",\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\2\2\63\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2"+
		"G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2\3\2!\3\2\62;\6\2,,C\\aa"+
		"c|\7\2,,\62;C\\aac|\3\2))\5\2\13\f\16\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4"+
		"\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNn"+
		"n\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2"+
		"WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\u00ef\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3e\3\2\2\2\5l\3\2"+
		"\2\2\7r\3\2\2\2\tt\3\2\2\2\13x\3\2\2\2\r{\3\2\2\2\17\177\3\2\2\2\21\u0084"+
		"\3\2\2\2\23\u008a\3\2\2\2\25\u008f\3\2\2\2\27\u0092\3\2\2\2\31\u0094\3"+
		"\2\2\2\33\u0097\3\2\2\2\35\u0099\3\2\2\2\37\u009c\3\2\2\2!\u009e\3\2\2"+
		"\2#\u00a1\3\2\2\2%\u00a4\3\2\2\2\'\u00a6\3\2\2\2)\u00a9\3\2\2\2+\u00b8"+
		"\3\2\2\2-\u00bf\3\2\2\2/\u00c9\3\2\2\2\61\u00cf\3\2\2\2\63\u00d1\3\2\2"+
		"\2\65\u00d3\3\2\2\2\67\u00d5\3\2\2\29\u00d7\3\2\2\2;\u00d9\3\2\2\2=\u00db"+
		"\3\2\2\2?\u00dd\3\2\2\2A\u00df\3\2\2\2C\u00e1\3\2\2\2E\u00e3\3\2\2\2G"+
		"\u00e5\3\2\2\2I\u00e7\3\2\2\2K\u00e9\3\2\2\2M\u00eb\3\2\2\2O\u00ed\3\2"+
		"\2\2Q\u00ef\3\2\2\2S\u00f1\3\2\2\2U\u00f3\3\2\2\2W\u00f5\3\2\2\2Y\u00f7"+
		"\3\2\2\2[\u00f9\3\2\2\2]\u00fb\3\2\2\2_\u00fd\3\2\2\2a\u00ff\3\2\2\2c"+
		"\u0101\3\2\2\2ef\7u\2\2fg\7g\2\2gh\7n\2\2hi\7g\2\2ij\7e\2\2jk\7v\2\2k"+
		"\4\3\2\2\2lm\7y\2\2mn\7j\2\2no\7g\2\2op\7t\2\2pq\7g\2\2q\6\3\2\2\2rs\7"+
		".\2\2s\b\3\2\2\2tu\5\61\31\2uv\5K&\2vw\5\67\34\2w\n\3\2\2\2xy\5M\'\2y"+
		"z\5S*\2z\f\3\2\2\2{|\5K&\2|}\5M\'\2}~\5W,\2~\16\3\2\2\2\177\u0080\5W,"+
		"\2\u0080\u0081\5S*\2\u0081\u0082\5Y-\2\u0082\u0083\59\35\2\u0083\20\3"+
		"\2\2\2\u0084\u0085\5;\36\2\u0085\u0086\5\61\31\2\u0086\u0087\5G$\2\u0087"+
		"\u0088\5U+\2\u0088\u0089\59\35\2\u0089\22\3\2\2\2\u008a\u008b\5G$\2\u008b"+
		"\u008c\5A!\2\u008c\u008d\5E#\2\u008d\u008e\59\35\2\u008e\24\3\2\2\2\u008f"+
		"\u0090\5A!\2\u0090\u0091\5K&\2\u0091\26\3\2\2\2\u0092\u0093\7@\2\2\u0093"+
		"\30\3\2\2\2\u0094\u0095\7@\2\2\u0095\u0096\7?\2\2\u0096\32\3\2\2\2\u0097"+
		"\u0098\7>\2\2\u0098\34\3\2\2\2\u0099\u009a\7>\2\2\u009a\u009b\7?\2\2\u009b"+
		"\36\3\2\2\2\u009c\u009d\7?\2\2\u009d \3\2\2\2\u009e\u009f\7#\2\2\u009f"+
		"\u00a0\7?\2\2\u00a0\"\3\2\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7u\2\2\u00a3"+
		"$\3\2\2\2\u00a4\u00a5\7*\2\2\u00a5&\3\2\2\2\u00a6\u00a7\7+\2\2\u00a7("+
		"\3\2\2\2\u00a8\u00aa\7/\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ac\3\2\2\2\u00ab\u00ad\t\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b6\3\2\2\2\u00b0"+
		"\u00b2\7\60\2\2\u00b1\u00b3\t\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3"+
		"\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6"+
		"\u00b0\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7*\3\2\2\2\u00b8\u00bc\t\3\2\2"+
		"\u00b9\u00bb\t\4\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd,\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c3\7)\2\2\u00c0\u00c2\n\5\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c5\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c6\u00c7\7)\2\2\u00c7.\3\2\2\2\u00c8\u00ca\t\6\2\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b\30\2\2\u00ce\60\3\2\2\2\u00cf\u00d0"+
		"\t\7\2\2\u00d0\62\3\2\2\2\u00d1\u00d2\t\b\2\2\u00d2\64\3\2\2\2\u00d3\u00d4"+
		"\t\t\2\2\u00d4\66\3\2\2\2\u00d5\u00d6\t\n\2\2\u00d68\3\2\2\2\u00d7\u00d8"+
		"\t\13\2\2\u00d8:\3\2\2\2\u00d9\u00da\t\f\2\2\u00da<\3\2\2\2\u00db\u00dc"+
		"\t\r\2\2\u00dc>\3\2\2\2\u00dd\u00de\t\16\2\2\u00de@\3\2\2\2\u00df\u00e0"+
		"\t\17\2\2\u00e0B\3\2\2\2\u00e1\u00e2\t\20\2\2\u00e2D\3\2\2\2\u00e3\u00e4"+
		"\t\21\2\2\u00e4F\3\2\2\2\u00e5\u00e6\t\22\2\2\u00e6H\3\2\2\2\u00e7\u00e8"+
		"\t\23\2\2\u00e8J\3\2\2\2\u00e9\u00ea\t\24\2\2\u00eaL\3\2\2\2\u00eb\u00ec"+
		"\t\25\2\2\u00ecN\3\2\2\2\u00ed\u00ee\t\26\2\2\u00eeP\3\2\2\2\u00ef\u00f0"+
		"\t\27\2\2\u00f0R\3\2\2\2\u00f1\u00f2\t\30\2\2\u00f2T\3\2\2\2\u00f3\u00f4"+
		"\t\31\2\2\u00f4V\3\2\2\2\u00f5\u00f6\t\32\2\2\u00f6X\3\2\2\2\u00f7\u00f8"+
		"\t\33\2\2\u00f8Z\3\2\2\2\u00f9\u00fa\t\34\2\2\u00fa\\\3\2\2\2\u00fb\u00fc"+
		"\t\35\2\2\u00fc^\3\2\2\2\u00fd\u00fe\t\36\2\2\u00fe`\3\2\2\2\u00ff\u0100"+
		"\t\37\2\2\u0100b\3\2\2\2\u0101\u0102\t \2\2\u0102d\3\2\2\2\n\2\u00a9\u00ae"+
		"\u00b4\u00b6\u00bc\u00c3\u00cb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}