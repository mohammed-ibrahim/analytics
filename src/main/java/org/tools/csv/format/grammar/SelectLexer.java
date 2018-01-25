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
		T__0=1, SELECT=2, WHERE=3, COL_NAME=4, COL_N_WSTAR=5, DIGIT=6, INT=7, 
		FLOAT=8, BOOL=9, SLITERAL=10, OP=11, ESC=12, WORD=13, OPENPAREN=14, CLOSEPAREN=15, 
		OR=16, AND=17, INOP=18, LIKE=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "SELECT", "WHERE", "COL_NAME", "COL_N_WSTAR", "DIGIT", "INT", 
		"FLOAT", "BOOL", "SLITERAL", "OP", "ESC", "WORD", "OPENPAREN", "CLOSEPAREN", 
		"OR", "AND", "INOP", "LIKE", "SGUTS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'select'", "'where'", null, null, null, null, null, null, 
		null, null, null, null, "'('", "')'", "'or'", "'and'", "'in'", "'like'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "SELECT", "WHERE", "COL_NAME", "COL_N_WSTAR", "DIGIT", "INT", 
		"FLOAT", "BOOL", "SLITERAL", "OP", "ESC", "WORD", "OPENPAREN", "CLOSEPAREN", 
		"OR", "AND", "INOP", "LIKE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u009f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\7\5=\n\5\f\5\16\5@\13\5\3\6\3\6\7\6"+
		"D\n\6\f\6\16\6G\13\6\3\7\3\7\3\b\5\bL\n\b\3\b\6\bO\n\b\r\b\16\bP\3\t\5"+
		"\tT\n\t\3\t\6\tW\n\t\r\t\16\tX\3\t\3\t\6\t]\n\t\r\t\16\t^\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\5\nj\n\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\5\fx\n\f\3\r\6\r{\n\r\r\r\16\r|\3\r\3\r\3\16\6\16\u0082"+
		"\n\16\r\16\16\16\u0083\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\7\25\u009b"+
		"\n\25\f\25\16\25\u009e\13\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\2\3\2\n\5\2"+
		"C\\aac|\7\2//\62;C\\aac|\6\2,,C\\aac|\b\2,,//\62;C\\aac|\4\2>>@@\5\2\13"+
		"\f\17\17\"\"\t\2\13\f\17\17\"\"$$*+..??\4\2$$^^\u00ad\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\3+\3\2\2\2\5-\3\2\2\2\7\64\3\2\2\2\t:\3\2\2\2\13A\3\2\2\2\r"+
		"H\3\2\2\2\17K\3\2\2\2\21S\3\2\2\2\23i\3\2\2\2\25k\3\2\2\2\27w\3\2\2\2"+
		"\31z\3\2\2\2\33\u0081\3\2\2\2\35\u0085\3\2\2\2\37\u0087\3\2\2\2!\u0089"+
		"\3\2\2\2#\u008c\3\2\2\2%\u0090\3\2\2\2\'\u0093\3\2\2\2)\u009c\3\2\2\2"+
		"+,\7.\2\2,\4\3\2\2\2-.\7u\2\2./\7g\2\2/\60\7n\2\2\60\61\7g\2\2\61\62\7"+
		"e\2\2\62\63\7v\2\2\63\6\3\2\2\2\64\65\7y\2\2\65\66\7j\2\2\66\67\7g\2\2"+
		"\678\7t\2\289\7g\2\29\b\3\2\2\2:>\t\2\2\2;=\t\3\2\2<;\3\2\2\2=@\3\2\2"+
		"\2><\3\2\2\2>?\3\2\2\2?\n\3\2\2\2@>\3\2\2\2AE\t\4\2\2BD\t\5\2\2CB\3\2"+
		"\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\f\3\2\2\2GE\3\2\2\2HI\4\62;\2I\16"+
		"\3\2\2\2JL\7/\2\2KJ\3\2\2\2KL\3\2\2\2LN\3\2\2\2MO\5\r\7\2NM\3\2\2\2OP"+
		"\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\20\3\2\2\2RT\7/\2\2SR\3\2\2\2ST\3\2\2\2"+
		"TV\3\2\2\2UW\5\r\7\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2"+
		"Z\\\7\60\2\2[]\5\r\7\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\22\3"+
		"\2\2\2`a\7v\2\2ab\7t\2\2bc\7w\2\2cj\7g\2\2de\7h\2\2ef\7c\2\2fg\7n\2\2"+
		"gh\7u\2\2hj\7g\2\2i`\3\2\2\2id\3\2\2\2j\24\3\2\2\2kl\7)\2\2lm\5\33\16"+
		"\2mn\7)\2\2n\26\3\2\2\2ox\t\6\2\2pq\7@\2\2qx\7?\2\2rs\7>\2\2sx\7?\2\2"+
		"tx\7?\2\2uv\7#\2\2vx\7?\2\2wo\3\2\2\2wp\3\2\2\2wr\3\2\2\2wt\3\2\2\2wu"+
		"\3\2\2\2x\30\3\2\2\2y{\t\7\2\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2"+
		"}~\3\2\2\2~\177\b\r\2\2\177\32\3\2\2\2\u0080\u0082\n\b\2\2\u0081\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\34\3\2\2\2\u0085\u0086\7*\2\2\u0086\36\3\2\2\2\u0087\u0088\7+\2\2\u0088"+
		" \3\2\2\2\u0089\u008a\7q\2\2\u008a\u008b\7t\2\2\u008b\"\3\2\2\2\u008c"+
		"\u008d\7c\2\2\u008d\u008e\7p\2\2\u008e\u008f\7f\2\2\u008f$\3\2\2\2\u0090"+
		"\u0091\7k\2\2\u0091\u0092\7p\2\2\u0092&\3\2\2\2\u0093\u0094\7n\2\2\u0094"+
		"\u0095\7k\2\2\u0095\u0096\7m\2\2\u0096\u0097\7g\2\2\u0097(\3\2\2\2\u0098"+
		"\u009b\5\31\r\2\u0099\u009b\n\t\2\2\u009a\u0098\3\2\2\2\u009a\u0099\3"+
		"\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"*\3\2\2\2\u009e\u009c\3\2\2\2\20\2>EKPSX^iw|\u0083\u009a\u009c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}