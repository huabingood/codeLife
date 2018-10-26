# include <stdio.h>
# include <stdlib.h>

// 编写一个程序，输入a、b、c三个值，输出其中最大值。
// 关键点: 1.相等情况的判定 2.直接调用exit（）函数如何调用

void main(){
    int a,b,c,middle;
    scanf("%d%d%d",&a,&b,&c);

    // 判断是否有相等的情况存在
    if(a==b || a==c || b==c){
        exit(0);
    }

    // 比较大小
    if(a>b){
        middle=a;
    }else{
        middle=b;
    }
    if(middle<c){
        middle=c;
    }

    printf("%d\n",middle);
}