
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

/*
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int* constructArray(int n, int k, int* returnSize){
    int * arrange = malloc(n * sizeof(int));
    memset(arrange, 0, n * sizeof(int));
    if(k == 1){
        for(int i = 0;i < n;i++){
            arrange[i] = i + 1;
        }
    }else{
        for(int i = 0;i < n - k;i++)
        {
            arrange[i] = i + 1;
        }
        
        arrange[n - k] = n;
        int m = -1;
        for(int i = n - k + 1; i < n; i++){
            arrange[i] = arrange[i - 1] + m * (n - i);
            m = -m;
        }
        
    }
    *returnSize = n;
    return arrange;
}

*/
