#include <stdio.h>

// 删除元素
// 这里给出的是根据元素进行删除


#define MAX_SIZE 20
#define OK 1
#define ERR 0

typedef struct{
    int elem[MAX_SIZE];
    int last;
} SeqList;

// 函数头
int deleteList(SeqList *sl,int e);
void foreach(SeqList sl);

void main(){
    SeqList sl = {{2,3,4,5,6},5};
    deleteList(&sl,3);
    foreach(sl);
}

//
int deleteList(SeqList *sl,int e){
    for(int i=0;i<sl->last;i++){

        if(e == sl->elem[i]){
            for(i;i<sl->last-1;i++){
                if(e==sl->last-2){
                    sl->last=sl->last-1;
                }
                sl->elem[i]=sl->elem[i+1];
            }
            return OK;
        }else{
            printf("元素%d不存在！",e);
            return ERR;
        }
    }
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