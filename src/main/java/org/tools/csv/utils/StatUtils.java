package org.tools.csv.utils;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StatUtils {

    public static Long defaultManagableSize = null;

    public static Long getSafeBlockSize() {

        return (getManagableSizeInMb() * Constants.BYTES_IN_A_MB);
    }

    public static Long getManagableSizeInMb() {

        //for first time.
        if (defaultManagableSize == null) {
            String safeManagableSize = System.getenv(Constants.MANAGABLE_SIZE_IN_MB_ENV_VAR);
            if (safeManagableSize != null && (!safeManagableSize.trim().isEmpty())) {

                try {

                    Double dval = Double.parseDouble(safeManagableSize);
                    defaultManagableSize = new Long(safeManagableSize);
                } catch (Exception e) {

                    defaultManagableSize = Constants.DEFAULT_MANAGABLE_SIZE_IN_MB;
                    log.error("The variable: {} is not set with proper integer, hence using default value", Constants.MANAGABLE_SIZE_IN_MB_ENV_VAR);
                }
            } else {

                defaultManagableSize = Constants.DEFAULT_MANAGABLE_SIZE_IN_MB;
            }
        }

        return defaultManagableSize;
    }

    public static void assertFileSizeWithinManagableBlockSize(File file) {
        //margin of 20%
        if (file.length() > ((getManagableSizeInMb().doubleValue() * 1.2) * Constants.BYTES_IN_A_MB)) {
            throw new RuntimeException("Block size greater than managable size.");
        }
    }

    public static Double fileSizeInMb(File file) {
        Double fileSize = new Double(file.length())/new Double(Constants.BYTES_IN_A_MB);
        return fileSize;
    }
}
