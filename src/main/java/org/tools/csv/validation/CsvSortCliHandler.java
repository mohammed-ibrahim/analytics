package org.tools.csv.validation;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.tools.csv.entity.CsvSortSettings;
import org.tools.csv.utils.Utility;

import lombok.Data;

@Data
public class CsvSortCliHandler {

    private Path inputFilePath;

    private Path outputFilePath;

    private CsvSortSettings csvSortSettings;

    //private Boolean deleteSourceFile = null;

    private Path tempDumpDirectory = null;

    private Options options;

    public void validate(String args[]) {
        options = new Options();

        OptionDetails io = new OptionDetails("input", "i", "location of input file", true, true);
        OptionDetails oo = new OptionDetails("output", "o", "location of output file", true, true);
        OptionDetails cis = new OptionDetails("column-indexes", "c", "comma seperated column-indexes, 0 -> first column, 1 -> second columns, 2 -> third column...", true, false);
        OptionDetails cns = new OptionDetails("column-names", "n", "comma seperated column-names, cannot be used with -c option", true, false);
        OptionDetails hcn = new OptionDetails("has-column-names", "m", "whether given input csv has column names? possbile values: y,n,yes,no", true, true);
        //OptionDetails sf = new OptionDetails("save-intermediate-files", "s", "whether to save intermediate files", false, false);
        OptionDetails dd = new OptionDetails("dump-directory", "d", "directory where to dump intermeidate files.", true, false);
        OptionDetails desc = new OptionDetails("descending", "x", "sort in descending order.", false, false);
        OptionDetails help = new OptionDetails("help", "h", "show help.", false, false);

        options.addOption(io.getOption());
        options.addOption(oo.getOption());
        options.addOption(cis.getOption());
        //options.addOption(sf.getOption());
        options.addOption(hcn.getOption());
        options.addOption(dd.getOption());
        options.addOption(cns.getOption());
        options.addOption(help.getOption());
        options.addOption(desc.getOption());

        GnuParser parser = new GnuParser();
        CommandLine cli = null;

        try {
            cli = parser.parse(options, args);
        } catch (Exception e) {

            displayHelpAndExit(e.getMessage());
        }

        if (help.isPresent(cli)) {
            displayHelpAndExit("Usage");
        }

        if (cis.isPresent(cli) && cns.isPresent(cli)) {
            displayHelpAndExit("Both options column-indexes, column-names cannot be used togather");
        }

        if ((!cis.isPresent(cli)) && (!cns.isPresent(cli))) {
            displayHelpAndExit("either -c or -n is mandatory.");
        }

        if (io.isPresent(cli)) {
            this.inputFilePath = Paths.get(io.getOptionValue(cli));
        }

        if (oo.isPresent(cli)) {
            this.outputFilePath = Paths.get(oo.getOptionValue(cli));
        }

        Boolean hasColumnNames = false;
        if (hcn.isPresent(cli)) {
            String value = hcn.getOptionValue(cli);
            if (value != null
                    && value.length() > 0
                    && Arrays.asList('y', 'Y').contains(value.charAt(0))) {

                hasColumnNames = true;
            }
        }

        if (cis.isPresent(cli)) {
            String csvCols = cis.getOptionValue(cli);
            this.csvSortSettings = getCsvSortSettingsForIndexes(csvCols, hasColumnNames);
        }

        if (cns.isPresent(cli)) {
            if (hasColumnNames == false) {
                displayHelpAndExit(hcn.getFullConfigName() + " = y|yes is mandatory for the option: " + cns.getFullConfigName());
            }

            String csvCols = cns.getOptionValue(cli);
            this.csvSortSettings = getCsvSortSettingsForColumnNames(inputFilePath, csvCols, hasColumnNames);
        }

        if (desc.isPresent(cli)) {
            this.csvSortSettings.setIsDescendingOrder(true);
        } else {
            this.csvSortSettings.setIsDescendingOrder(false);
        }

//        if (sf.isPresent(cli)) {
//            this.deleteSourceFile = false;
//        } else {
//            this.deleteSourceFile = true;
//        }

        if (dd.isPresent(cli)) {
            this.tempDumpDirectory = Paths.get(dd.getOptionValue(cli));
        }
    }

    private void displayHelpAndExit(String message) {

        HelpFormatter formater = new HelpFormatter();
        formater.printHelp(message, options);

        System.exit(1);
    }

    private CsvSortSettings getCsvSortSettingsForIndexes(String arg, boolean hasColumnNames) {
        if (arg == null || arg.trim().isEmpty()) {
            displayHelpAndExit("Invalid argument given for column-indexes");
        }

        List<Integer> columnIndexes = new ArrayList<Integer>();

        for (String columnIndex : arg.split(",")) {

            if (Utility.isNumeric(columnIndex)) {
                int intValue = (int)Double.parseDouble(columnIndex);
                columnIndexes.add(new Integer(intValue));
            } else {

                displayHelpAndExit("Column-names must be supplied with integers");
            }
        }

        CsvSortSettings csvSortSettings = new CsvSortSettings();
        csvSortSettings.setHasColumnNames(hasColumnNames);
        csvSortSettings.setSortColumnOrder(columnIndexes);
        return csvSortSettings;
    }

    private CsvSortSettings getCsvSortSettingsForColumnNames(
            Path inputFilePath,
            String columnNamesInArgument,
            boolean hasColumnNames) {

        CsvSortSettings csvSortSettings = new CsvSortSettings();
        csvSortSettings.setHasColumnNames(hasColumnNames);

        List<String> columnsInCsv = Arrays.asList(Utility.getColumnNamesOfCsv(inputFilePath));
        List<Integer> successfullyMatchedColumnsFromArgToCsv = new ArrayList<Integer>();
        List<String> columnsNotFoundInInputCsv = new ArrayList<String>();

        for (String columnNameInArgument : columnNamesInArgument.split(",")) {
            Integer indexOfColumnInInputCsv = columnsInCsv.indexOf(columnNameInArgument);

            if (indexOfColumnInInputCsv == -1) {
                columnsNotFoundInInputCsv.add(columnNameInArgument);
            } else {
                successfullyMatchedColumnsFromArgToCsv.add(indexOfColumnInInputCsv);
            }
        }

        if (columnsNotFoundInInputCsv.size() > 0) {
            displayHelpAndExit("Following columns doesn't exist in given csv file: " + columnsNotFoundInInputCsv.toString());
        }

        csvSortSettings.setSortColumnOrder(successfullyMatchedColumnsFromArgToCsv);
        return csvSortSettings;
    }
}
