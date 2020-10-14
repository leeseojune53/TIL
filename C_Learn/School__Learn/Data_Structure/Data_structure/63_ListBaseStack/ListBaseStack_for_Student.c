#include <stdio.h>
#include <stdlib.h>
#include "ListBaseStack.h"

void StackInit(Stack * pstack)
{
	pstack->head = NULL;
}

int SIsEmpty(Stack * pstack)
{
	return (pstack->head == NULL);
}

void SPush(Stack * pstack, Data data)
{
	Node* newnode = malloc(sizeof(Node));
	newnode->data = data;
	newnode->next = pstack->head->next;
	pstack->head = newnode;
}

Data SPop(Stack * pstack)
{
	Data data = pstack->head->data;
	Node* rpos = pstack->head;
	pstack->head = pstack->head->next;
	free(rpos);
	return data;
}

Data SPeek(Stack * pstack)
{
	//직접 구현해보기
}