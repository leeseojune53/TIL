#include <stdio.h>
#include <stdlib.h>

int main() {
	int n, i, j, input;
	int value = -1;
	int* array;
	
	scanf("%d", &n);
	printf("%d", n);
	array = malloc(sizeof(int) * n);
	
	for(i = 0; i < n; i++) {
		scanf("%d", &input);
		array[i] = input;
	}
	
	for(i = 0; i < n; i++){
	    printf("%d", i);
		value = -1;
		for(j = n; j > 0; j++) {
			if(array[j] > array[i])
				value = array[j];
		}
		printf("%d ", value);
	}
	
	return 0;
	
}
