import pandas as pd
import numpy as np
import spacy

nlp = spacy.load('en_core_web_sm')
oxford_map = pd.read_csv('../word_cefr/oxford_dataset/oxford_word_cefr_map.csv')
kaggle_map = pd.read_csv('../word_cefr/kaggle_dataset/kaggle_word_cefr_map_filtered.csv')

oxford_dict = oxford_map.set_index(['text', 'pos'])['cefr'].to_dict()
oxford_dict_word_only = oxford_map.set_index('text')['cefr'].to_dict()
kaggle_dict = kaggle_map.set_index('headword')['CEFR'].to_dict()

read_file = "bookcorpus_step3.txt"
write_file = "bookcorpus_step4.txt"
counter = 1

cefr_weights = {
    'A1': 1,
    'A2': 2,
    'B1': 4,
    'B2': 8,
    'C1': 16,
    'C2': 32
}
cefr_weights_2 = {
    'A1': 1,
    'A2': 2,
    'B1': 3,
    'B2': 4,
    'C1': 5,
    'C2': 6
}
cefr_weights_3 = {
    'A1': 1,
    'A2': 3,
    'B1': 5,
    'B2': 7,
    'C1': 9,
    'C2': 11
}
cefr_weights_4 = {
    'A1': 2,
    'A2': 3,
    'B1': 5,
    'B2': 7,
    'C1': 11,
    'C2': 13
}

cefr_weights_6 = {
    'A1': 1,
    'A2': 2,
    'B1': 4,
    'B2': 7,
    'C1': 15,
    'C2': 30
}


def process_sentence(sentence):
    doc = nlp(sentence)
    tokens_data = []
    for token in doc:
        tokens_data.append({
            'word': token.text,
            'lemma': token.lemma_,
            'pos': token.pos_,
            'is_alpha': token.is_alpha
        })
    return tokens_data


def get_cefr_level(word, pos):
    word_lower = word.lower()

    cefr_level = oxford_dict.get((word_lower, pos.lower()))
    if cefr_level:
        return cefr_level.upper()

    cefr_level = oxford_dict_word_only.get(word_lower)
    if cefr_level:
        return cefr_level.upper()

    cefr_level = kaggle_dict.get(word_lower)
    if cefr_level:
        return cefr_level.upper()

    return 'A1'


def weight_to_cefr(map_data, val):
    weight = min(list(map_data.values()), key=lambda x: abs(x - val))
    return list(map_data.keys())[list(map_data.values()).index(weight)]


def calculate_cefr(tokens_data):
    cefr_levels = []

    for token in tokens_data:
        if token['is_alpha']:
            token_cefr = get_cefr_level(token['lemma'], token['pos'])
            cefr_levels.append(token_cefr)

    if not cefr_levels:
        return 'Unknown'

    weight_1 = [cefr_weights.get(cefr_level, 1) for cefr_level in cefr_levels]
    weight_2 = [cefr_weights_2.get(cefr_level, 1) for cefr_level in cefr_levels]
    weight_3 = [cefr_weights_3.get(cefr_level, 1) for cefr_level in cefr_levels]
    weight_4 = [cefr_weights_4.get(cefr_level, 1) for cefr_level in cefr_levels]
    weight_5 = [cefr_weights_2.get(cefr_level, 1) for cefr_level in cefr_levels]
    weight_6 = [cefr_weights_6.get(cefr_level, 1) for cefr_level in cefr_levels]
    weight_7 = [cefr_weights_6.get(cefr_level, 1) for cefr_level in cefr_levels]

    weighted_avg_1 = sum(weight_1) / len(weight_1)
    weighted_avg_2 = sum(weight_2) / len(weight_2)
    weighted_avg_3 = sum(weight_3) / len(weight_3)
    weighted_avg_4 = sum(weight_4) / len(weight_4)
    weighted_avg_6 = sum(weight_6) / len(weight_6)

    weighted_avg_5 = np.mean(weight_5) + (0.9 * np.var(weight_5))
    weighted_avg_7 = np.mean(weight_7) + (0.9 * np.var(weight_7))

    return (weight_to_cefr(cefr_weights, weighted_avg_1),
            weight_to_cefr(cefr_weights_2, weighted_avg_2),
            weight_to_cefr(cefr_weights_3, weighted_avg_3),
            weight_to_cefr(cefr_weights_4, weighted_avg_4),
            weight_to_cefr(cefr_weights_2, weighted_avg_5),
            weight_to_cefr(cefr_weights_6, weighted_avg_6),
            weight_to_cefr(cefr_weights_6, weighted_avg_7))


def assign_cefr_to_sentence(sentence):
    tokens_data = process_sentence(sentence)
    cefr1, cefr2, cefr3, cefr4, cefr5, cefr6, cefr7 = calculate_cefr(tokens_data)
    return cefr1, cefr2, cefr3, cefr4, cefr5, cefr6, cefr7


with open(read_file, mode="r", encoding="utf-8") as f, open(write_file, mode='w', encoding='utf-8') as w:
    for line in f:
        cefr1, cefr2, cefr3, cefr4, cefr5, cefr6, cefr7 = assign_cefr_to_sentence(line)
        w.write(f'{counter}, "{line.rstrip()}", {cefr1}, {cefr2}, {cefr3}, {cefr4}, {cefr5}, {cefr6}, {cefr7} \n')
        counter += 1
