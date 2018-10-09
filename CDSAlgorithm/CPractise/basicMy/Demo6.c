#include <stdio.h>

 void swap(int *a,int *b);

 /*
 * 使用指针交换用户输入的两个数据
 */

 void main() {
     int a,b;
     printf("Please type two number value of a,b:\n");
     scanf("%d,%d",&a,&b);
     printf("before swap,the value of a is %d,the value of b is %d.\n",a,b);
     swap(&a,&b);
     printf("after swap,the value of a is %d,the value of b is %d.\n",a,b);
 }

 /*
 * 始终不是很明白为什么这里使用int middle 来接收指针*/
 void swap(int *a,int *b) {
     int middle ;
     middle = *a;
     printf("%d",*middle);
     *a = *b;
     *b = middle;

 }