#include "HomeWork_02.h"

void InitList(List* list) {
	list->Head = (Ldata)malloc(sizeof(Node));
	list->Head->Next = NULL;
	list->Cur = list->Before = NULL;
	list->NumOfData = 0;
	list->comp = NULL;
}

void LInsert(List* list, Ldata node) { // Ldata = Node*
	
	Ldata Newnode = node;
	Ldata Pred = list->Head;

	

	node->R = 1;

	while (Pred->Next != NULL && list->comp(node, Pred->Next)) {
		if (node->S == Pred->Next->S && node->N < Pred->Next->N)
			break;
		Pred = Pred->Next;
	}
	Newnode->Next = Pred->Next;
	Pred->Next = Newnode;

	(list->NumOfData)++;
}

int LFirst(List* list, Ldata node) { 
	if (list->Head->Next == NULL) {
		return FALSE; //첫 자료가 없을때
	}
	list->Before = list->Head;
	list->Cur = list->Head->Next;
	*node = *list->Cur;
	return TRUE; //첫 자료가 있을때
}

int LNext(List* list, Ldata node) {
	if (list->Cur->Next == NULL)
		return FALSE;

	list->Before = list->Cur;
	list->Cur = list->Cur->Next;
	*node = *list->Cur;
	return TRUE;
}

Ldata LRemove(List* list) {
	Ldata rpos = list->Cur;
	Ldata rdata = rpos;

	list->Before->Next = list->Cur->Next;
	list->Cur = list->Before;
	free(rpos);
	(list->NumOfData)--;
	return rdata;
}

void LPrint(List* list) {
	Node node;
	if (!LFirst(list, &node))
		return;
	LFirst(list, &node);
	printf("-----------------------------\nName Kor Eng Mat Com Sum Rnk\n-----------------------------\n");
	do {
		printf("%c   %3d %3d %3d %3d %3d  %2d\n", node.N, node.K, node.E, node.M, node.C, node.S, node.R);
	} while (LNext(list, &node));
}

int LCount(List* list) {
	return list->NumOfData;
}

void SetSortRule(List* list, int (*comp)(Ldata, Ldata)) {
	list->comp = comp;
}

void Rank(List* list) {
	list->Before = list->Head;
	list->Cur = list->Head->Next; // LFIRST
	for (int i = 0; i < LCount(list); i++) {
		if (list->Before->S == list->Cur->S)
			list->Cur->R = list->Before->R;
		else list->Cur->R = i + 1;
		list->Before = list->Cur;
		list->Cur = list->Cur->Next; // LNEXT
	}
}

void Tie_delete(List* list) {
	int count = LCount(list);
	list->Before = list->Head;
	list->Cur = list->Head->Next; // LFIRST
	for (int i = 0; i < count; i++) {
		if (list->Before->S == list->Cur->S)
			LRemove(list);
		list->Before = list->Cur;
		list->Cur = list->Cur->Next;//LNEXT
	}
}
