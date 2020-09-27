#include "HomeWork_02.h"

void InitList(List* list) {
	list->Head = (Ldata*)malloc(sizeof(Ldata));
	list->Head->Next = NULL;
	list->Cur = list->Before = NULL;
	list->NumOfData = 0;
	list->comp = NULL;
}

void LInsert(List* list, Ldata node) {

}

int LFirst(List* list, Ldata* node) {
	if (list->Head->Next == NULL) {
		return FALSE; //첫 자료가 없을때
	}
	list->Before = list->Head;
	list->Cur = list->Head->Next;
	*node = list->Cur;
	return TRUE; //첫 자료가 있을때
}

int LNext(List* list, Ldata* node) {
	if (list->Cur->Next == NULL)
		return FALSE;

	list->Before = list->Cur;
	list->Cur = list->Cur->Next;

	*node = list->Cur;
	return TRUE;
}

Ldata LRemove(List* list) {

}

void LPrint(List* list) {

}

int LCount(List* list) {
	return list->NumOfData;
}

void SetSortRule(List* list, int (*comp)(Ldata, Ldata)) {

}

