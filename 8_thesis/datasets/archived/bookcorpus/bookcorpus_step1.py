import os
import threading
import time

read_files = [
    os.path.join('', "books_large_p1.txt"),
    os.path.join('', "books_large_p2.txt"),
]

write_file = "bookcorpus_step1.txt"
counter = 0
new_line = 0
stop_threads = False


def print_text():
    while not stop_event.is_set():
        print(f"Processed: {counter}")
        print(f"Lines: {new_line}")
        time.sleep(300)


stop_event = threading.Event()

print_thread = threading.Thread(target=print_text)
print_thread.start()

for txt_file in read_files:
    with open(txt_file, mode="r", encoding="utf-8") as f, open(write_file, mode='w', encoding='utf-8') as w:
        for line in f:
            length = len(line)
            if 85 <= length <= 1000:
                w.write(f'{line}')
                new_line += 1
            counter += 1

stop_event.set()
print_thread.join()
