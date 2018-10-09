#include <stdio.h>

struct student{
    int age;
    int class;
    int score[3];
};

void main(){
    // 初始化并赋值方式之一：
    struct student stu1;
    stu1.age=10;
    stu1.class=1;
    // stu1.socre[] = {11,22,33};  // 这种赋值错误的，反正我也不知道为什么
    stu1.score[0]=11;
    stu1.score[1]=22;
    stu1.score[2]=33;

    // 初始化并赋值方式之二
    /* struct student stu2;
    stu2 = {10,1,{11,22,33}}; // 这种赋值方式是错误的 */

    struct student stu2 ={10,1,{11,22,33}};

    printf("This is content of student struct:\n");
    printf("student age is : %d\n",stu1.age);
    for(int i=0;i<3;i++){
        printf("student's score:%d\n",stu1.score[i]);
    }
}