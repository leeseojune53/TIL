#include <stdio.h>
#include <stdlib.h>

using namespace std;

int main()
{
    int n,cnt=1,sum=1;
    scanf("%d",&n);
    while(sum<n){
        sum+=6*cnt;
        cnt++;
    }
    printf("%d",cnt);
    return 0;
}
