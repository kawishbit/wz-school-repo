import pandas as pd

# Assuming your JSON data is stored in a file named 'data.json'
json_file_path = 'oxford_word_cefr_map.json'

# Read the JSON data into a DataFrame
df = pd.read_json(json_file_path)

# Save the DataFrame to a CSV file
csv_file_path = 'oxford_word_cefr_map.csv'
df.to_csv(csv_file_path, index=False)