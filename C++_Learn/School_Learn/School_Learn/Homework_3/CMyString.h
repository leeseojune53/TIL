#pragma once
#include <iostream>
#include <string.h>

using namespace std;

class CMyString {
private:
	char* m_pszData;
	int m_nLenth;
public:
	int SetString(const char* pszparm);

	const char* GetString() const;

	CMyString(const CMyString& rhs);

	CMyString();

	CMyString(const char*);

	CMyString& operator=(const CMyString& rhs);

	~CMyString();

	operator char*();
};