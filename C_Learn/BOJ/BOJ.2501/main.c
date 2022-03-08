#include <stdio.h>

int main() {
    int n, k;
    int cnt = 0;
    int i = 0;
    int result = 0;
    int input;

    scanf("%d %d", &n, &k);
    while(cnt < k && i <= n) {
        
        ++i;
        if(n % i == 0) {
            ++cnt;
            result = i;
        }
    }
    
    if(cnt == k) {
        printf("%d", result);
    } else {
        printf("%d", 0);
    }

    return 0;
}