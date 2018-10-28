#include <stdio.h>
#include <stdlib.h>


#define ElemType int

// 这个算是使用typedef的定义
typedef struct Node{
    ElemType data;    // 这里的ElemType可以理解为元素类型的统称。我们通过宏定义进行替换为具体的值
    struct Node *next;    // 这里是自引用，实际上代表的是指向下一个结构体的指针
}LinkedList,*next;  // 这里是别名，LinkedList是Node的别名，*next是 struce Node *next的别名

// 这个是最简单话的定义
// 我没有试过成不成，反正推理就是这样的
// 使用typedef进行定义，可以省掉在声明结构体过程中的struct关键字
struct myNode{
    ElemType data;
    struct myNode *node;
};


// 但链表的初始化
LinkedList linkedListInit(){
    LinkedList *linkedList;
    linkedList = (LinkedList*)malloc(sizeof(LinkedList));  // 申请一个数据类型为LinkedList的内存地址空间，并将该空间的地址返回给指针

    // 没有申请大空间就排除异常退出
    if(linkedList==NULL){
        printf("没有申请到空间。\n");
        exit(0);
    }
    // 第一个指针为空
    linkedList->next = NULL;

    return *linkedList;
}

void main(){
    printf("测试用例");
}
