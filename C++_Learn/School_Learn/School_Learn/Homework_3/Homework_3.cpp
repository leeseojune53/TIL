#include	<iostream>
#include	"CMyString.h"
using	namespace	std;
int	main()
{
	CMyString	strParam("StudentID	: 1210"), strName("Name : 이서준");	//	학번,이름은	본인	것으로	수정
	if (strParam == strName)
		cout << "같다! " << endl;
	else
		cout << "다르다!	" << endl;
	CMyString	strTest = CMyString("StudentID	: 1210");	//	학번은	본인	것으로	수정
	if (strParam != strTest)
		cout << "다르다!" << endl;
	else
		cout << "같다! " << endl;
	return	0;
}