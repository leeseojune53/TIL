#include <iostream>

using namespace std;

int main()
{
    int n,max=0,M;
    cin >> n >> M;
    int *arr=new int[n];
    for(int i=0;i<n;i++)
        cin >> arr[i];
    for(int i=0;i<n-2;i++){
        for(int j=i+1;j<n-1;j++){
            for(int k=j+1;k<n;k++){
                if(max<arr[i]+arr[j]+arr[k]&&arr[i]+arr[j]+arr[k]<=M)
                    max=arr[i]+arr[j]+arr[k];
            }
        }
    }
    delete []arr;
    cout << max;
    return 0;
}
