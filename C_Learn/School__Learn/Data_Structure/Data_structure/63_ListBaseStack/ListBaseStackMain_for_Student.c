#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include "ListBaseStack.h"

printMenu()
{
	printf("\n\n+++++++++++++++++++++++++++++\n");
	printf("\t1 - 삽입 \n");
	printf("\t2 - 삭제 \n");
	printf("\t3 - 출력 \n");
	printf("\tq - 프로그램 종료 \n");
	printf("+++++++++++++++++++++++++++++\n");
	printf("메뉴를 선택하세요. >> \n");
}

void printStack(Stack* s)
{
	// 직접 구현해보기
}
void freeStack(Stack* s)
{
	// 직접 구현해보기
}
int main(void)
{
	// Stack의 생성 및 초기화 ///////
	Stack stack;
	StackInit(&stack);
	Data value;
	char menu = '1';	// Default 

	while (1) {
		printMenu();
		scanf(" %c", &menu);

		switch (menu)
		{
		case '1':		// Push 
			printf("스택에 삽입할 데이타를 입력하시오. \n");
			scanf("%d", &value);
			SPush(&stack, value);
			break;

		case '2':		// Pop
			value = SPop(&stack);
			printStack(&stack);
			break;

		case '3':		//Print
			printStack(&stack);
			break;

		case 'q':		// 종료
			freeStack(&stack);
			return -1;

		default:		// 예외처리
			printf("없는 메뉴입니다. 메뉴를 다시 선택하세요! \n");
			break;
		}
	}

	return 0;
}