# include <stdio.h>

main(){
    const double PI = 3.14;
    double r;

    printf("please input r:");
    scanf("%lf",&r);

    printf("circumference = %f\n",2*PI*r);
}