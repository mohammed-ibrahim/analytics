package org.tools.csv.format;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.tools.csv.format.entity.DescriptiveErrorListener;
import org.tools.csv.format.entity.Format;
import org.tools.csv.format.entity.ProcessMetadata;
import org.tools.csv.format.grammar.SelectLexer;
import org.tools.csv.format.grammar.SelectParser;
import org.tools.csv.utils.Utility;
import org.tools.csv.validation.CsvFormatterCliHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CsvFormatter {

    public static void main(String[] args) {
        CsvFormatterCliHandler cliHandler = new CsvFormatterCliHandler();
        cliHandler.validate(args);

        try {
            CsvFormatter csvFormatter = new CsvFormatter();
            Format format = csvFormatter.parseExpression(cliHandler.getExpression());
            CsvColumnAnalyzer csvColumnAnalyzer = new CsvColumnAnalyzer();

            String[] columnNamesArray = Utility.getColumnNamesOfCsv(cliHandler.getInputFilePath());
            List<String> columnNamesList = Arrays.asList(columnNamesArray);
            csvColumnAnalyzer.compile(format.getRawColumns(), columnNamesList);

            ProcessMetadata metadata = new ProcessMetadata()
                    .withReturnColumnIndexes(csvColumnAnalyzer.getColumnIndexes())
                    .withColumnNames(columnNamesList);

            DataProcessor dataProcessor = new DataProcessor();
            dataProcessor.process(
                    cliHandler.getInputFilePath(),
                    cliHandler.getOutputFilePath(),
                    format,
                    metadata);

        } catch (Exception e) {

            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }

    public Format parseExpression(String expression) throws Exception {
        //expression = "select hello,*v1*test,*v2 where 'first_name' = 'last_name' OR (col1 = 33 AND col2 = 55) OR col5 is null";

        ANTLRInputStream input = new ANTLRInputStream(expression);
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
        Format format = (Format)analyzer.visit(tree);
        //ObjectMapper jsonMapper = new ObjectMapper();
        //System.out.println(jsonMapper.writeValueAsString(format));
        return format;
    }
}
