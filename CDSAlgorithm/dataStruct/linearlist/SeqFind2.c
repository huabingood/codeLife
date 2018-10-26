#include <stdio.h>

// 需求：
// 按照内容查找，要求查找顺序表L中给定的值e相等的元素

# define MAX_SIZE 10

// 定义一个顺序表
typedef struct{
    int elem[MAX_SIZE];
    int last;
} SeqList;

// 声明函数头
int locate(SeqList sl,int e);

void main(){
    int index,e;
    printf("请输入要查找的元素：");
    scanf("%d",&e);
    // 初始化顺序表
    SeqList sl = {{9,8,7,6,5,4},5};
    index = locate(sl,e);
    printf("你查找的元素%d在第%d的位置。\n",e,index);
}

// 算法思想：从第一个元素开始，一次将表中的元素与e相比较，若相等，则返回元素在表中的序号；
// 若找不到，返回-1
int locate(SeqList sl,int e){
    int i=0;
    // 逐个遍历数组，如果没有到末尾或者没有找到，就一直遍历
    while( i<=sl.last && sl.elem[i]!=e ){
        i++;
    }
    // 没有到末尾，且找到元素，就返回所在的位置
    if( i<sl.last && sl.elem[i]==e ){
        return i+1;
    }
    // 没有找到就返回-1
    return -1;
}
