#include <iostream>

using namespace std;

int main()
{
    int n,cnt=1,sum=1;
    cin >> n;
    while(sum<n){
        sum+=6*cnt;
        cnt++;
    }
    cout << cnt << '\n';
    return 0;
}
