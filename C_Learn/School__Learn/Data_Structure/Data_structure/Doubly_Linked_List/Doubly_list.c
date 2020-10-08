#include "Doubly_list.h"

void Initlist(list* plist) {
	plist->head = NULL;
	plist->numofdata = 0;
}

void LInsert(list* plist, LData data) {
	node* newnode = malloc(sizeof(node));
	newnode->data = data;

	newnode->next = plist->head;
	if (plist->head != NULL) {
		plist->head->prev = newnode;
	}

	newnode->prev = NULL;
	plist->head = newnode;
	(plist->numofdata)++;
}

int LFirst(list* plist, LData* data) {
	if (plist->head == NULL)
		return 0;
	plist->cur = plist->head;
	*data = plist->cur->data;
	return 1;
}

int LNext(list* plist, LData* data) {
	if (plist->cur->next != NULL)
		return 0;
	plist->cur = plist->cur->next;
	*data = plist->cur->data;
	return 1;
}

int LPre(list* plist, LData* data) {
	if (plist->cur->prev == NULL)
		return 0;

	plist->cur = plist->cur->prev;
	*data = plist->cur->data;
	return 1;
}

int LCount(list* plist) {
	return plist->numofdata;
}

LData LRemove(list* plist) {
	node* rpos = plist->cur;
	LData data = plist->cur->data;

	if (plist->cur->prev == NULL && plist->cur->next == NULL) {
		plist->head = NULL;
		plist->cur = plist->head;
		
	}
	else if (plist->cur->prev == NULL) {
		plist->cur->next->prev = plist->cur->prev;
		plist->head = plist->cur->next;
		plist->cur = plist->cur->next;
		
	}
	else if (plist->cur->next == NULL) {
		plist->cur->prev->next = plist->cur->next;
		plist->cur = plist->cur->prev;
	}
	else {
		plist->cur->next->prev = plist->cur->prev;
		plist->cur->prev->next = plist->cur->next;
		plist->cur = plist->cur->prev;
	}

	free(rpos);
	(plist->numofdata)--;
	return data;
}