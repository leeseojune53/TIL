#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[42]={0,},input,cnt=0;
    for(int i=0;i<10;i++){
        scanf("%d",&input);
        a[input%42]++;
    }
    for(int i=0;i<42;i++){
        if(a[i])
            cnt++;
    }
    printf("%d",cnt);
    return 0;
}
