// 第二章作业1 打印温度转换表


/*
#include <stdio.h>
int main(void)
{
    int F ;
    int C;
    printf("  F      C\n");
    
    for(F = 40;F <= 240;F = F + 20){
        C = 5 * (F - 32) / 9;
       
        printf("%3d%7d\n", F, C);
    }
   printf("%3d%7d\n", 300, 148);
    return 0;
}

 
*/

// 作业二 尽量少的使用乘法打印阶乘表
/*
#include <stdio.h>
int main(void)
{
    int i=0;
    int n;
    int factorial=1;
    printf("请输入n的值:"); scanf("%d",&n);
    if (n == 0)
               printf("  0 !=     0\n");
           else
    for( printf("  0 !=     0\n"); i<n; printf("%3d !=%6d\n", i, factorial)){
        i++;
        factorial=factorial*i;
    }
    return 0;
}
*/

// 第三章 第一题  输入10个字符，统计其中的英文字母、数字字符和其他字符的个数。

/*
#include <stdio.h>
int main(void){
    int letter = 0;
    int digit = 0;
    int other = 0;
    int i;
    char ch;
    printf("请输入10个字符：");

    for(i=1;i<=10;i++)
    {
        ch = getchar();
        if ((ch >= 'a' && ch <= 'z' )|| (ch >= 'A'  && ch <= 'Z'))
            letter++;
        else if (ch >= '0' && ch <= '9')
            digit++;
        else
            other++;
    }
    printf("letter=%d, digit=%d, other=%d\n", letter,digit,other);
    return 0;
}

*/

// 第三章 第二题 根据输入的月份输出该月的天数，假设该年份不是闰年

/*
#include <stdio.h>
int main(void)
{
    int month;
    printf("请输入是几月：");
    scanf("%d",&month);
    if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        printf ("%d月的天数是31天。\n",month);
    else if (month == 2)
        printf("%d月的天数是28天。\n",month);
    else
        printf("%d月的天数是30天。\n",month);
    return 0;
}

*/

/*
#include <stdio.h>
int main(void)
{
    int month;
    printf("请输入是几月：");
    scanf("%d",&month);
    switch(month){
        case (4) :
        case (6) :
        case (9) :
        case (11) :
        printf ("%d月的天数是30天。\n",month);
            break;
    case (2) :
        printf("%d月的天数是28天。\n",month);
            break;
        default :
        printf("%d月的天数是31天。\n",month);
            break;
    }
    return 0;
}
*/

// 第四章 用最少的计算步骤完成素数判断


/*
#include <stdio.h>
int main(void)
{
    int a;
    int i;
    
    printf ("输入一个大于1的正整数:") ;   //2是最小的素数
    scanf("%d",&a);
  
    if (a == 2 || a == 3 )
        printf ("输入的整数是素数。\n");

    else {
        for(i=2; i * i <= a; i++) {
            if(a % i == 0){
        printf("输入的整数不是素数。\n");
       return 0 ;
            }
       }
    }
    printf("输入的整数是素数。\n");
    return 0;
}
*/
