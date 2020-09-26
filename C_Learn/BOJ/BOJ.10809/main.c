#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define SIZE 26

int main()
{
    int arr[26]={0,};
    char check[100];
    scanf("%s",check);
    for(int i=0;i<strlen(check);i++){
        if(arr[check[i]-97]==0)
            arr[check[i]-97]=i+1;
    }
    for(int i=0;i<SIZE;i++) printf("%d ",arr[i]-1);
    return 0;
}
