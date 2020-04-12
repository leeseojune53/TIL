#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int a[2000001];

int main()
{
    int n,front=0,rear=-1,input;
    char check[10];
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%s",check);
        if(!strcmp(check,"push")){
            scanf("%d",&input);
            a[++rear]=input;
        }
        else if(!strcmp(check,"pop")){
            if(rear-front+1!=0){
                printf("%d\n",a[front++]);
            }else printf("-1\n");
        }
        else if(!strcmp(check,"size")){
            printf("%d\n",rear-front+1);
        }
        else if(!strcmp(check,"empty")){
            if(rear-front+1!=0)
                printf("0\n");
            else printf("1\n");
        }
        else if(!strcmp(check,"front")){
            if(rear-front+1!=0){
                printf("%d\n",a[front]);
            }
            else printf("-1\n");
        }
        else if(!strcmp(check,"back")){
            if(rear-front+1!=0){
                printf("%d\n",a[rear]);
            }
            else printf("-1\n");
        }
    }
    return 0;
}
