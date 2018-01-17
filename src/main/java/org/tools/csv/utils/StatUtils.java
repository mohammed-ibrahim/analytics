package org.tools.csv.utils;

import java.io.File;

public class StatUtils {

    public static long bytesInMegaByte() {
        return 1000000L;
    }
    
    public static Long getSafeBlockSize() {

        return (100L * bytesInMegaByte());
    }
    
    public static void assertFileSizeWithinManagableBlockSize(File file) {
        if (file.length() > (120 * bytesInMegaByte())) {
            throw new RuntimeException("Block size greater than managable size.");
        }
    }
    
    public static Double fileSizeInMb(File file) {
        Double fileSize = new Double(file.length())/new Double(bytesInMegaByte());
        return fileSize;
    }
}
