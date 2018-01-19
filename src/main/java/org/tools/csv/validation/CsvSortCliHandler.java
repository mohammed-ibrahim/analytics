package org.tools.csv.validation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.tools.csv.entity.CsvSortSettings;
import org.tools.csv.utils.Utility;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CsvSortCliHandler {

    private Path inputFilePath;

    private Path outputFilePath;

    private CsvSortSettings csvSortSettings;

    private Boolean deleteSourceFile = null;

    private Path tempDumpDirectory = null;

    @AllArgsConstructor
    private class OptionDetails {

        private String fullConfigName;

        private String shortConfigName;

        private String desc;

        private Boolean hasArg;

        private Boolean required;

        public Option getOption() {
            Option opt = new Option(shortConfigName, fullConfigName, hasArg, desc);
            opt.setRequired(required);

            return opt;
        }

        public boolean isPresent(CommandLine cli) {
            return cli.hasOption(this.fullConfigName);
        }

        public String getOptionValue(CommandLine cli) {
            return cli.getOptionValue(this.fullConfigName);
        }
    }

    public void validate(String args[]) {
        Options options = new Options();

        OptionDetails io = new OptionDetails("input", "i", "location of input file", true, true);
        OptionDetails oo = new OptionDetails("output", "o", "location of output file", true, true);
        OptionDetails cms = new OptionDetails("columns", "c", "comma seperated column-names or column-indexes", true, true);
        OptionDetails sf = new OptionDetails("save-intermediate-files", "s", "whether to save intermediate files", false, false);
        OptionDetails dd = new OptionDetails("dump-directory", "d", "directory where to dump intermeidate files.", true, false);

        options.addOption(io.getOption());
        options.addOption(oo.getOption());
        options.addOption(cms.getOption());
        options.addOption(sf.getOption());
        options.addOption(dd.getOption());

        GnuParser parser = new GnuParser();
        CommandLine cli = null;

        try {
            cli = parser.parse(options, args);
        } catch (Exception e) {
            System.out.println("Invalid option");
            displayHelp(options);
        }

        if (io.isPresent(cli)) {
            this.inputFilePath = Paths.get(io.getOptionValue(cli));
        }

        if (oo.isPresent(cli)) {
            this.outputFilePath = Paths.get(oo.getOptionValue(cli));
        }

        if (cms.isPresent(cli)) {
            String csvCols = cms.getOptionValue(cli);
            this.csvSortSettings = Utility.getCsvSortSettings(inputFilePath, csvCols);
        }

        if (sf.isPresent(cli)) {
            this.deleteSourceFile = false;
        } else {
            this.deleteSourceFile = true;
        }

        if (dd.isPresent(cli)) {
            this.tempDumpDirectory = Paths.get(dd.getOptionValue(cli));
        }
    }

    private void displayHelp(Options options) {

        HelpFormatter formater = new HelpFormatter();
        formater.printHelp("Usage", options);

        System.exit(1);
    }
}
