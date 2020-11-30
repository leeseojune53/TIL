#include "CMyList.h"
#include <cstdio>
#include <ioStream>

using	namespace	std;
int	main()
{
	CMyList	list;

	char n;
	int insert;
	while (1) {
		cout << "\n------------------------------------\n";
		cout << "CMyList 메뉴\n1 : 삽입\n2 : 출력\n0 : 종료\n";
		cout << "------------------------------------\n";
		cout << "메뉴를 고르세요(숫자 입력) : ";
		cin >> n;
		switch (n)
		{
		case '1':
			cout << "삽입할 데이터를 입력해주세요 : ";
			cin >> insert;
			if (cin.fail())
			{
				cin.clear();
				cin.ignore(10000, '\n');
				cout << "	0,	1,	2	중	숫자를	입력하세요~!\n";
				continue;
			}
			list.Insert(insert);
			getchar();
			break;
		case '2':
			list.PrintData();
			break;
		case '0':
			return 0;
		default:
			cout << "0 ~ 2의 값을 입력하세요!!";
			break;
		}
	}
	return	0;
}