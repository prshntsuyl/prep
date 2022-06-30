from re import A
import pandas as pd;
import numpy as np;

df = pd.read_csv('somehwere.csv', header = 0)
print(df.head(2))

print(df.count())
# print(df['a'])


new_df = df['d'].str.split('/', expand=True)


result = pd.concat([df, new_df], axis=1)
result = result.drop(columns='d')

result = result.rename(columns={'0': 'd1', '1' : 'd2'}, inplace=True)

print(result.head(5))


asd = np.array([[1,23,3], [2, 43, 4], [5, 5, 3]])
print(asd.shape)