# Csv Analytics
Process large csv files
- Sort csv files upto ~100gb on multiple columns.
  - Files larger than 100gb also supported, provided sufficient storage space is available, please refer to notes section.

- Group csv contents. (pending)
  - grouping functions max, average, sum

# Generate test csv file
`python generate_csv.py test_generated.csv 5 100`

Above command generates file output.csv with 5 columns and which would size near to 100mb

# Build the jar
`gradle shadowJar`

# Sort a csv file
`java -cp build/libs/csort.jar org.tools.csv.sort.CsvMergeSorter -n <comma_seperated_column_names> -i <input_csv_file_name> -o <output_csv_file_name>`

### e.g.
`java -cp build/libs/csort.jar org.tools.csv.sort.CsvMergeSorter -n employee_name,salary -i ./employee-details.csv -o ./sorted.csv`

above command sorts the csv in ascending order of employee_name and salary and stores the result in sorted.csv file.

### e.g.
`java -cp build/libs/csort.jar org.tools.csv.sort.CsvMergeSorter -c 0,1 -i ./employee-details.csv -o ./sorted.csv`

above command sorts the csv employee-details.csv on column 0th and 1st column and stores the result in sorted.csv


# Note:
- Please ensure that there is free diskspace on target machine at-least thrice the size of file.
  i.e. if the file to sort is of size 1gb there must be atleast 3gb free space on disk.
- Csv without column names can be sorted by using option c.
- When using option c, 0 is first column of csv, 1 is second column of csv and so on..
