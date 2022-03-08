#include <stdio.h>

#define E_MAX 15
#define S_MAX 28
#define M_MAX 19

int main() {
    int e, s, m;
    int i = 0;
    int j = 0;
    int k = 0;

    int year = 0;

    scanf("%d %d %d", &e, &s, &m);

    while(1) {
        ++i;
        ++j;
        ++k;
        if(i > E_MAX) {
            i = 1;
        }
        if(j > S_MAX) {
            j = 1;
        }
        if(k > M_MAX) {
            k = 1;
        }
        ++year;
        if(e == i && j == s && k == m) {
            break;
        }
    }

    printf("%d", year);
}