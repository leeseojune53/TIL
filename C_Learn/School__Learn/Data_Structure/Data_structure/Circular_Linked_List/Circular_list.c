#include "Circular_list.h"

void list_init(list* plist) {
	plist->tail = NULL;
	plist->cur = NULL;
	plist->before = NULL;
	plist->numOfdata = 0;
}

void list_insert_tail(list* plist, LData data) {
	node* newnode = malloc(sizeof(node));
	newnode->data = data;

	if (plist->tail == NULL) {
		plist->tail = newnode;
		newnode->next = newnode;
	}
	else {
		newnode->next = plist->tail->next;
		plist->tail->next = newnode;
		plist->tail = newnode;
	}

	(plist->numOfdata)++;
}

void list_insert_head(list* plist, LData data) {
	node* newnode = malloc(sizeof(node));
	newnode->data = data;

	if (plist->tail == NULL) {
		plist->tail = newnode;
		newnode->next = newnode;
	}
	else {
		newnode->next = plist->tail->next;
		plist->tail->next = newnode;
	}


	(plist->numOfdata)++;
}

int LFirst(list* plist, LData* data) {
	if (plist->tail == NULL)
		return 0;

	plist->before = plist->tail;
	plist->cur = plist->tail->next;

	*data = plist->cur->data;
	return 1;
}

int LNext(list* plist, LData* data) {
	if (plist->tail == NULL) {
		return 0;
	}

	plist->before = plist->cur;
	plist->cur = plist->cur->next;

	*data = plist->cur->data;
	return 1;
}

LData LRemove(list* plist) {
	node* rpos = plist->cur;
	LData data = rpos->data;

	if (rpos == plist->tail) {
		if (plist->tail == plist->tail->next) {
			plist->tail = NULL;
		}
		else
			plist->tail = plist->before;
	}

	plist->before->next = rpos->next;
	plist->cur = plist->before;

	free(rpos);
	(plist->numOfdata)--;
	return data;
}

void printList(list* plist) {
	LData data;
	if (!LFirst(plist, &data))
		return;
		

	for (int i = 0; i < plist->numOfdata; i++) {
		printf("%d ", data);
		LNext(plist, &data);
	}
	printf("\n출력완료\n");
}

void freeList(list* plist) {
	int buf;
	int size = plist->numOfdata;
	if (!LFirst(plist, &buf))
		return;
	for(int i = 0; i < size ; i++) {
		LRemove(plist);
		LNext(plist, &buf);
		
	}
	printf("freelist완료");
}