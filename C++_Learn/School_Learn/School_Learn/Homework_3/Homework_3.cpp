#include	<iostream>
#include	"CMyString.h"
using	namespace	std;
void	TestFunc(const	CMyString& strParam)
{
	for (int i = 0; i < strParam.GetLength(); i++)
	{
		cout << strParam[i] << "	";
	}
	cout << endl;
}
int	main()
{
	CMyString	strParam("StudentID	: 1210, Name : 이서준");	//	학번과	이름은	본인	것으로	수정
	cout << strParam.GetString() << endl;
	TestFunc(strParam);
	return	0;
}