#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int d(int x)
{
    int c,cnt,check;
    for(int i=1;i<x;i++){
        cnt=0;
        c=i;
        check=i;
        while(c>0){
            check+=c%10;
            c/=10;
        }
        if(check==x)
            return 0;
    }
    printf("%d\n",x);
    return 0;
}

int main()
{
    for(int i=1;i<=10000;i++){
        d(i);
    }
    return 0;
}
