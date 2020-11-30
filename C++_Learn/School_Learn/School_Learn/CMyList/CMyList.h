#pragma once

struct DNode
{
	int data;
	DNode* link;
};

class CMyList {
public:
	CMyList() {};
	~CMyList();
	void Insert(int num);
	void PrintData();
	int isOverlap(int num);
private:
	DNode* headNode = nullptr;
	DNode* tailNode = nullptr;
	int m_nLength = 0;
};