#include <stdio.h>
#include "HomeWork_02.h"

int Sort_Rule(Ldata x, Ldata y) {
    if (x->S <= y->S)
        return 1;
    else return 0;
}

int main()
{
    List list;
    Ldata newnode; 
    FILE* fp;
    fp = fopen("Data.txt", "r");
    InitList(&list);
    list.comp = Sort_Rule;
    if (fp == NULL) {
        printf("파일 열기 실패");
        return 0;
    }
    while(1){
        newnode = (Ldata)malloc(sizeof(Node));
        if (fscanf(fp, " %c %d %d %d %d", &newnode->N, &newnode->K, &newnode->E, &newnode->M, &newnode->C) == EOF) { // END OF FILE
            free(newnode);
            break;
        }
        newnode->S = newnode->K + newnode->E + newnode->M + newnode->C;
        LInsert(&list, newnode);
    }
    LPrint(&list);
    Rank(&list);
    LPrint(&list);
    Tie_delete(&list);
    LPrint(&list);
    return 0;
}
