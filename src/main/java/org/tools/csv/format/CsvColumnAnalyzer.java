package org.tools.csv.format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.tools.csv.utils.Utility;

import lombok.Data;

@Data
public class CsvColumnAnalyzer {

    private List<Integer> columnIndexes;

    public void compile(List<String> inputColumnExpression, List<String> columnNamesInsideCsv) {

        List<String> columnExpressionList = inputColumnExpression
                .stream()
                .filter(i -> !i.isEmpty())
                .collect(Collectors.toList());

        List<Integer> finalColumns = new ArrayList<Integer>();
        columnExpressionList.forEach(expression -> {
            List<Integer> foundColumns = findColumns(expression, columnNamesInsideCsv);

            if (foundColumns != null && foundColumns.size() > 0) {
                finalColumns.addAll(foundColumns);
            }
        });

        if (finalColumns.size() < 1) {
            throw new RuntimeException("No columns found!");
        }

        this.columnIndexes = finalColumns;
        return;
    }

    private List<Integer> findColumns(String expression, List<String> columnNamesInsideCsv) {

        if (expression.contains("*")) {
            List<Integer> matchingColumnIndexes = columnNamesInsideCsv
                    .stream()
                    .filter(columnName -> matches(expression, columnName))
                    .map(i -> columnNamesInsideCsv.indexOf(i))
                    .collect(Collectors.toList());

            if (matchingColumnIndexes.size() < 1) {
                System.out.println("Pattern: " + expression + " did not match any column.");
                return null;
            }

            return matchingColumnIndexes;
        } else {

            if (columnNamesInsideCsv.contains(expression)) {
                return Arrays.asList(columnNamesInsideCsv.indexOf(expression));
            }

            System.out.println("No such column name: " + expression);
            return null;
        }
    }

    private boolean matches(String pattern, String value) {
        String derivedPattern = pattern.replace("*", ".*");
        Pattern compiler = Pattern.compile(derivedPattern);
        Matcher matcher = compiler.matcher(value);

        return matcher.find();
    }
}
