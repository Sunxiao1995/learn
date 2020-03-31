
#include <stdio.h>
#include <time.h>
#include <stdlib.h>


int main ()
{
    // 生成100个随机数的数组, 分布到0-100
    srand((unsigned int)time(NULL));
    int a[100];
    int chart[11] = {0};                  // 将数组的数全部置0
    for (int i = 0; i < 100; i++)
    {
        a[i] = rand() % 101;              // 生成随机数，新建一个chart数组，用该数组的每个值代表
        chart[a[i] / 10]++;               // 每10个区间范围内的个数
    }
    int max = chart[0];
    int j,i;
    for (i = 1; i < 11; i++)              // 得到最大的区间高度
    {
        if (max < chart[i])
            max = chart[i];
    }
    for (j=max; j > 0; j--)
    {
        for (i = 0; i < 11; i++)           // 按行输出
        {
            if (chart[i] >= j)
                printf("  * ");
            else
                printf("    ");
        }
        putchar('\n');
    }
    putchar('\n');
    printf("---------------------------------------------\n");
    for (j = 0; j <= 100; j += 10)
    {
        printf("%3d ", j);
    }
    printf("\n");
    return 0;
    
    
}

