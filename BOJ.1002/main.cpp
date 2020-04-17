#include <iostream>
#include <stdlib.h>
#include <math.h>

using namespace std;

int main()
{
    int x[2],y[2],r1,r2,n;
    double R;
    cin >> n;
    for(int i=0;i<n;i++){
        cin >> x[0] >> y[0] >> r1 >> x[1] >> y[1] >> r2;
        R=sqrt(pow(x[1]-x[0],2)+pow(y[1]-y[0],2));
        if(x[0]==x[1]&&y[0]==y[1]){
            if(r1>r2||r1<r2)
                cout << 0 << '\n';
            else cout << -1 << '\n';;
        }
        else if(R>r1+r2)
            cout << 0 << '\n';
        else if(R==r1+r2)
            cout << 1 << '\n';
        else if(abs(r1-r2)<R&&R<r1+r2)
            cout << 2 << '\n';
        else if(R==abs(r1-r2))
            cout << 1 << '\n';
        else if(R<abs(r1-r2))
            cout << 0 << '\n';
    }
    return 0;
}
