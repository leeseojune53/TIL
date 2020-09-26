#include <stdio.h>
#include <stdlib.h>

int main()
{
    int max=0,num,input;
    for(int i=0;i<9;i++){
        scanf("%d",&input);
        if(max<input){
            max=input;
            num=i+1;
        }
    }
    printf("%d\n%d",max,num);
    return 0;
}
