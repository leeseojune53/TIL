#include "Circular_list.h"

int main()
{
    list plist;

    list_init(&plist);

    list_insert_tail(&plist, 10);
    list_insert_tail(&plist, 11);
    list_insert_tail(&plist, 12);
    list_insert_head(&plist, 9);

    printList(&plist);

    freeList(&plist);

    printList(&plist);
    return 0;
}
