#include <stdio.h>
#include <stdlib.h>

int main()
{
    int N,M,P,a,SW,cnt=0;
    int NUM[50][50]; // [Party number] [person number]
    int peo[50]; // Number of people for each party
    int truth[50]; // Who knows the truth: 1, Who doesn't: 2
    scanf("%d %d %d",&N,&M,&P);
    for(int i=0;i<P;i++){
        scanf("%d",&a);
        truth[a]=1;
    }
    for(int i=0;i<M;i++){
        scanf("%d",&peo[i]);
        for(int j=0;j<peo[i];j++){
            scanf("%d",&NUM[i][j]);
        }
    }
    for(int k=0;k<M;k++){
    for(int i=0;i<M;i++){
        for(int j=0;j<peo[i];j++){
            if(truth[NUM[i][j]]==1){
                for(int j=0;j<peo[i];j++){
                    truth[NUM[i][j]]=1;
                }
            }
        }
    }
    }
    for(int i=0;i<M;i++){
            SW=0;
        for(int j=0;j<peo[i];j++){
            if(truth[NUM[i][j]]==1)
                SW=1;
        }
        if(!SW)
            cnt++;
    }
    printf("%d",cnt);
}
