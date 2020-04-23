#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n,tmp;
    int *arr;
    scanf("%d",&n);
    arr=(int*)malloc(sizeof(int)*n);
    for(int i=0;i<n;i++) scanf("%d",&arr[i]);
    for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            if(arr[i]>arr[j]){
                tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
            }
        }
    }
    for(int i=0;i<n;i++)
        printf("%d\n",arr[i]);
    free(arr);
    return 0;
}
