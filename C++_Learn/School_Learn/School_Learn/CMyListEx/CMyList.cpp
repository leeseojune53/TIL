#include "CMyList.h"
#include <iostream>
using namespace std;

int CMyList::m_nLength;


CMyList::CMyList(int m_nLength) {
	this->m_nLength = m_nLength;
}


CMyList::~CMyList() {

	DNode* deleteNode;
	while (headNode != NULL) {
		deleteNode = headNode;
		headNode = headNode->back;
		delete deleteNode;

	}
}

DNode* CMyList::gethead() const {
	return headNode;
}

void CMyList::sethead(DNode* head) {
	this->headNode = head;
}

DNode* CMyList::gettail() const {
	return tailNode;
}

void CMyList::settail(DNode* tail) {
	this->tailNode = tail;
}

int CMyList::getLength() const {
	return m_nLength;
}

void CMyList::setLength(int Length) {
	this->m_nLength = Length;
}

void CMyList::Insert(int num) { // tail insert
	if (!isOverlap(num)) {
		return;
	}
	setLength(getLength() + 1);
	//pHead가 NULL일떄
	DNode* newnode = new DNode;
	newnode->data = num;
	newnode->front = gettail();
	newnode->back = nullptr;
	if (gethead() == NULL) {
		sethead(newnode);
		settail(newnode);
		PrintData();
		return;
	}
	gettail()->back = newnode;
	settail(gettail()->back);

	PrintData();

	//if (!isOverlap(num)) {
	//	return;
	//}
	//++m_nLength;
	////pHead가 NULL일떄
	//DNode* newnode = new DNode;
	//newnode->data = num;
	//newnode->back = nullptr;
	//if (headNode == NULL) {
	//	headNode = tailNode = newnode;
	//	PrintData();
	//	return;
	//}
	//tailNode->back = newnode;
	//tailNode = tailNode->back;

	//PrintData();

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
		buf = buf->back;
	} while (buf != NULL);
	return 1;
}

CMyList& CMyList::operator+=(const CMyList& rhs) {
	this->Append(rhs);
	return *this;
}

int CMyList::Append(const CMyList list) {
	cout << "length!!" << m_nLength;
	m_nLength -= list.m_nLength;
	DNode* buf;
	buf = list.headNode;
	while (1) {
		
		Insert(buf->data);
		if (buf == list.tailNode) {
			break;
		}
		buf = buf->back;
		
	}
	return 1;
}

void CMyList::PrintData() const{ // head print
	DNode* buf = gethead();
	int count = 0;
	if (getLength() == 0) {
		cout << "출력할 데이터가 없습니다.";
		return;
	}
	if (buf != NULL) {
		cout << "CMyList 데이터 : [Head] ";
		cout << buf->data;
		buf = buf->back;
		count = 1;
	}
	while (buf != NULL) {
		cout << " - " << buf->data;
		buf = buf->back;
		count++;
	}
	cout << " [Tail]\n";
	cout << "데이터 개수 : " << getLength() << "개\n";

}

void CMyList::showmenu(){
	cout << "----------------------\n";
	cout << "CMyList 메뉴\n";
	cout << "1 삽입\n2 출력\n0 종료\n";
	cout << "----------------------\n";
	cout << "메뉴를 고르세요 : ";
}
