#include <stdio.h>

void main(){
    const LIST_INIT_SIZE=100;   // 表初始分配空间
    const LISTINCREACEMENT=10;  // 空间分配增量

    typedef struct{
        ELemType *elem; // 存储空间
        int length; // 当前长度
        int listSize;   // 当前存储容量
    }SqList;

}