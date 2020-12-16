#include "CMyListEx.h"
#include <cstdio>
#include <ioStream>

using	namespace	std;
int	main()
{
	
	CMyListEx * buflist = new CMyListEx(0);
	buflist->Insert(1);
	buflist->Insert(2);
	buflist->Insert(3);
	CMyListEx* list = new CMyListEx(*buflist);
	char n;
	int insert;
	
	while (1) {
		/*cout << "\n------------------------------------\n";
		cout << "CMyList 메뉴\n1 : 삽입 Head\n2 : 삽입 Tail\n3 : 삭제 Head\n4 : 삭제 Tail\n5 : 출력 Head -> Tail\n6 : 출력 Tail -> Head\n0 : 종료\n";
		cout << "------------------------------------\n";
		cout << "메뉴를 고르세요(숫자 입력) : ";*/
		list->showmenu();
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
			list->InsertHead(insert);
			getchar();
			break;
		case '2':
			cout << "삽입할 데이터를 입력해주세요 : ";
			cin >> insert;
			if (cin.fail())
			{
				cin.clear();
				cin.ignore(10000, '\n');
				cout << "	0,	1,	2	중	숫자를	입력하세요~!\n";
				continue;
			}
			list->Insert(insert);
			getchar();
			break;
		case '3':
			list->DeleteHead();
			break;
		case '4':
			list->DeleteTail();
			break;
		case '5':
			list->PrintData();
			break;
		case '6':
			list->PrintDataTail();
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