#include	<iostream>
#include	"CMyString.h"
using	namespace	std;
CMyString	TestFunc()
{
	CMyString	strTest("TestFunc()	return");
	cout << strTest << endl;
	return	strTest;
}
int	main()
{
	//	이름없는	임시	객체가	만들어진다.
	TestFunc();
	return	0;
}