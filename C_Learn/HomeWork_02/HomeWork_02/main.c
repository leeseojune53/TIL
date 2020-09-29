#include <stdio.h>
#include "HomeWork_02.h"

int Sort_Rule(Ldata x, Ldata y) {
    if (x->S >= y->S)
        return 1;
    else return 0;
}

int main()
{
    List list;
    InitList(&list);
    list.comp = Sort_Rule;
    printf("1");
    return 0;
}
