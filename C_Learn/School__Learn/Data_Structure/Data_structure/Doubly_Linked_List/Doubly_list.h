#pragma once
#include <stdio.h>
#include <stdlib.h>

typedef int LData;

typedef struct _node {
	LData data;
	struct _node* prev;
	struct _node* next;
}node;

typedef struct _list {
	node* head;
	node* cur;
	int numofdata;
}list;

void ListInit(list*);

void LInsert(list*, LData);

int LFirst(list*, LData*);

int LNext(list*, LData*);

int LPre(list*, LData*);

int LCount(list*);

LData LRemove(list*);