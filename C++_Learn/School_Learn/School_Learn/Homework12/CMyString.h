#pragma once

using namespace std;

class CMyString
{
public:
	CMyString();
	CMyString(const CMyString&);
	// explicit 키워드가 붙는 이유: 묵시적인 클래스 변환을 막기 위해
	// TestFunc(5)와 같이 묵시적으로 변환이 되지 않고 TestFunc(CMyString(5))와 
	// 같이 임시객체가 생성된다는 걸 명확히 드러내도록
	explicit CMyString(const char*);
	CMyString(CMyString&&);
	int GetLength() const;
	int Append(const char*);
	operator char*() const;
	CMyString& operator=(const CMyString&);
	CMyString operator+(const CMyString&);
	CMyString& operator+=(const CMyString&);
	char& operator[](int);
	char operator[](int) const;
	int operator==(const CMyString&);
	int operator!=(const CMyString&);
	~CMyString();
	int SetString(const char*);
	const char* GetString() const;
	void Release();
	virtual void OnSetString(char* pszData, int nLength);
private:
	char* m_pszData;
	int m_nLength;
};

