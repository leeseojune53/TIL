#pragma once
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct _node {
	char N;
	int K, E, M, C, S, R;
	struct _node* Next;
} Node;

typedef Node* Ldata;

typedef struct _list {
	Ldata Head;
	Ldata Cur;
	Ldata Before;
	int NumOfData;
	int (*comp)(Ldata, Ldata);
} LinkedList;

typedef LinkedList List;

//리스트의 초기화
void InitList(List*);

//자료 삽입
void LInsert(List*, Ldata);

//첫 자료가 있는가?
int LFirst(List*, Ldata);

//다음 자료가 있는가?
int LNext(List*, Ldata);

//자료 삭제
Ldata LRemove(List*);

//리스트 자료의 출력
void LPrint(List*);

//리스트 자료의 개수 반환
int LCount(List*);

//정렬 규칙 설정
void SetSortRule(List*, int (*comp)(Ldata, Ldata));

//랭킹 메기기
void Rank(List* list);

//동점자 제거
void Tie_delete(List* list);