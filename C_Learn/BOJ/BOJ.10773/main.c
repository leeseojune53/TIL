#include <stdio.h>

int main() {
    int arr[5] = { 0, };
    int sum = 0;

    for (int i = 0; i < 5; i++) {
        scanf("%d", &arr[i]);
        sum += arr[i];
    }
    printf("%d\n", sum / 5);
    for (int i = 0; i < 5; i++) {
        if (arr[i] <= 10) {
            printf("%d 프로그래밍 기초반", arr[i]);
        }
        else if (arr[i] < 45) {
            printf("%d 프로그래밍반", arr[i]);
        }
        else {
            printf("%d 다른 방과후 수업", arr[i]);
        }
    }
    return 0;
}