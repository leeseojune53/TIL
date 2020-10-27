#include <iostream>
using namespace std;




class CMyData
{
public:
	CMyData() {
		m_nX = 0;
	}
	CMyData(int nX, int nY) {
		SetX(nX);
	}
	~CMyData();
	int Getx() {
		return m_nX;
	}
	void SetX(int nX) {
		m_nX = nX;
	}
private:
	int m_nX;

};

class CMyDataEx : CMyData
{
public:
	void SetDataGetData(int nY) {
		m_nY = nY;
	}

	void SetY(int nY) {
		m_nY = nY;
	}

	int GetY() {
		return m_nY;
	}
private:
	int m_nY;
};

int main()
{
    CMyDataEx data;
    data.SetData(20, 30);
	cout << data.Getx() << endl;
	cout << data.GetY() << endl;
	return 0;
}

