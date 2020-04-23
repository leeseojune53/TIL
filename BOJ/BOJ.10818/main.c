#include <stdio.h>
#include <stdlib.h>

int main()
{
    int N,a;
    int min=1000000,max=-1000000;
    scanf("%d",&N);
    for(int i=0;i<N;i++){
        scanf("%d",&a);
        if(min>a)
            min=a;
        if(max<a)
            max=a;
    }
    printf("%d %d",min,max);
    return 0;
}
