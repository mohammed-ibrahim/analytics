package org.tools.csv.validation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import lombok.Data;

@Data
public class CsvFormatterCliHandler {

    private Path inputFilePath;

    private Path outputFilePath;

    private String expression;

    private Options options;

    public void validate(String args[]) {
        options = new Options();

        OptionDetails io = new OptionDetails("input", "i", "location of input file", true, true);
        OptionDetails oo = new OptionDetails("output", "o", "location of output file", true, false);
        OptionDetails exp = new OptionDetails("expr", "e", "sql-like select c1,c2 where c3='soem_value'", true, true);

        GnuParser parser = new GnuParser();
        CommandLine cli = null;

        try {
            cli = parser.parse(options, args);
        } catch (Exception e) {

            displayHelpAndExit(e.getMessage());
        }

        if (io.isPresent(cli)) {
            this.inputFilePath = Paths.get(io.getOptionValue(cli));
        }

        if (oo.isPresent(cli)) {
            this.outputFilePath = Paths.get(oo.getOptionValue(cli));
        }

        if (exp.isPresent(cli)) {
            this.expression = exp.getOptionValue(cli);
        }
    }

    private void displayHelpAndExit(String message) {

        HelpFormatter formater = new HelpFormatter();
        formater.printHelp(message, options);

        System.exit(1);
    }
}
