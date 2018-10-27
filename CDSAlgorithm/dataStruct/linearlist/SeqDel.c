#include <stdio.h>

// 删除元素
// 这里给出的是根据元素进行删除


#define MAX_SIZE 20
#define OK 1
#define ERR 0

typedef struct {
    int elem[MAX_SIZE];
    int last;
} SeqList;

// 函数头
int deleteList(SeqList *sl, int e);

void foreach(SeqList sl);

int deleteList2(SeqList *sl, int e);

void main() {
    SeqList sl = {{2, 3, 4, 5, 6}, 5};
    // deleteList(&sl, 3);
    deleteList2(&sl, 3);
    foreach(sl);
}

// 这个是错误的，因为只能删除一次
// 算法思路：遍历数组，找到要删除的地方，然后删除之。删除后将数组后面的数据往前移动一个单位
int deleteList(SeqList *sl, int e) {
    for (int i = 0; i < sl->last; i++) {

        if (e == sl->elem[i]) {
            for (i; i < sl->last - 1; i++) {
                sl->elem[i] = sl->elem[i + 1];
            }
            sl->last = sl->last - 1;
            return OK;
        }
    }
    printf("元素%d不存在！", e);
    return ERR;
}

// 正确的删除思路，可以一次删除多个
// 不管有多少个都会被干掉
// 循环遍历数组，如果当前位置不是要删除的元素，就自己覆盖自己
// 如果是要删除的元素，就用下一个元素，覆盖当前元素
int deleteList2(SeqList *sl, int e) {
    int j = 0;
    int oldLast = sl->last;

    for (int i = 0; i < oldLast; i++) {
        // 只要不相等就覆盖当前的
        if (sl->elem[i] != e) {
            sl->elem[j] = sl->elem[i];
            j++;
        } else {
            sl->last--;    // 实现表尾指针的更新
        }

    }
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