#include <stdio.h>
#define MAX 1000001
typedef long long LL;

int numbers[MAX];

int main() {
    LL i;
    LL min, max;
    int cnt = 0;

    scanf("%lld %lld", &min, &max);

    for (i = 2; i * i <= max; i++) {
        LL tmp = i * i;

        LL x = min / tmp;
        if (min % tmp != 0) x++;

        while (x * tmp <= max) {
            numbers[x * tmp - min] = 1;
            x++;
        }
    }

    for (i = 0; i <= max - min; i++) {
        if (numbers[i] == 0) cnt++;
    }

    printf("%d\n", cnt);
}
