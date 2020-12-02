#pragma once

#include "CMyList.h"

class CMyListEx : public CMyList{
public:
	CMyListEx(int Length) : CMyList(Length) {}
	CMyListEx(const CMyListEx& list);
	void Insert(int num);
	void InsertHead(int num);
	void DeleteHead();
	void DeleteTail();
	void PrintDataTail();
private:
};