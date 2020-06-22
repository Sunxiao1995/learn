//
//  main.c
//  0330
//
//  Created by 孙孝 on 2020/3/30.
//  Copyright © 2020 sx. All rights reserved.
//

// 练习1 实现计算长方体体积的函数
/*
#include <stdio.h>

double cuboid (double length , double width , double height)
{
    double bulk;
    bulk = length * width * height ;
    return bulk ;
}

int main (void)
{
    double a , b , c ;
    do {
        printf("请输入长方体的长："); scanf ("%lf",  &a ) ;
        printf("请输入长方体的宽："); scanf ("%lf",  &b ) ;
        printf("请输入长方体的高："); scanf ("%lf",  &c ) ;
        if (a <= 0 || b <= 0 || c <= 0)
            printf("请输入正确的值！\n");
    }
    while (a <= 0 || b <= 0 || c <= 0);
    printf ("该长方体的体积为: %f\n" , cuboid(a , b , c ));
    return 0 ;
}
*/


// 练习2 实现计算第n项非波拉契数列的函数(n>=0)

/*
#include <stdio.h>
int fib (int n)
{
    int i , x=0 ;
    int j = 1 , k = 1 ;
    if (n == 1 || n == 2)
        return 1;
    for(i=3; i <= n ; i++)
    {
        x = j + k ;
        j = k ;
        k = x ;
    }
    return x;
}

int main (void)
{
    int n;
    do
    {
        printf("请输入求斐波拉契数列第几项的值："); scanf ("%d",  &n ) ;
        if(n <= 0)
            printf("请重新输入！\n");
    }
    while (n <= 0);
    printf("第%d项斐波拉契数列的函数值为%d\n",n , fib (n));
    return 0 ;
}
*/

// 第三题 实现计算三个数中最大值的函数

#include <stdio.h>
int max(int a , int b , int c )
{
    int max = a;
    if (b > max ) max = b;
    return  ( max > c) ? max : c ;
}
int main (void)
{
    int a, b, c ;
    printf("请输入a,b,c值：");
    scanf("%d%d%d",&a,&b,&c);
    printf("a,b,c的最大值为%d\n", max (a,b,c));
    return 0 ;
}
