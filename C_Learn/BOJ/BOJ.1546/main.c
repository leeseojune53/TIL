#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n,max=0;
    int achievement[1000];
    double sum=0;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d",&achievement[i]);
        if(max<achievement[i])
            max=achievement[i];
    }
    for(int i=0;i<n;i++){
        sum+=(float)achievement[i]/max*100;
    }
    printf("%f",(float)sum/n);
    return 0;
}
