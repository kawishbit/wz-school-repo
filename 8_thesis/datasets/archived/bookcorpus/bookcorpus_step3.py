import os
import threading
import time

read_file = "bookcorpus_step2.txt"
write_file = "bookcorpus_step3.txt"
counter = 0
stop_threads = False


def print_text():
    while not stop_event.is_set():
        print(f"Processed: {counter}")
        time.sleep(300)


stop_event = threading.Event()

print_thread = threading.Thread(target=print_text)
print_thread.start()


with open(read_file, mode="r", encoding="utf-8") as f, open(write_file, mode='w', encoding='utf-8') as w:
    for line in f:
        new_line = line.replace("``", "#")
        new_line = new_line.replace("''", "#")
        w.write(f'{new_line}')
        counter += 1

stop_event.set()
print_thread.join()
