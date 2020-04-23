#include <iostream>

using namespace std;

int main()
{
    int input,cnt=0;
    cin >> input;
    while(1){
        if(input%5==0){
            cnt+=input/5;
            break;
        }
        if(input<3){
            cnt=-1;
            break;
        }
        input-=3;
        cnt++;
    }
    printf("%d",cnt);
    return 0;
}
