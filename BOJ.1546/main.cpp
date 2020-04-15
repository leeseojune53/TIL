#include <iostream>

using namespace std;

int main()
{
    int n,max=0;
    int achievement[1000];
    double sum=0;
    cin >> n;
    for(int i=0;i<n;i++){
        cin >> achievement[i];
        if(max<achievement[i])
            max=achievement[i];
    }
    for(int i=0;i<n;i++){
        sum+=(float)achievement[i]/max*100;
    }
    cout << fixed;
    cout.precision(2);
    cout << (float)sum/n;
    return 0;
}
