# Csv Analytics
Process large csv files
- Sort csv files upto ~1tb on multiple columns. (In-progress)
- Group csv contents. (pending)
  - grouping functions max, average, sum

# Generate test csv file
`python generate_csv.py test_generated.csv 5 100`

Above command generates file output.csv with 5 columns and which would size near to 100mb

# Build the jar
`gradle shadowJar`

# Sort a csv file ~100Mb
`java -cp build/libs/csort.jar org.tools.csv.CsvBlockSorter <input_csv_file_name> <output_csv_file_name> col1,col2,col3`

### e.g.
`java -cp build/libs/csort.jar org.tools.csv.CsvBlockSorter ./test_generated.csv ./sorted.csv 3`

above command sorts the csv test_generated.csv on column 3 and stores the result in sorted.csv

### e.g.
`java -cp build/libs/csort.jar org.tools.csv.CsvBlockSorter ./test_generated.csv ./sorted.csv 1,3`

above command sorts the csv test_generated.csv on column 1,3 and stores the result in sorted.csv

### e.g.
`java -cp build/libs/csort.jar org.tools.csv.CsvBlockSorter ./test_generated.csv ./sorted.csv 0`

above command sorts the csv test_generated.csv on column 0 (Note: 0th column is the first column) and stores the result in sorted.csv

# Sort a file larger than 100mb (upto: 500gb or even ~1tb)
.. Pending ..
