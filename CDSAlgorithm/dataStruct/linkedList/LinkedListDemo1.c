#include <stdio.h>
#include <stdlib.h>


#define ElemType int
#define OK 1
#define ERR 0




// 这个算是使用typedef的定义
// 这里声明的并不是链表，而是链表的一个节点
typedef struct Nodex{
    ElemType data;    // 这里的ElemType可以理解为元素类型的统称。我们通过宏定义进行替换为具体的值
    struct Nodex *next;    // 这里是自引用，实际上代表的是指向下一个结构体的指针
}Node,*LinkedList;  // 这里是别名，LinkedList是Node的别名，*next是 struce Node *next的别名

// 这个是最简单话的定义
// 我没有试过成不成，反正推理就是这样的
// 使用typedef进行定义，可以省掉在声明结构体过程中的struct关键字
struct myNode{
    ElemType data;
    struct myNode *node;
};


// 函数头
void linkedListInit();
LinkedList createLinkedListUseHead();
void foreach(LinkedList l);


void main(){
    // 创建一个单链表
    LinkedList linkedList;

    // 使用头插法创建链表
    linkedList = createLinkedListUseHead();

    // 遍历输出
    foreach(linkedList);
}



// 头插法创建链表
LinkedList createLinkedListUseHead(){
    // 初始化一个链表头
    Node *l;
    l = (Node *)malloc(sizeof(Node));
    l->next = NULL;

    char c;
    int flag = 1;
    while(flag){
        c=getchar();
        if(c!='$'){
            Node *nextNode;
            nextNode = (Node *)malloc(sizeof(Node));
            nextNode->data=c;
            nextNode->next = l->next;
            l->next = nextNode;
        }else{
            flag=0;
        }
    }
    return l;
}

// 遍历输出
void foreach(LinkedList l){
    while(l->next!=NULL){
        printf("%c",l->data);
    }
}






// 单链表的初始化。遗憾的是我至今不知道怎么使用这个函数
void linkedListInit(){
    Node *head;
    head = (Node*)malloc(sizeof(Node));  // 申请一个数据类型为LinkedList的内存地址空间，并将该空间的地址返回给指针

    // 没有申请大空间就排除异常退出
    if(head==NULL){
        printf("没有申请到空间。\n");
        exit(0);
    }
    // 第一个指针为空
    head->next = NULL;

}