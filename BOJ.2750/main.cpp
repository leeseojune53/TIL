#include <iostream>

using namespace std;

int main()
{
    int n,tmp;
    cin >> n;
    int *arr=new int[n];
    for(int i=0;i<n;i++) cin >> arr[i];
    for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            if(arr[i]>arr[j]){
                tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
            }
        }
    }
    for(int i=0;i<n;i++)
        cout << arr[i] << '\n';
    delete []arr;
    return 0;
}
