#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n,max=0,M;
    int *arr;
    scanf("%d %d",&n,&M);
    arr=(int*)malloc(sizeof(int)*n);
    for(int i=0;i<n;i++)
        scanf("%d",&arr[i]);
    for(int i=0;i<n-2;i++){
        for(int j=i+1;j<n-1;j++){
            for(int k=j+1;k<n;k++){
                if(max<arr[i]+arr[j]+arr[k]&&arr[i]+arr[j]+arr[k]<=M)
                    max=arr[i]+arr[j]+arr[k];
            }
        }
    }
    free(arr);
    printf("%d",max);
    return 0;
}
