import tensorflow as tf
import datasets as ds
import numpy as np
from keras.layers import GRU

dataset = ds.load_dataset('smilegate-ai/kor_unsmile')

## dataset train / test 분리

train_data = dataset['train']
test_data = dataset['valid']



training_sentences = []
training_labels = []

testing_sentences = []
testing_labels = []

for data in train_data:
    training_sentences.append(str(data['문장'].numpy()))
    # training_labels.append(str())

print(training_sentences)


tf.keras.models.Sequential(
    GRU()
)