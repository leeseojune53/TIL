import tensorflow as tf
from keras.layers import Conv2D, MaxPooling2D, Flatten, Dense

mnist = tf.keras.datasets.mnist

(x_train, y_train), (x_test, y_test) = mnist.load_data()
x_train, x_test = x_train / 255.0, x_test / 255.0

model = tf.keras.models.Sequential([
    Conv2D(filters=10, kernel_size=(5, 5), activation='relu', input_shape=(28,28,1)),
    MaxPooling2D(pool_size=(2, 2)),
    Conv2D(filters=20, kernel_size=(5, 5), activation='relu'),
    MaxPooling2D(pool_size=(2, 2)),
    Flatten(),
    Dense(units=100, activation='relu'),
    Dense(units=10, activation='softmax')
])

model.summary()

loss_fn = tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True)

model.compile(optimizer='adam',
              loss=loss_fn,
              metrics=['accuracy'])

model.fit(x_train, y_train, epochs=5)

model.evaluate(x_test, y_test, verbose=2)