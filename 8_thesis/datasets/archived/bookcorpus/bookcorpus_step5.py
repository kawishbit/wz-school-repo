import csv

with open('bookcorpus_step4.csv') as f_input, open('bookcorpus_step5.txt', mode='w', encoding='utf-8') as w:
    csv_input = csv.reader(f_input)
    header = next(csv_input)
    expected = len(header)

    for line_number, row in enumerate(csv_input, start=2):
        if len(row) != expected:
            w.write(f'{line_number} + {row}\n')
