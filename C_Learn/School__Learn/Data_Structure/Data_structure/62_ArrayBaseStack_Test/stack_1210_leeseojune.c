#include <stdio.h>
#define SIZE 5

void Stack_Push(int* Stack, int* cnt); rint(Stack, cnt);

void Stack_Pop(int* Stack, int* cnt);

void Stack_Print(int* Stack, int* cnt);

void printMenu()
{
    printf("\n\n+++++++++++++++++++++++++++++\n");
    printf("\t1 - 삽입 \n");
    printf("\t2 - 삭제 \n");
    printf("\t3 - 출력 \n");
    printf("\tq - 프로그램 종료 \n");
    printf("+++++++++++++++++++++++++++++\n");
    printf("메뉴를 선택하세요. >> \n");
}

int main()
{
    int cnt = -1;
    int input;
    int Stack[SIZE];
    do{
        printMenu();
        scanf("%d", &input);
        switch (input)
        {
        case 1:
            Stack_Push(Stack, &cnt);
            break;
        case 2:
            Stack_Pop(Stack, &cnt);
            break;
        case 3:
            Stack_Print(Stack, &cnt);
            break;
        default:
            printf("없는 메뉴입니다. 메뉴를 다시 선택하세요!");
            break;
        }
    } while (getchar() != 'q');

    return 0;
}

void Stack_Push(int* Stack, int* cnt) {
    if (*cnt+1 >= SIZE) {
        printf("stack overflow\n");
        return;
    }
    int buf;
    scanf("%d", &buf);
    Stack[++(*cnt)] = buf;
    Stack_Print(Stack, cnt);
}

void Stack_Pop(int* Stack, int* cnt) {
    if (*cnt+1 <= 0) {
        printf("stack underflow\n");
        return;
    }
    printf("[%d] 데이타가 삭제되었습니다.", Stack[*cnt]);
    (*cnt)--;
    Stack_Print(Stack, cnt);
}

void Stack_Print(int* Stack, int* cnt) {
    if (*cnt+1 <= 0)
        return;
    printf("\t\t[STACK DATA]\t");
    for (int i = 0; i < *cnt+1; i++) {
        printf("%d ", Stack[i]);
    }
}