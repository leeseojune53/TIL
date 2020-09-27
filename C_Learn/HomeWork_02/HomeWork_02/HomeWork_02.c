#include "HomeWork_02.h"

void InitList(List* list) {
	list->Head = (Node*)malloc(sizeof(Node));
	list->Head->Next = NULL;
	list->Cur = list->Before = NULL;
	list->NumOfData = 0;
	list->comp = NULL;
}

void LInsert(List* list, Ldata node) {
	Node* Newnode = node;
	Node* Pred = list->Head;
	
	while (Pred->Next != NULL && list->comp(node, Pred->Next)) {
		Pred = Pred->Next;
	}
	Newnode->Next = Pred->Next;
	Pred->Next = Newnode;

	(list->NumOfData)++;
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
	Node* rpos = list->Cur;
	Ldata rdata = rpos;

	list->Before->Next = list->Cur->Next;
	list->Cur = list->Before;
	free(rpos);
	(list->NumOfData)--;
	return rdata;
}

void LPrint(List* list) {
	list->Cur = list->Head->Next;
	if (list->Cur == NULL)
		return;
	printf("-----------------------------\nName Kor Eng Mat Com Sum Rnk\n-----------------------------");
	while (list->Cur != NULL) {
		printf("%c %d %d %d %d %d %d", list->Cur->N, list->Cur->K, list->Cur->E, list->Cur->M, list->Cur->C, list->Cur->S, list->Cur->R);
		list->Cur = list->Cur->Next;
	}
}

int LCount(List* list) {
	return list->NumOfData;
}

void SetSortRule(List* list, int (*comp)(Ldata, Ldata)) {
	list->comp = comp;
}

