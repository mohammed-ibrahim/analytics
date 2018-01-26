package org.tools.csv.format;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.tools.csv.format.entity.DescriptiveErrorListener;
import org.tools.csv.format.grammar.SelectLexer;
import org.tools.csv.format.grammar.SelectParser;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CsvFormatter {

    public static void main(String[] args) {
        try {

            run(args);
        } catch (Exception e) {

            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void run(String[] args) throws Exception {
        String str = "";
        str = "select hello,*v1*test,*v2 where 'first_name' = 'last_name' OR (col1 = 33 AND col2 = 55)";

        ANTLRInputStream input = new ANTLRInputStream(str);
        SelectLexer selectLexer = new SelectLexer(input);
        selectLexer.removeErrorListeners();
        selectLexer.addErrorListener(DescriptiveErrorListener.INSTANCE);

        CommonTokenStream tokens = new CommonTokenStream(selectLexer);
        SelectParser selectParser = new SelectParser(tokens);
        //selectParser.setErrorHandler(new BailErrorStrategy());
        selectParser.removeErrorListeners();
        selectParser.addErrorListener(DescriptiveErrorListener.INSTANCE);

        ParseTree tree = selectParser.parse();
        Analyzer analyzer = new Analyzer();
        Object obj = analyzer.visit(tree);
        ObjectMapper jsonMapper = new ObjectMapper();
        System.out.println(jsonMapper.writeValueAsString(obj));
    }
}
