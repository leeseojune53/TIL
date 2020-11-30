#define _CRT_SECURE_NO_WARNINGS

#include "CMyString.h"
#include <iostream>

CMyString::CMyString()
	:m_pszData(nullptr),
	m_nLength(0)
{
}

CMyString::CMyString(const CMyString& param)
{
	SetString(param.m_pszData);
}

CMyString::CMyString(CMyString&& rhs)
	:m_nLength(0),
	m_pszData(nullptr)
{
	cout << "CMyString 이동생성자 호출" << endl;
	m_nLength = rhs.m_nLength;
	m_pszData = rhs.m_pszData;

	// pointe를 끊어 준다:shallow 복사 이동생성으로 생성한 객체에서 삭제를 할 것이기 때문
	rhs.m_nLength = 0;
	rhs.m_pszData = nullptr;
}

CMyString::CMyString(const char* pszParam)
	:m_pszData(nullptr)
	, m_nLength(0)
{
	SetString(pszParam);
}

int CMyString::GetLength() const
{ 
	return m_nLength;
}

int CMyString::Append(const char* pszParam)
{
	if (pszParam == nullptr) {
		return 0;
	}
	const int targetLength = strlen(pszParam);
	const int srcLength = strlen(this->m_pszData);

	char* newData = new char[srcLength + targetLength + 1];

	strcpy(newData, m_pszData);
	strcpy(newData + srcLength, pszParam);

	Release();

	m_pszData = newData;
	m_nLength = targetLength + srcLength;

	return m_nLength;
}

CMyString& CMyString::operator=(const CMyString& param) 
{
	if (m_pszData != NULL) {
		delete[] m_pszData;
	}
	if (this == &param) {
		return *this;
	}
	m_nLength = param.m_nLength;
	m_pszData = new char[m_nLength + 1];
	strcpy(m_pszData, param.m_pszData);
	return *this;
}

CMyString::operator char* () const 
{
	return m_pszData;
}

CMyString CMyString::operator+(const CMyString& rhs)
{
	CMyString src(*this);

	src.Append(rhs.m_pszData);

	return src;
}

CMyString& CMyString::operator+=(const CMyString& rhs)
{
	this->Append(rhs.m_pszData);
	return *this;
}

char& CMyString::operator[](int index)
{
	return this->m_pszData[index];
}

char CMyString::operator[](int index) const
{
	return this->m_pszData[index];
}

int CMyString::operator==(const CMyString& rhs)
{
	if (this->m_pszData != nullptr && rhs.m_pszData != nullptr) {
		if (strcmp(this->m_pszData, rhs.m_pszData) == 0) {
			return 1;
		}
	}
	return 0;
}

int CMyString::operator!=(const CMyString& rhs)
{
	if (this->m_pszData != nullptr && rhs.m_pszData != nullptr) {
		if (strcmp(this->m_pszData, rhs.m_pszData) == 0) {
			return 0;
		}
	}
	return 1;
}

// 멤버변수 m_pszData에 할당된 메모리를 해제하고 NULL로 초기화
void CMyString::Release() 
{
	if (m_pszData) {
		delete[] m_pszData;
		m_pszData = nullptr;
		m_nLength = 0;
	}
	// TODO: 여기에 구현 코드 추가.
}

// 매개변수로 받은 문자열을 멤버변수에 저장하는 함수
int CMyString::SetString(const char* pszParam)
{
	Release();

	m_nLength = strlen(pszParam);
	
	if (pszParam == nullptr || m_nLength == 0) {
		return -1;
	}

	m_pszData = new char[m_nLength + 1];
	strcpy(m_pszData, pszParam);

	OnSetString(m_pszData, m_nLength);
	return 0;
}

// 멤버변수에 저장된 문자열을 가져오는 함수
const char* CMyString::GetString() const 
{
	// TODO: 여기에 구현 코드 추가.
	if (m_pszData == nullptr) {
		return "문자열이 저장되지 않음";
	}
	return m_pszData;
}

CMyString::~CMyString() 
{
	Release();
}

void CMyString::OnSetString(char* pszData, int nLength)
{

}
