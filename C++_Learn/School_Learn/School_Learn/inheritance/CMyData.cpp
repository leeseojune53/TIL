
class CMyData
{
public:
	CMyData() {
		m_nY = 0;
	}
	CMyData(int nX, int nY) {
		SetData(nX, nY);
	}
	~CMyData();
	int Getx() {
		return m_nX;
	}
	int GetY() {
		return m_nY;
	}
	void SetData(int nX, int nY) {
		m_nX = nX;
		m_nY = nY;
	}
private:
	int m_nX;
	int m_nY;

};