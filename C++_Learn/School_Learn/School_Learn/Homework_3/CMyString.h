#pragma once
#include <iostream>
#include <string.h>

using namespace std;

class CMyString {
private:
	char* m_pszData;
	int m_nLength;
public:
	int SetString(const char* pszparm);

	const char* GetString() const;

	explicit CMyString(const CMyString& rhs);

	CMyString(CMyString&& rhs);

	explicit CMyString();

	explicit CMyString(const char* pszParam);

	CMyString& operator=(const CMyString& rhs);

	~CMyString();

	void Release();

	CMyString operator+(const CMyString& rhs);

	CMyString& operator+=(const CMyString& rhs);

	operator char*() const;

	int GetLength() const;

	int Append(const char* pszParam);

	char& operator[](int nIndex);
	char operator[](int nIndex) const;

	int operator==(const CMyString& rhs);
	int operator!=(const CMyString& rhs);
};