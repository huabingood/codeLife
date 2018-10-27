#include <stdio.h>

#define ElemType int
#define MAX_SIZE 20
#define OK 1
#define ERR 0

// 定义结构体
typedef struct {
    ElemType elem[MAX_SIZE];
    int last;
} SeqList;

// 函数头
void foreach(SeqList sl);
int mergeList(SeqList *l1, SeqList *l2, SeqList *l3);


void main() {
    SeqList l1 = {{1, 3, 4, 5}, 4};
    SeqList l2 = {{2, 6, 8, 10, 11}, 5};
    SeqList l3;

    mergeList(&l1, &l2, &l3);
    foreach(l3);


}

// 合并顺序表
// 比较逐个遍历a，b表，当前位置谁小就把谁写入c表中。大的放到下一轮比较中
// 最后逐个将还有数据的表写入到c表中
int mergeList(SeqList *l1, SeqList *l2, SeqList *l3) {
    int i, j, k;
    i = 0;
    j = 0;
    k = 0;

    while (i < l1->last && j < l2->last) {
        if (l1->elem[i] <= l2->elem[j]) {
            l3->elem[k] = l1->elem[i];
            j--;
        } else {
            l3->elem[k] = l2->elem[j];
            i--;
        }
        i++;
        j++;
        k++;
    }

    while (i < l1->last) {
        l3->elem[k] = l1->elem[i];
        i++;
        k++;
    }

    while (j < l1->last) {
        l3->elem[k] = l2->elem[j];
        j++;
        k++;
    }

    l3->last = l2->last + l1->last - 1;

}


// 遍历输出顺序表中的内容
void foreach(SeqList sl) {
    printf("所有的数据是：{");

    for (int i = 0; i < sl.last; i++) {
        if (i == (sl.last - 1)) {
            printf("%d}\n", sl.elem[i]);
        }
        printf("%d,", sl.elem[i]);
    }
}