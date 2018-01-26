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
		AND=1, OR=2, NOT=3, TRUE=4, FALSE=5, GT=6, GE=7, LT=8, LE=9, EQ=10, LPAREN=11, 
		RPAREN=12, DECIMAL=13, IDENTIFIER=14, SLITERAL=15, WS=16;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", "LPAREN", 
		"RPAREN", "DECIMAL", "IDENTIFIER", "SLITERAL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'AND'", "'OR'", "'NOT'", "'TRUE'", "'FALSE'", "'>'", "'>='", "'<'", 
		"'<='", "'='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", 
		"LPAREN", "RPAREN", "DECIMAL", "IDENTIFIER", "SLITERAL", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\22o\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\16\5\16K\n\16\3\16\6\16N\n\16\r\16\16\16O\3\16\3\16\6\16T\n\16"+
		"\r\16\16\16U\5\16X\n\16\3\17\3\17\7\17\\\n\17\f\17\16\17_\13\17\3\20\3"+
		"\20\6\20c\n\20\r\20\16\20d\3\20\3\20\3\21\6\21j\n\21\r\21\16\21k\3\21"+
		"\3\21\2\2\22\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22\3\2\7\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\t\2\13"+
		"\f\17\17\"\"$$*+..??\5\2\13\f\16\17\"\"u\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\3#\3\2\2\2\5\'\3\2\2\2\7*\3\2\2\2\t."+
		"\3\2\2\2\13\63\3\2\2\2\r9\3\2\2\2\17;\3\2\2\2\21>\3\2\2\2\23@\3\2\2\2"+
		"\25C\3\2\2\2\27E\3\2\2\2\31G\3\2\2\2\33J\3\2\2\2\35Y\3\2\2\2\37`\3\2\2"+
		"\2!i\3\2\2\2#$\7C\2\2$%\7P\2\2%&\7F\2\2&\4\3\2\2\2\'(\7Q\2\2()\7T\2\2"+
		")\6\3\2\2\2*+\7P\2\2+,\7Q\2\2,-\7V\2\2-\b\3\2\2\2./\7V\2\2/\60\7T\2\2"+
		"\60\61\7W\2\2\61\62\7G\2\2\62\n\3\2\2\2\63\64\7H\2\2\64\65\7C\2\2\65\66"+
		"\7N\2\2\66\67\7U\2\2\678\7G\2\28\f\3\2\2\29:\7@\2\2:\16\3\2\2\2;<\7@\2"+
		"\2<=\7?\2\2=\20\3\2\2\2>?\7>\2\2?\22\3\2\2\2@A\7>\2\2AB\7?\2\2B\24\3\2"+
		"\2\2CD\7?\2\2D\26\3\2\2\2EF\7*\2\2F\30\3\2\2\2GH\7+\2\2H\32\3\2\2\2IK"+
		"\7/\2\2JI\3\2\2\2JK\3\2\2\2KM\3\2\2\2LN\t\2\2\2ML\3\2\2\2NO\3\2\2\2OM"+
		"\3\2\2\2OP\3\2\2\2PW\3\2\2\2QS\7\60\2\2RT\t\2\2\2SR\3\2\2\2TU\3\2\2\2"+
		"US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WQ\3\2\2\2WX\3\2\2\2X\34\3\2\2\2Y]\t\3\2"+
		"\2Z\\\t\4\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\36\3\2\2\2_]\3"+
		"\2\2\2`b\7)\2\2ac\n\5\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3"+
		"\2\2\2fg\7)\2\2g \3\2\2\2hj\t\6\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3"+
		"\2\2\2lm\3\2\2\2mn\b\21\2\2n\"\3\2\2\2\n\2JOUW]dk\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}