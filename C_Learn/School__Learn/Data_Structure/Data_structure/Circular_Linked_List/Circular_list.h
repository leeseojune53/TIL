#pragma once
#include <stdio.h>
#include <stdlib.h>

typedef int LData;

typedef struct _node {
	LData data;
	struct _node* next;
}node;

typedef struct _list {
	node* tail;
	node* cur;
	node* before;
	int numOfdata;
}list;


//리스트 초기화
void list_init(list*);

void list_insert_tail(list*, LData);

void list_insert_head(list*, LData);

int LFirst(list*, LData*);

int LNext(list*, LData*);

LData LRemove(list*);

void printList(list*);

void freeList(list*);