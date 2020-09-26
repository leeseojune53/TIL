#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int n,j=0,score=1,sum;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        char input[81]={0,};
        scanf("%s",input);
        sum=0;
        score=1;
        for(int j=0;j<strlen(input);j++){
            if(input[j]=='O'){
                sum+=score;
                score++;
            }
            else score=1;
        }
        printf("%d\n",sum);
    }
    return 0;
}
