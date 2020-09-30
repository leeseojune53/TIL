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
    InitList(&list);
    list.comp = Sort_Rule;
    for (int i = 0; i < 10; i++) {
        newnode = (Node*)malloc(sizeof(Node));
        scanf(" %c %d %d %d %d", &newnode->N, &newnode->K, &newnode->E, &newnode->M, &newnode->C);
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
