# Csv Analytics
Process large csv files
- Sort csv files upto ~100gb on multiple columns.
  - Files larger than 100gb also supported, provided sufficient storage space is available, please refer to notes section.

- Group csv contents. (pending)
  - grouping functions max, average, sum

## Input sample csv file
![Input Csv File](etc/images/employee-details.png)


# Build the jar
`gradle shadowJar`

## Sort on city,country
`java -cp build/libs/csort.jar org.tools.csv.sort.CsvMergeSorter -n city,country -i employee-details.csv -o city-sorted.csv -m yes -s`

![City,Country Sorted](etc/images/city-country-sorted.png)

### Sort on first_name
`java -cp build/libs/csort.jar org.tools.csv.sort.CsvMergeSorter -n first_name -i employee-details.csv -o first-name-sorted.csv -m yes -s`

![first_name Sorted](etc/images/first-name-sorted.png)

### For help and other options
`java -cp build/libs/csort.jar org.tools.csv.sort.CsvMergeSorter --help`

# Note:
- Please ensure that there is free diskspace on target machine at-least thrice the size of file.
  i.e. if the file to sort is of size 1gb there must be atleast 3gb free space on disk.
- Csv without column names can be sorted by using option c, please provide option `-m no` in such case.
- When using option c, 0 is first column of csv, 1 is second column of csv and so on..
