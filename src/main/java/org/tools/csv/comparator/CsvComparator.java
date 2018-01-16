package org.tools.csv.comparator;

import java.util.Comparator;
import java.util.List;

public class CsvComparator implements Comparator<String[]> {

    private List<Integer> columnOrder = null;

    public CsvComparator(List<Integer> columnOrderItems) {

        this.columnOrder = columnOrderItems;
    }

    @Override
    public int compare(String[] o1, String[] o2) {

        for (Integer columnNumber : this.columnOrder) {

            String originalLhs = cleanString(o1[columnNumber]);
            String originalRhs = cleanString(o2[columnNumber]);

            Double lhs = safeDouble(originalLhs);
            Double rhs = safeDouble(originalRhs);

            //Not a double match
            if (lhs == null && rhs == null) {

                if (originalLhs == null && originalRhs == null) {
                    continue;
                }

                if (originalLhs != null && originalRhs == null) {
                    return -1;
                }

                if (originalLhs == null && originalRhs != null) {
                    return 1;
                }

                int result = originalLhs.toLowerCase().compareTo(originalRhs.toLowerCase());

                if (result != 0) {

                    return result;
                } else {

                    //delete to next row if current comparision is equal.
                    continue;
                }
            }

            if (lhs != null || rhs != null) {
                if (lhs != null && rhs == null) {
                    return -1;
                }

                if (lhs == null && rhs != null) {
                    return 1;
                }

                if (lhs.equals(rhs)) {
                    continue;
                }

                int result = lhs.compareTo(rhs);
                if (result != 0) {

                    return result;
                } else {

                    //delete to next row if current comparision is equal.
                    continue;
                }
            }
        }

        //If all the columns are same then return 0;
        return 0;
    }

    private String cleanString(String input) {
        if (input == null) {
            return null;
        }

        String cleaned = input.trim();
        if (cleaned.isEmpty()) {
            return null;
        }

        return cleaned;
    }

    private Double safeDouble(String item) {

        if (item == null) {
            return null;
        }

        try {

            return Double.parseDouble(item);
        } catch (Exception e) {

            return null;
        }
    }
}
