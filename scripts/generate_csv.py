import sys
import random
import csv
from random import randint
from random import choice
from string import ascii_uppercase
from string import ascii_lowercase

random_column_data = [
    "string", "int", "double"
]

def get_random_column_data(column_number):
    return {
        "type": random.choice(random_column_data),
        "name": "c" + str(column_number)
    }

def get_all_columns(num_columns):
    columns = list()

    for i in range(num_columns):
        columns.append(get_random_column_data(i+1))

    return columns

def get_headers(columns):
    headers = list()
    for column in columns:
        headers.append(column["name"])

    return headers

def get_next_col(column):
    col_type = column["type"]

    if col_type == "string":
        result = (''.join(choice(ascii_uppercase) for i in range(randint(5, 32))))
        return (result, len(result))

    if col_type == "int":
        result = str(randint(5, 1000000))
        return (result, len(result))

    if col_type == "double":
        result = str(random.uniform(0.3, 999999.99999))
        return (result, len(result))

    print("Unknown column: " + col_type)
    sys.exit(1)

def get_next_row(columns):
    size = 0
    row = list()
    for column in columns:
        (content, content_size) = get_next_col(column)
        size = size + content_size
        row.append(content)

    return (row, size)

def write_csv(file_name, num_columns, num_of_bytes):
    columns = get_all_columns(num_columns)
    total_bytes_written = 0
    rows_written = 0

    with open(file_name, "wb") as csv_file:
        header = get_headers(columns)
        writer = csv.writer(csv_file, delimiter=',')
        writer.writerow(header)

        while total_bytes_written < num_of_bytes:
            (row, size) = get_next_row(columns)
            total_bytes_written = total_bytes_written + size + (num_columns - 1)
            writer.writerow(row)
            rows_written = rows_written + 1

            if rows_written % 5000 == 0:
                print("rows: " + str(rows_written) + " mb: " + str(float(total_bytes_written)/float(1000000.00)))

if __name__ == '__main__':
    if len(sys.argv) != 4:
        print(str(sys.argv))
        print("Usage: python generate_csv.py <csv_file_name> num_columns num_of_mb")
        sys.exit()

    file_name = sys.argv[1]
    num_columns = int(sys.argv[2])
    num_of_mb = sys.argv[3]
    num_of_bytes = int(num_of_mb) * 1000000
    write_csv(file_name, num_columns, num_of_bytes)
