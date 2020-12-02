#include	<iostream>
#include	"CMyString.h"
#include	"CMyStringEx.h"
using	namespace	std;
int	main()
{
	CMyStringEx	strTest;
	CMyStringEx bufTest;
	strTest.SetString("멍멍이아들");
	cout << strTest << endl;
	strTest.SetString("학번 : 1210, 이름	: 이서준");
	cout << strTest << endl;
	return	0;
}