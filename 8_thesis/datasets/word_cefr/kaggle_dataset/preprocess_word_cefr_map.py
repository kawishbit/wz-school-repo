import pandas as pd

df = pd.read_csv('kaggle_word_cefr_map_raw.csv')


# Function to split the headwords containing slashes and create new rows
def split_slash_rows(df):
    # Find rows with '/'
    slash_rows = df[df['headword'].str.contains('/')]

    # Split those rows into new rows
    split_rows = slash_rows['headword'].str.split('/').apply(pd.Series, 1).stack()
    split_rows.index = split_rows.index.droplevel(-1)  # to match the original index
    split_rows.name = 'headword'

    # Repeat the CEFR level for the new rows
    split_rows_df = split_rows.to_frame().join(df['CEFR'], how='left')

    # Remove original rows with '/'
    df = df[~df['headword'].str.contains('/')]

    # Concatenate the original df with the new split rows
    df = pd.concat([df, split_rows_df]).reset_index(drop=True)

    return df


# Apply the function
df_split = split_slash_rows(df)

df_split.to_csv('kaggle_word_cefr_map_preprocessed.csv', index=False)




