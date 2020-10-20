#include "CMyString.h"

CMyString::CMyString(const CMyString& rhs) 
//	:	m_nData(rhs.m_nData)
{
	m_nLength = strlen(rhs.GetString());
	m_pszData = new char[m_nLength + 1];
	strcpy(m_pszData, rhs.GetString());
	cout << "CMyData(const	CMyData	&)" << endl;
}

CMyString::CMyString() 
	:m_pszData(nullptr)
	, m_nLength(0)
{
	//cout << "default constructor" << endl;
	
}

const char* CMyString::GetString() const {
	if (m_pszData != nullptr)
		return m_pszData;
	return "";
}


int CMyString::SetString(const char* pszparm) {
	m_nLength = strlen(pszparm);
	if (m_nLength > 0) {
		m_pszData = new char[m_nLength + 1];
		strcpy(m_pszData, pszparm);
	}
	return 0;
}

CMyString& CMyString::operator=(const CMyString& rhs) {
	m_nLength = strlen(rhs.GetString());
	if (m_pszData != NULL) {
		delete[] m_pszData;
	}
		
	m_pszData = new char[m_nLength + 1];
	strcpy(m_pszData, rhs.GetString());
	//	객체	자신에	대한	참조를	반환한다.
	return	*this;
}

CMyString::CMyString(CMyString&& rhs) 
	:m_pszData(nullptr)
	, m_nLength(0) 
{
	cout << "CMyString 이동생성자 호출" << endl;

	m_pszData = rhs.m_pszData;
	m_nLength = rhs.m_nLength;

	rhs.m_pszData = nullptr;
	rhs.m_nLength = 0;
}

CMyString::~CMyString() { /*cout << "소멸" << endl;*/ }

CMyString::operator char*() const{ return m_pszData; }

int CMyString::GetLength() const { return m_nLength; }

int CMyString::Append(const char* pszParam) {
	if (pszParam == NULL)
		return 0;

	int nLenParam = strlen(pszParam);
	if (nLenParam == 0)
		return 0;

	if (m_pszData == NULL) {
		SetString(m_pszData);
		return m_nLength;
	}

	int nLenCur = m_nLength;

	char* result = new char[m_nLength + nLenParam + 1];

	strcpy(result, m_pszData);
	strcpy(result + nLenCur, pszParam);

	Release();

	m_pszData = result;
	m_nLength = nLenCur + nLenParam;

	return m_nLength;
}

void CMyString::Release() {
	if (m_pszData != nullptr) {
		delete[] m_pszData;
		m_pszData = nullptr;
	}
}

CMyString::CMyString(const	char* pszParam)
	:m_pszData(nullptr)
	, m_nLength(0)
{
	SetString(pszParam);
}

CMyString CMyString::operator+(const CMyString& rhs) {
	CMyString result(m_pszData);
	result.Append(rhs.m_pszData);
	return result;
}

CMyString& CMyString::operator+=(const CMyString& rhs) {
	Append(rhs.m_pszData);
	return *this;
}

char& CMyString::operator[](int nIndex) {
	return m_pszData[nIndex];
}

char CMyString::operator[](int nIndex) const {
	return m_pszData[nIndex];
}

int CMyString::operator==(const CMyString& rhs) {
	if (m_pszData != NULL && rhs.m_pszData != NULL) {
		if (strcmp(m_pszData, rhs.m_pszData) == 0)
			return 1;
		
	}
	return 0;
}

int CMyString::operator!=(const CMyString& rhs) {
	if (m_pszData != NULL && rhs.m_pszData != NULL) {
		if (strcmp(m_pszData, rhs.m_pszData) == 0)
			return 0;

	}
	return 1;
}
