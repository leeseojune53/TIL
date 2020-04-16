#include <stdio.h>
#include <string.h>
#pragma warning(disable:4996)

int d(int a) {
    int New;
    New=a;
    while(a>0){
        New+=a%10;
        a/=10;
    }
    if(New>10000)
        return 0;
    return New;
}

int main() {
    int a[10000] = {0, };
    int i;
    for (i = 1; i < 10000; i++) 
        a[d(i)] = 1;

    for (i = 0; i < 10000; i++) 
        if (a[i] != 1)
            printf("%d\n", i);

    return 0;
}
