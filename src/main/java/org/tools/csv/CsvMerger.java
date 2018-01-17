package org.tools.csv;

import java.io.File;
import java.util.List;

import org.tools.csv.entity.CsvSortSettings;
import org.tools.csv.entity.OperationStatus;

public class CsvMerger {

    private static final int NUM_THREADS = 2;

    private Boolean hasFailed;

    public OperationStatus merge(
            List<File> files,
            String outputFileName,
            CsvSortSettings csvSortSettings,
            Boolean deleteSourceFile) {


        return OperationStatus.success();
    }
}
