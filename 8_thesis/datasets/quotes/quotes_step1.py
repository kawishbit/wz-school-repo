import re
import pandas as pd

# write_file = "quotes_step1.txt"
# counter = 1
# 
# df = pd.read_csv("quotes.csv")
# quotes = df['quote'].tolist()
# 
# REPLACE_BY_SPACE_RE = re.compile('[/(){}\[\]\|@,;]')
# BAD_SYMBOLS_RE = re.compile('[^0-9a-z #+_]')
# 
# with open(write_file, mode='w', encoding='utf-8') as w:
#     for text in quotes:
#         text = str(text)
#         if 85 <= len(text) <= 1000:
#             text = str(text).lower()
#             text = REPLACE_BY_SPACE_RE.sub(' ', text)
#             text = BAD_SYMBOLS_RE.sub('', text)
#             w.write(f'{text}\n')


df = pd.read_csv('quotes_step3.csv')
df_train = pd.read_csv('quotes_train.csv')
df_test = pd.read_csv('quotes_test.csv')

print(df.columns)
print(df['cefr5'].value_counts())


print(len(df_train.index))
print(len(df_test.index))

