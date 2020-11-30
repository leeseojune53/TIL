#define _CRT_SECURE_NO_WARNINGS
#include "CMyStringEx.h"
#include <string.h>

CMyStringEx::CMyStringEx(const char* pszData)
{
	this->SetString(pszData);
}

int CMyStringEx::Find(const char* pszData)
{
	const char* result = strstr(this->GetString(), pszData);
	if (result != nullptr) {
		return (result - this->GetString()) / sizeof(char);
	}
	return -1;
}

void CMyStringEx::OnSetString(char* pszData, int nLength)
{
	if (!(strcmp(pszData, "ธÛธÛภฬพฦต้"))) {
		strcpy(pszData, "*ย๘วัพฦต้*");
	}
}
