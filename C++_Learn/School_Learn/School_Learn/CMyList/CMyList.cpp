#include <iostream>
#include "CMyList.h"
using namespace std;

CMyList::~CMyList() {

	DNode* deleteNode;
	while (headNode != NULL) {
		deleteNode = headNode;
		headNode = headNode->link;
		delete deleteNode;


	}
	cout << "\nCMyList 소멸";
}

void CMyList::Insert(int num) {
	if (!isOverlap(num)) {
		return;
	}
	++m_nLength;
	//pHead가 NULL일떄
	DNode* newnode = new DNode;
	newnode->data = num;
	newnode->link = nullptr;
	if (headNode == NULL) {
		headNode = tailNode = newnode;
		PrintData();
		return;
	}
	tailNode->link = newnode;
	tailNode = tailNode->link;

	PrintData();

}

int CMyList::isOverlap(int num) {
	DNode* buf = headNode;
	if (buf == NULL)
		return 1;

	do {
		if (buf->data == num) {

			cout << "중복값.\n";
			return 0;
		}
		buf = buf->link;
	} while (buf != NULL);
	return 1;
}

void CMyList::PrintData() {
	DNode* buf = headNode;
	int count = 0;
	if (m_nLength == 0) {
		cout << "출력할 데이터가 없습니다.";
		return;
	}
	if (buf != NULL) {
		cout << "CMyList 데이터 : [Head] ";
		cout << buf->data;
		buf = buf->link;
		count = 1;
	}
	while (buf != NULL) {
		cout << " - " << buf->data;
		buf = buf->link;
		count++;
	}
	cout << " [Tail]\n";
	cout << "데이터 개수 : " << m_nLength << "개";

}