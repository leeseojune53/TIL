#pragma once
class CMyData
{
public:
	CMyData();
	CMyData(int nX);
	~CMyData();
	int GetData();
	void SetData(int m_nX);
private:
	int m_nX;

};