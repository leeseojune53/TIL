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

	explicit CMyString();

	explicit CMyString(const char* pszParam);

	CMyString& operator=(const CMyString& rhs);

	~CMyString();

	operator char*() const;
};