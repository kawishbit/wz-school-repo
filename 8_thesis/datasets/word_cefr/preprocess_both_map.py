import pandas as pd


df1 = pd.read_csv('oxford_word_cefr_map.csv')
df2 = pd.read_csv('kaggle_word_cefr_map_preprocessed.csv')


df2_filtered = df2[~df2['headword'].isin(df1['text'])]

df2_filtered.to_csv('kaggle_word_cefr_map_filtered.csv', index=False)


