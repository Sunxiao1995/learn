//
//  main.c
//  测试
//
//  Created by 孙孝 on 2020/3/26.
//  Copyright © 2020 sx. All rights reserved.
//

//上午的思考题
#include <stdio.h>                 /* 编译预处理命令 */
int main(void)                         /* 主函数 */
{                                               /* 函数体开始*/
 int n;                                       /* 定义变量*/

    int factorial(int n);                /* 声明函数*/

    scanf("%d", &n);                     /* 输入一个整数 */
    printf("%d\n", factorial(n));  /* 计算，并输出*/
 
    return 0;                                 /* 返回语句 */
}

int factorial ( int n )             /* 函数头 */
{                                           /* 函数体开始*/
    int i;
    int fact = 1;                        /* 定义变量 fact */
    
    for(i = 1; i <= n; i++)       /* 循环 */
           fact = fact * i;                   /* 乘法 */
 return fact;                        /* 返回结果 */
 }
// 在n等于13的时候，此时的结果已经超出了int型的取值范围，int型占四个字节，
//且首位有正负之分 之后在乘后面的数就会有溢出。



//练习第一题
/*
#include <stdio.h>

int main(void)
{
    // 调用一次printf函数显示内容。
    printf("喂\n\n你好！\n再见。\n");
    return 0;
}
*/

//练习第二题
/*
 #include <stdio.h>

 int main(void)
 {
     int a,b ;      //声明两个整数型变量a b
     
     printf("请输入两个整数\n");
     
     printf("整数1:"); scanf("%d", &a);               //从键盘读取输入的十进制数，并保存到a中
     
     printf("整数2:"); scanf("%d", &b);               //从键盘读取输入的十进制数，并保存到a中
     
     printf("他们的乘积是%d;\n", a * b);          //打印结果
     return 0;
 }
 */


//练习第三题
/*
 #include <stdio.h>

 int main (void)
 {
     int a,b,c ;  //定义三个整型变量a,b,c
     
     printf("请输入三个整数。\n");
     
     printf("整数1:");scanf("%d", &a);         //将屏幕读取的十进制数保存在a中
     
     printf("整数2:");scanf("%d", &b);         //将屏幕读取的十进制数保存在b中
     
     printf("整数3:");scanf("%d", &c);         //将屏幕读取的十进制数保存在c中
     
     printf("它们的和是%d。\n",a+b+c);  //求输入的三个值的和
     
     return 0;
 }

 */
