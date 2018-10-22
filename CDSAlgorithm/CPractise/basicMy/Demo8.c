# include <stdio.h>

/*输入两个整数a和b，计算a+b的和
注意此题是多组测试数据 */

// 我的解法
void main(){
    int a,b,c;
    while(1){
        scanf("%d%d",&a,&b);
        c = a + b;
        printf("%d\n",sizeof(c));
        printf("%d\n",sizeof(a+b));

        printf("%d\n",c);
    }
}


// 标准答案1
/*~在c中是按位取反的意思，当我们停止程序的时候，就是按ctrl+z的时候，
scanf返回的值是-1，-1按位取反就是0，在C中0表示假，1表示真（除了
Bash中0表示真以外，都表示假）然后程序就退出了*/
int method1()
{
    int a=0,b=0;
    while(~scanf("%d%d", &a, &b))   //下面有关于~的解析
    {
        printf("%d\n",a+b);
    }
    return 1;
}


// 标准答案2
/*利用scanf的返回值来对while的判断*/
int method2(){
    int a,b;
    while(scanf("%d%d") == 2){
        printf("%d\n",a+b);
    }
    return 1;
}