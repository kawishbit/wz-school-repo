import os
import threading
import time
import spacy
import pandas as pd


def merge_dictionaries(dict_a, dict_b):
    merged_dict = dict_b.copy()
    merged_dict.update(dict_a)
    return merged_dict


nlp = spacy.load('en_core_web_trf')

read_file = "bookcorpus_step1.txt"
write_file = "bookcorpus_step2.txt"

batch_size = 1000
counter = 0
new_line = 0
stop_threads = False
threshold = 0.8

oxford_map = pd.read_csv('../word_cefr/oxford_dataset/oxford_word_cefr_map.csv')
kaggle_map = pd.read_csv('../word_cefr/kaggle_dataset/kaggle_word_cefr_map_filtered.csv')

oxford_dict_word_only = oxford_map.set_index('text')['cefr'].to_dict()
kaggle_dict = kaggle_map.set_index('headword')['CEFR'].to_dict()

word_map = list(merge_dictionaries(oxford_dict_word_only, kaggle_dict).keys())

def print_text():
    while not stop_event.is_set():
        print(f"Processed: {counter}")
        print(f"Lines: {new_line}")
        time.sleep(300)


stop_event = threading.Event()

print_thread = threading.Thread(target=print_text)
print_thread.start()

with open(read_file, mode="r", encoding="utf-8") as f, open(write_file, mode='w', encoding='utf-8') as w:
    batch = []
    for line in f:
        doc = nlp(line)
        words = [token.text.lower() for token in doc if token.is_alpha]
        vocab_count = sum(1 for word in words if word in word_map)
        is_appropriate = (vocab_count / len(words)) >= threshold
        if is_appropriate:
            w.write(f'{line}')
            new_line += 1
        counter += 1

stop_event.set()
print_thread.join()
