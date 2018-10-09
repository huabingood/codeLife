#include <stdio.h>

void main(){
    /*
    * 定义一个结构体
    * 使用typedef 关键字，将student的别名设置为了STUDENT
    * 这样的话在声明结构体时就可以省掉一个struct关键字*/
    typedef struct student{
        int age=10;
        char name[10];
    }STUDENT;

    // 声明一个结构体
    STUDENT st1={1,{'h','u','a','b','i','n'}};

}