#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    int x[2],y[2],r1,r2,n;
    double R;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d %d %d %d %d %d",&x[0],&y[0],&r1,&x[1],&y[1],&r2);
        R=sqrt(pow(x[1]-x[0],2)+pow(y[1]-y[0],2));
        if(x[0]==x[1]&&y[0]==y[1]){ // 원의 중심이 같을 때
            if(r1>r2||r1<r2)
                printf("0\n");//반지름이 다를 때 (접점의 수 0)
            else printf("-1\n");//반지름의 길이가 같을때 (접점의 수 무한)
        }
        else if(R>r1+r2)
            printf("0\n");
        else if(R==r1+r2)
            printf("1\n");
        else if(abs(r1-r2)<R&&R<r1+r2)
            printf("2\n");
        else if(R==abs(r1-r2))
            printf("1\n");
        else if(R<abs(r1-r2))
            printf("0\n");
    }
    return 0;
}
