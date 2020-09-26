#include <iostream>

using namespace std;

int main()
{
    int n,input,max=-1000000,min=1000000;
    cin >> n;
    for(int i=0;i<n;i++){
        cin >> input;
        if(max<input)
            max=input;
        if(min>input)
            min=input;
    }
    cout << min << " " << max;
    return 0;
}
