#include <iostream>
#pragma warning(disable : 4996)

using namespace std;

class CMyStrArr
{
private:
    char** m_pszStr = nullptr;
    int Size;
    int count = -1;
public:
    CMyStrArr(int size) {
        this->Size = size;
        m_pszStr = new char* [Size];
    }

    void Insert(const char* Data) {
        if (Data == NULL) {
            cout << "Data is Empty";
            return;
        }
        if (m_pszStr == NULL) {
            cout << "m_pszStr is NULL";
            return;
        }
        m_pszStr[++count] = (char*)Data;
        //int Data_size = strlen(Data);
        //m_pszStr[++count] = new char[Data_size + 1];
        //strcpy(m_pszStr[count], Data);

    }

    void PrintData() {
        if (m_pszStr == NULL) {
            cout << "m_pszStr is NULL";
            return;
        }
        cout << "전체 데이터   [ " << (count + 1) << " / " << Size << "개 ]" << endl;
        for (int i = 0; i < count + 1; i++) {
            cout << i + 1 << " : " << m_pszStr[i] << endl;
        }
    }

};

int	main()
{
    CMyStrArr	arr(10);
    arr.Insert("월요일마다고고");
    arr.Insert("가나다123");
    arr.Insert("홍길동	abc");
    arr.Insert("함수형	!!");
    arr.Insert("알고리즘	zzz");
    arr.Insert("Tasla	Linux");
    arr.PrintData();

    return	0;
}
