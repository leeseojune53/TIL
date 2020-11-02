#include <iostream>

using namespace std;

class CMyDataArr
{
private:
    int* m_pnArr = nullptr;
    int count = -1;
    int Size;
public:
    CMyDataArr(int Size) {
        m_pnArr = new int[Size];
        this->Size = Size;
    }

    void Insert(int Data) {
        if (m_pnArr == NULL) {
            cout << "m_pnArr is NULL" << endl;
            return;
        }
        if (count == Size - 1) {
            cout << "m_pnArr is FULL" << endl;
            return;
        }
        m_pnArr[++count] = Data;
    }

    void PrintData() {
        if (m_pnArr == NULL) {
            cout << "m_pnArr is NULL" << endl;
            return;
        }
        cout << "전체 데이터 : ";
        for (int i = 0; i < count + 1; i++) {
            cout << m_pnArr[i] << " ";
        }

        cout << " [" << (count + 1) << " / " << Size << " 개 ]" << endl;
    }
};

int	main()
{
    CMyDataArr	arr(10);
    arr.Insert(10);
    arr.Insert(96);
    arr.Insert(-45);
    arr.Insert(90);
    arr.Insert(-21);
    arr.Insert(100);
    arr.Insert(63);
    arr.Insert(28);
    arr.Insert(14);
    arr.Insert(48);
    arr.PrintData();
    return	0;
}