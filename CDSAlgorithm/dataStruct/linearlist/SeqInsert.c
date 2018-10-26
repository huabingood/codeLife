#include <stdio.h>

// 插入操作
// 是顺序表的节点的物理位置必须和逻辑位置保持一致
// 在插入的过程中，要将插入后的所有数据集体向后移动一位，以保持整体完整性
// 要注意：这里应该传入数组指针，而不是数组，因为C中的数组是值传递，不像java中是会直接修改值
// 算法的复杂度是：O((n-1)/2)

#define MAX_SIZE 20
#define OK 1
#define ERR 0

// 定义结构体
typedef struct{
    int elem[MAX_SIZE];
    int last;
} SeqList;

// 函数头
int insertList(SeqList sl,int e,int index);
void foreach(SeqList sl);
int insertList2(SeqList *sl,int e,int index);

void main(){
    // 初始化结构体
    SeqList sl = {{2,4,6,8,10},5};
    //int res = insertList(sl,3,2);
    int res = insertList2(&sl,3,2);
    printf("插入数据的返回值是：%d\n",res);
    foreach(sl);
}

// 这个是错误的，好像sl变成了引用传递。
int insertList(SeqList sl,int e,int index){
    // 数组越界
    if( index>=sl.last || index<0 ){
        printf("插入数据的位置不合法\n");
        return ERR;
    }
    if(sl.last>=MAX_SIZE-1){
        printf("数组的空间不够\n");
        return ERR;
    }

    int i = sl.last;
    while( i > (index-1) ){
        sl.elem[i] = sl.elem[i-1];
        i--;
    }

    if(i==(index-1)){
        sl.elem[i]=e;
        sl.last=sl.last+1;
        return OK;
    }

    return ERR;
}

// 遍历输出顺序表中的内容
void foreach(SeqList sl){
    printf("所有的数据是：{");

    for(int i=0;i<sl.last;i++){
        if(i==(sl.last-1)){
            printf("%d}\n",sl.elem[i]);
        }
        printf("%d,",sl.elem[i]);
    }
}

// 算法思想：
// 从数组最后开始遍历，将数据逐个往后移动，移动到给定的位置后，添加元素，并更新指针
int insertList2(SeqList *sl,int e,int index){
    // 数组越界
    if( index>=sl->last || index<0 ){
        printf("插入数据的位置不合法\n");
        return ERR;
    }
    if(sl->last>=MAX_SIZE-1){
        printf("数组的空间不够\n");
        return ERR;
    }
    // 从最后开始遍历数组，如果没有到给定的位置，就逐个的往后移动
    int i = sl->last;
    while( i > (index-1) ){
        sl->elem[i] = sl->elem[i-1];
        i--;
    }
    // 如果到了指定的位置，就添加，并且更新last指针的值
    if(i==(index-1)){
        sl->elem[i]=e;
        sl->last=sl->last+1;
        return OK;
    }

    return ERR;
}
