# include <stdio.h>


# define MAX_SIZE 20
#define ElemType int     // 这里使用宏定义，可以使抽象的数据具体化
// 顺序表 sequence table : SeqList


void main(){
    // 定义一个int数组为结构顺序表
    // 需要两个内容：数组，数据最大的实际位置
    typedef struct{
        ElemType elem[MAX_SIZE];     // 这里的数组可以是任何类型的，这里以int数组举例
        int last;               // 表示顺序表的实际位置
    } SeqList;


}

// 结构体的访问
// 1.通过变量定义语句
//     SeqList l;
// 将l定义为SeqList类型的变量，利用l.elem[i-1]来访问顺序表中序号为i的元素；通过l.last 来得到最后一个
// 元素的下标，而l.last+1 就是顺序表的长度。
// 2.通过指针变量定义语句
//     SeqList *l;
// 将l定义为指向SeqList的指针变量，通过l->elem[i-1]来访问顺序表中的序号为i的元素；通过l->last+1得到
// 顺序表的长度。