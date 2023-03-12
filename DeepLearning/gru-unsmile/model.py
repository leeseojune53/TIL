#%%
import tensorflow as tf
import datasets as ds
import numpy as np
import pandas as pd
from tqdm import tqdm
from konlpy.tag import Okt
from keras.preprocessing.text import Tokenizer
from tensorflow.keras.preprocessing.sequence import pad_sequences
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

# 토큰화
okt = Okt()
stopwords = ['의','가','이','은','들','는','좀','잘','걍','과','도','를','으로','자','에','와','한','하다']
X_train = []

for sentence in tqdm(train_data['문장']):
    tokenized_sentence = okt.morphs(sentence, stem=True)
    stopwords_removed_sentence = [word for word in tokenized_sentence if not word in stopwords]
    X_train.append(stopwords_removed_sentence)

print(X_train[:5])

del train_data['문장']

#%%

tokenizer = Tokenizer()
tokenizer.fit_on_texts(X_train)

threshold = 3
total_cnt = len(tokenizer.word_index) # 단어의 수
rare_cnt = 0 # 등장 빈도수가 threshold보다 작은 단어의 개수를 카운트
total_freq = 0 # 훈련 데이터의 전체 단어 빈도수 총 합
rare_freq = 0 # 등장 빈도수가 threshold보다 작은 단어의 등장 빈도수의 총 합

X = tokenizer.texts_to_sequences(X_train)
print('리뷰의 최대 길이 :',max(len(l) for l in X))
print('리뷰의 평균 길이 :',sum(map(len, X))/len(X))

max_len = 40

X = pad_sequences(X, maxlen = max_len)

y_train = np.array(train_data.iloc[:, :10])

label_names = train_data.columns[:10] #label 종류
n_label = len(label_names)

y_train_list = {label_names[i]:y_train[:,i] for i in range(n_label)}