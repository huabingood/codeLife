#include <stdio.h>

/*任务
* 各种输出的测试
*/

main(){
    double d = 3.141592657;
    printf("直接输出：%f\n",d);
    printf("带域宽的值：%3f\n",d);
    printf("输出带小数点的值：%.2f\n",d);
    printf("输出带域宽和小数的值：%1.2f\n",d);

    printf("%f\n",d);
    printf("%3f\n",d);
    printf("%.2f\n",d);
    printf("%11.2f\n",d);   // 域宽主要用来对齐，而不是控制数据长度的K

}