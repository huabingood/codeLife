#include <stdio.h>

/*
 * 功能：练习getchar()和putchar()的使用
 * 实现输入小写字母，将小写字母转换成功大写字母
*/
main(){
    char a;
    printf("please input a word:");

    a = getchar();    // getchar不能接受参数，只能返回
    char b = a - 32;
    putchar(b);    // 输出转换成功的大写字母
    putchar('\n')   // putchar()只能输出一个字符。不能输出字符串

}