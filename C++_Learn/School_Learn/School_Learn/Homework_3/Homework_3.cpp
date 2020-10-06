#include	<iostream>
#include	"CMyString.h"
using	namespace	std;

void TestFunc(const	CMyString& strParam)
{
	cout << strParam << endl;
}
int	main()
{
	CMyString	strData("Hello");
	::TestFunc(strData);
	::TestFunc(CMyString("World"));
	return	0;
}