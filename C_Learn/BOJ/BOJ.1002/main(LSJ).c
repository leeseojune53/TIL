#include <stdio.h>
#include <math.h>
#include <stdlib.h>
int what(double R,int r1,int r2)
{
    if(R>r1+r2)
        printf("0\n");
        else if(R==r1+r2)
            printf("1\n");
        else if(abs(r1-r2)<R&&R<r1+r2)
            printf("2\n");
        else if(R==abs(r1-r2))
            printf("1\n");
        else if(R<abs(r1-r2))
            printf("0\n");
    return 0;
}
int main()
{
    int x1,y1,r1,x2,y2,r2;
    double R=0;
    int Testcase = 0;
    scanf("%d\n",&Testcase);
    for(int i=0;i<Testcase;i++)
    {
        scanf("%d %d %d %d %d %d\n",&x1,&y1,&r1,&x2,&y2,&r2);
        if(x1==x2&&y1==y2)
            if(r1>r2||r1<r2)
                printf("0\n");
            else printf("-1\n");
        else{
        R = sqrt(pow(x2-x1,2)+pow(y2-y1,2));
        what(R,r1,r2);
        }
    }
    return 0;
}
