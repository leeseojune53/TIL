#include <stdio.h>
#include <stdlib.h>
#include "CircularQueue.h"

void QueueInit(Queue * pq)
{
	pq->front = 0;
	pq->rear = 0;
}

int QIsEmpty(Queue * pq)
{
	if (pq->front == pq->rear)
		return 1;
	return 0;
}

int NextPosIdx(int pos)
{
	if (pos == QUE_LEN - 1)
		return 0;

	return pos + 1;
}

void Enqueue(Queue * pq, Data data)
{
	if (NextPosIdx(pq->rear) == pq->front) {
		printf("queue is full\n");
		return;
	}
	pq->rear = NextPosIdx(pq->rear);
	pq->queArr[pq->rear] = data;
}

Data Dequeue(Queue * pq)
{
	if (QIsEmpty(pq)) {
		printf("queue is empty\n");
		return 0;
	}
	pq->front = NextPosIdx(pq->front);
	return pq->queArr[pq->front];
}

Data QPeek(Queue * pq)
{
	if (QIsEmpty(pq)) {
		printf("queue is empty\n");
		exit(-1);
	}
	return pq->queArr[NextPosIdx(pq->front)];
}