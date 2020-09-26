#include <stdio.h>
#include <stdlib.h>

int main()
{
	int x[4],y[4];
	for(int i=0;i<3;i++){
        scanf("%d %d",&x[i],&y[i]);
	}
	if(x[0]==x[1])
        x[3]=x[2];
    else if(x[1]==x[2])
        x[3]=x[0];
    else x[3]=x[1];

    if(y[0]==y[1])
        y[3]=y[2];
    else if(y[1]==y[2])
        y[3]=y[0];
    else y[3]=y[1];

    printf("%d %d",x[3],y[3]);
}
