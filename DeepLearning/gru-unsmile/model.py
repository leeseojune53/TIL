#%%
from matplotlib import pyplot as plt
from matplotlib import rc
import tensorflow as tf
import datasets as ds
import numpy as np
import pandas as pd
from tqdm import tqdm
from konlpy.tag import Okt
from keras.preprocessing.text import Tokenizer
from tensorflow.keras.preprocessing.sequence import pad_sequences
from tensorflow.keras.models import Model, load_model
from tensorflow.keras.layers import Input, Embedding, Dense, GRU, Dropout
from tensorflow.keras.callbacks import EarlyStopping, ModelCheckpoint
import tensorflow.keras.backend as K


def F1score(y_true, y_pred):
    eps = K.epsilon()
    true_positives = K.sum(K.round(K.clip(y_true * y_pred, 0, 1)))
    real_positives = K.sum(K.round(K.clip(y_true, 0, 1)))
    pred_positives = K.sum(K.round(K.clip(y_pred, 0, 1)))
    recall = true_positives / (real_positives + eps)
    precision = true_positives / (pred_positives + eps)
    f1_score = 2 * (recall * precision) / (recall + precision + eps)
    return f1_score

def SimpleGRU():
    input_layer = Input(shape=(max_len,))
    embedding_text = Embedding(vocab_size, 256)(input_layer)
    x = GRU(128)(embedding_text)
    x = Dropout(0.5)(x)
    output_layers = [Dense(1, activation="sigmoid", name=label_names[i])(x) for i in range(y.shape[1])]

    model = Model(inputs=input_layer, outputs=output_layers)
    model.compile(loss=['binary_crossentropy']*n_label, optimizer='rmsprop', metrics=[F1score])

    return model

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
x_train = []

for sentence in tqdm(train_data['문장']):
    tokenized_sentence = okt.morphs(sentence, stem=True)
    stopwords_removed_sentence = [word for word in tokenized_sentence if not word in stopwords]
    x_train.append(stopwords_removed_sentence)

print(x_train[:5])

del train_data['문장']


tokenizer = Tokenizer()
tokenizer.fit_on_texts(x_train)

threshold = 3
total_cnt = len(tokenizer.word_index) # 단어의 수
rare_cnt = 0 # 등장 빈도수가 threshold보다 작은 단어의 개수를 카운트
total_freq = 0 # 훈련 데이터의 전체 단어 빈도수 총 합
rare_freq = 0 # 등장 빈도수가 threshold보다 작은 단어의 등장 빈도수의 총 합

vocab_size = total_cnt - rare_cnt + 1

X = tokenizer.texts_to_sequences(x_train)
print('문장의 최대 길이 :',max(len(l) for l in X))
print('문장의 평균 길이 :',sum(map(len, X))/len(X))

max_len = 40

x_train = pad_sequences(X, maxlen = max_len)

y = np.array(train_data.iloc[:, :10])

ko_label_names = ['여성/가족', '남성', '성소수자', '인종/국적', '연령', '지역', '종교', '기타 혐오', '악플/욕설', 'clean']
label_names = ['woman_family', 'man', 'lgbt', 'race_nationality', 'age', 'location', 'religion', 'aversion', 'abuse', 'clean']
n_label = len(label_names)

y_train = {label_names[i]:y[:,i] for i in range(n_label)}

model = SimpleGRU()




# %%
def predict_review(sentence, max_len=40):
    #Preprocess, Predict
    sentence = sentence.replace("[^ㄱ-ㅎㅏ-ㅣ가-힣 ]","") # 정규 표현식 수행
    if sentence == '':
        return "문장 해석 불가"

    new = okt.morphs(sentence)
    new = [word for word in new if not word in stopwords]
    encoded = list(filter(lambda x: x>0, [tokenizer.word_index.get(i,0) for i in new])) #단어를 인덱스로 바꿈
    pad_new = [0]*(max_len-len(encoded)) + encoded    # 패딩
    scores = [i[0][0] for i in model.predict(np.array([pad_new]))]
    
    #Visualize
    rc('font', family='AppleGothic')
    plt.rcParams['axes.unicode_minus'] = False

    x, y = ko_label_names, scores
    print(x)
    print(y)
    colors = ['#E47F2D' if yy > 0.5 else '#747B86' for yy in y]  ##확률이 0.5 넘는 경우 주황색
    plt.barh(x, y, color=colors, height=0.5)
    plt.title("Category")
    plt.xlim(0,1)
    for i in range(10):
        plt.text(y[i]+0.01, x[i], '{:.2f}%'.format(y[i]*100), verticalalignment='center')