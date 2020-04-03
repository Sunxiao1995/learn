
#include<stdio.h>

long t = 0;

void hannuota(int x, char A, char B, char C)
{
    if(x == 1)
    {
        t++;                       //出口，只剩一个盘子的时候
    }else{
        hannuota(x-1,A,B,C);   //将x-1的盘子经由b移动到c
        t++;                       //最底层移动到b
        hannuota(x-1,C,A,B);   //将x-1的盘子经由a移动到b
    }
    
}
 int main(void)
{
    while(1)
    {
        int z;
        printf("输入汉诺塔层数：\n");
        scanf("%d",&z);
        hannuota(z,'A','B','C');
        printf("需移动的次数为%ld\n",t);
    }
    return 0;
}
