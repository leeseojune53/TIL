#include <stdio.h>
#include "CircularQueue.h"

int main(void)
{
	// Queue의 생성 및 초기화 ///////
	Queue q;
	QueueInit(&q);

	// 데이터 넣기 ///////
	Enqueue(&q, 100);  
	Enqueue(&q, 200);
	Enqueue(&q, 300);
	printf("%d %d %d \n", Dequeue(&q), q.front, q.rear);
	printf("%d %d %d \n", Dequeue(&q), q.front, q.rear);
	printf("%d %d %d \n", Dequeue(&q), q.front, q.rear);
	Enqueue(&q, 400);
	Enqueue(&q, 500);
	Enqueue(&q, 600);
	Enqueue(&q, 700);


	// 데이터 꺼내기 ///////
	while(!QIsEmpty(&q))
		printf("%d ", Dequeue(&q)); 

	return 0;
}