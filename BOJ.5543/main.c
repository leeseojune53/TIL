#include <stdio.h>
#include <stdlib.h>

int main()
{
    int buger[3];
    int drink[2];
    int min=10000;
    for(int i=0;i<3;i++){
        scanf("%d",&buger[i]);
    }
    for(int i=0;i<2;i++){
        scanf("%d",&drink[i]);
    }
    for(int i=0;i<3;i++){
        for(int j=0;j<2;j++){
            if(buger[i]+drink[j]<min)
                min=buger[i]+drink[j];
        }
    }
    printf("%d",min-50);
    return 0;
}
