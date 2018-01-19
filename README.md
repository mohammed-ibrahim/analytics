# Csv Analytics
Process large csv files
- Sort csv files upto ~1tb on multiple columns.

- Group csv contents. (pending)
  - grouping functions max, average, sum

# Generate test csv file
`python generate_csv.py test_generated.csv 5 100`

Above command generates file output.csv with 5 columns and which would size near to 100mb

# Build the jar
`gradle shadowJar`

# Sort a csv file
`java -cp build/libs/csort.jar org.tools.csv.sort.CsvMergeSorter <input_csv_file_name> <output_csv_file_name> col1,col2,col3`

### e.g.
`java -cp build/libs/csort.jar org.tools.csv.sort.CsvMergeSorter ./test_generated.csv ./sorted.csv 3`

above command sorts the csv test_generated.csv on column 3 and stores the result in sorted.csv

### e.g.
`java -cp build/libs/csort.jar org.tools.csv.sort.CsvMergeSorter ./test_generated.csv ./sorted.csv 1,3`

above command sorts the csv test_generated.csv on column 1,3 and stores the result in sorted.csv

### e.g.
`java -cp build/libs/csort.jar org.tools.csv.sort.CsvMergeSorter ./test_generated.csv ./sorted.csv 0`

above command sorts the csv test_generated.csv on column 0 (Note: 0th column is the first column) and stores the result in sorted.csv

# Note:
Please ensure that there is free diskspace on target machine at-least thrice the size of file.
i.e. if the file to sort is of size 1gb there must be atleast 3gb free space on disk.
