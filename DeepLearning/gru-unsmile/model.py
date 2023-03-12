import tensorflow as tf
import datasets as ds
import numpy as np
import pandas as pd
from tqdm import tqdm
from konlpy.tag import Okt
from keras.layers import GRU

dataset = ds.load_dataset('smilegate-ai/kor_unsmile')
# dataset train / test 분리 및 pandas DataFrame로 변환

train_data = pd.DataFrame.from_dict(dataset['train'])
test_data = pd.DataFrame.from_dict(dataset['valid'])

# 문장 중복 체크 및 제거
# actually dataset size = 15005
# printed: 15004 => only one row is not unique value
print(train_data['문장'].nunique())

train_data.drop_duplicates(subset=['문장'], inplace=True)

# 한글 및 공백 제외하고 제거
print(train_data[:5])
train_data['문장'] = train_data['문장'].str.replace("[^ㄱ-ㅎㅏ-ㅣ가-힣 ]","")
print(train_data[:5])

# 한글 및 공백 제거 후 빈 값 체크
train_data['문장'] = train_data['문장'].str.replace('^ +', "") # white space 데이터를 empty value로 변경
train_data['문장'].replace('', np.nan, inplace=True)
train_data = train_data.dropna(how = 'any')

# 불용어
okt = Okt()
stopwords = ['의','가','이','은','들','는','좀','잘','걍','과','도','를','으로','자','에','와','한','하다']
X_train = []

for sentence in tqdm(train_data['문장']):
    tokenized_sentence = okt.morphs(sentence, stem=True)
    stopwords_removed_sentence = [word for word in tokenized_sentence if not word in stopwords]
    X_train.append(stopwords_removed_sentence)

print(X_train[:5])
