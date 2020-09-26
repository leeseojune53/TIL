#include <stdio.h>
#include <stdlib.h>
void print(int a)
{
    long l,w,cnt; // cnt : count, w : distance, l : width
    l=w=2;
    cnt=0;
    if(a<3){
            if(a==1) printf("1\n");
            else printf("2\n");
            return 0;
        }
        while(1){
            if(cnt==2){
                l++;
                cnt=0;
            }
            w+=l;
            cnt++;
            if(w>=a)
                break;
        }
        if(cnt==1)
            printf("%ld\n",l*2-1);
        else printf("%ld\n",l*2);
}

int main()
{
    int T,x,y,i; // T : test case, y-x : distance
    scanf("%d",&T);
    for(i=0;i<T;i++){
        scanf("%d %d",&x,&y);
        print(y-x);
    }
    return 0;
}
