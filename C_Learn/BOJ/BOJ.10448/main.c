#include <stdio.h>
#include <stdlib.h>

int array[44];

int check(int value) {
    for(int i = 0; i < 44; i++) {
        for(int j = 0; j < 44; j++) {
            for(int k = 0; k < 44; k++) {
                if(array[i] + array[j] + array[k] == value) {
                    return 1;
                }
            }
        }
    }
    return 0;
}

int main() {
    int n;
    int value;
    int *result;

    scanf("%d", &n);

    result = malloc(sizeof(int) * n);

    for(int i = 1; i < 45; i++) {
        array[i-1] = ((i*i) + i)/2;
    }

    for(int i = 0;i < n; i++) {
        scanf("%d", &value);
        result[i] = check(value);
    }

    for(int i = 0; i < n; i++) {
        printf("%d\n", result[i]);
    }
}