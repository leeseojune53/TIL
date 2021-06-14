#include <stdio.h>
#include <stdlib.h>

int main() {
	int size, input, i, cnt = 0, top = -1;
	int* stack;
	long sum = 0;
	scanf("%d", &size);
	stack = malloc(sizeof(int) * size);

	for (i = 0; i < size; i++) {
		scanf("%d", &input);
		if (input == 0 && top != -1) {
			stack[top] = 0;
			--top;
			--cnt;
		}
		else {
			stack[++top] = input;
			++cnt;
		}
	}



	for (i = 0; i < cnt; i++) {
		sum += stack[i];
	}

	printf("%ld", sum);

}