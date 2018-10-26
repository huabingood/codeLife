# include <stdio.h>

// 题目要求
// 要将"China"译成密码，译码规律是：用原来字母后面的第4个字母代替原来的字母．
// 例如，字母"A"后面第4个字母是"E"．"E"代替"A"。因此，"China"应译为"Glmre"。
// 请编一程序，用赋初值的方法使cl、c2、c3、c4、c5五个变量的值分别为，’C’、’h’、’i’、’n’、’a’，
// 经过运算，使c1、c2、c3、c4、c5分别变为’G’、’l’、’m’、’r’、’e’，并输出。

# define SIZE 5


// 大写的A是65，小写的a是97



int main(){
/*    char c1,c2,c3,c4,c5;
    scanf("%c%c%c%c%c",&c1,&c2,&c3,&c4,&c5);

    c1 = c1 + 4;

    printf("%d",'A');
    printf("%d",'Z');
    printf("%c%c%c%c%c\n",c1,c2,c3,c4,c5);

    return 1;*/

    char c[SIZE];
    scanf("%c%c%c%c%c",&c[0],&c[1],&c[2],&c[3],&c[4]);

    int length = sizeof(c)/sizeof(char);

    for(int i=0;i<length;i++){
        // 这里应该加上大写以及小写的最后4位的判断
        if( (c[i]>='W' && c[i]<='Z') || (c[i]>='w' && c[i]<='z') ){
            c[i]=c[i]+4-26;
        }else{
            c[i]=c[i]+4;
        }


        if(i==length-1){
            printf("%c\n",c[i]);
        }else{
            printf("%c",c[i]);
        }
    }

    return 1;
}