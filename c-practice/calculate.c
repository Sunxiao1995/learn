
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int add(a,b){
    return a+b;
}
int sub(a,b){
    return a-b;
}
int mul(a,b){
    return a*b;
}
double div_(a,b){
    return ((double)a)/b;
}

int main(void){
    while(1){
        int i = 0;
        int a = 0;
        int b = 0;
        char str[10]="";
        printf("要进行哪种运算？\n");
        printf("1.加法\n");
        printf("2.减法\n");
        printf("3.乘法\n");
        printf("4.除法\n");
        printf("5.退出\n");
        printf("请输入：");scanf("%d",&i);
        if(i == 5)
            return 0;
        if(i > 4 || i < 1){
            printf("请输入正确的运算！\n");
            continue;
        }
        printf("请输入第一个操作数：");
    Loop1:    scanf("%s",str);
        if(NULL == strchr(str,'.'))
            sscanf(str,"%d",&a);
        else{
            printf("输入不合法，请重新输入\n");
            goto Loop1;}
        printf("请输入第二个操作数：");
    Loop2:  scanf("%s",str);
        if(NULL == strchr(str,'.'))
            sscanf(str,"%d",&b);
        else{
            printf("输入不合法，请重新输入\n");
            goto Loop2;}
        switch (i){
            case 1 :
                printf("%d + %d = %d\n",a,b,add(a,b));
                break;
            case 2 :
                printf("%d - %d = %d\n",a,b,sub(a,b));
                break;
            case 3 :
                printf("%d * %d = %d\n",a,b,mul(a,b));
                break;
            case 4 :
                printf("%d / %d = %.2lf\n",a,b,div_(a,b));
                break;
            default :
                break;
        }
    }
}
