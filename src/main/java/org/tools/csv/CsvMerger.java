package org.tools.csv;

import java.io.File;
import java.util.List;

import org.tools.csv.entity.CsvSortSettings;
import org.tools.csv.entity.OperationStatus;

public class CsvMerger {

    public OperationStatus merge(
            List<File> files,
            String outputFileName,
            CsvSortSettings csvSortSettings,
            Boolean deleteSourceFile) {


        return OperationStatus.success();
    }
}
