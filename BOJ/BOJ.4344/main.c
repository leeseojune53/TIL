#include <stdio.h>
#include <stdlib.h>

int main()
{
    int achievement[1001];
    int n,c,sum,average,cnt;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        sum=cnt=0;
        scanf("%d",&c);
        for(int j=0;j<c;j++){
            scanf("%d",&achievement[j]);
            sum+=achievement[j];
        }
        average=sum/c;
        for(int j=0;j<c;j++){
            if(average<achievement[j])
                cnt++;
        }
        printf("%.3f%%\n",((double)cnt/c)*100);
    }
    return 0;
}
