#pragma once

class CMyString {
private:
	string str;
public:
	void SetString(string s_parm) {
		str = s_parm;
	}

	string GetString() { return str; }

	CMyString(const CMyString& rhs)
		//	:	m_nData(rhs.m_nData)
	{
		this->str = rhs.str;
		cout << "CMyData(const	CMyData	&)" << endl;
	}

	CMyString& operator=(const CMyString& rhs) {
		*str = *rhs.str;
		//	객체	자신에	대한	참조를	반환한다.
		return	*this;
	}
};