#pragma once

struct DNode
{
	int data;
	DNode* front;
	DNode* back;
};

class CMyList {
public:
	CMyList() { m_nLength = 0; };
	~CMyList();
	virtual void Insert(int num);
	virtual void PrintData();
	virtual int isOverlap(int num);
	DNode* gethead();
	void sethead(DNode* head);
	DNode* gettail();
	void settail(DNode* tail);
	int getLength();
	void setLength(int Length);
private:
	DNode* headNode = nullptr;
	DNode* tailNode = nullptr;
	static int m_nLength;
};

class CMyListEx : public CMyList{
public:
	void Insert(int num);
	void PrintData();
	int isOverlap(int num);
	void InsertHead(int num);
	void DeleteHead();
	void DeleteTail();
	void PrintDataTail();
private:
};