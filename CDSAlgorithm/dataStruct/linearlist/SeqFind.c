#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 20

// 需求：
// 线性表查找之：按序号查找。
// 表中的元素是顺序存放的，故核心语句应该是l.elem[i-1]


// 定义一个顺序表
// 应该定义在外面，否则函数头声明访问不到
typedef struct{
    int elem[MAX_SIZE];
    int last;
} SeqList;


// 函数头声明
int getData(SeqList sl,int i);

void main(){

    int i;
    printf("请输入要查询元素的下标：");
    scanf("%d",&i);

    // 初始化并赋值
    SeqList sl = {{1,2,3,4,5},4};

    // 按照序号查找数组中的元素
    int a = getData(sl,i);
    printf("第%d个元素是：%d\n",i,a);
}

// 按照序号进行查找：getData(l,i),查找线性表中的第i个元素.
int getData(SeqList sl,int i){
    // 应该对数组是否越剧进行判断
    if(i<=0 || i>sl.last){
        printf("顺序表越界!\n");
        exit(0);
    }

    return sl.elem[i-1];
}