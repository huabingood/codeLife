#include <stdio.h>

main(){
    // int *p = 10;    // *p 接收的只能是地址
    int a = 10;
    // int *p = a; // 这句话是错误的。
    int *p = NULL;
    p = &a;
    printf("p is %d\n",p);
    printf("*p is %d\n",*p);
    printf("&p is %d\n",&p);
}