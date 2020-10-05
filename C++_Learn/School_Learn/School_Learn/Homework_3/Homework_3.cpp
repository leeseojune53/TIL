#include	<iostream>
#include	"CMyString.h"
using	namespace	std;
int	main()
{
	CMyString	strData, strTest;
	strData.SetString("Hello");
	strTest.SetString("World");
	//	복사	생성
	CMyString	strNewData(strData);
	cout << strNewData.GetString() << endl;
	//	단순	대입	연산자	호출
	strNewData = strTest;
	cout << strNewData.GetString() << endl;
	return	0;
}