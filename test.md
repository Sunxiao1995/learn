**1、bit运算**

1000转换为二进制为 1111101000

32为2<sup>5</sup>  为100000

最少需要的班意思为每个班人数尽可能最多

1111101000右移5位得到11111 十进制的值为31

由于除的时候有余数 所以应该至少为32个班

















**二、使用直线划分空间**

1、 L(n) = n*(n+1)/2 +1

2、

```c
#include<stdio.h>

int calc_spaces(int n){
    if(n < 0)
    {
        return -1;
    }else{
        int calc = 0;
        calc = n*(n+1)/2+1;
        return calc;
        
    }
}

int main(void){
    int i;
    while(1){
        scanf("%d",&i);
        if(i<0)
            printf("不合法请重新输入");
        else
            printf("%d可以分割%d个空间\n",i,calc_spaces(i));
    }
    return 0;
}

```









三、**打印三角形**

```c
#include<stdio.h>
#define line 10
void draw(unsigned int n){
    int i,j = line;
    int a[line][line] = {0};
    for (i = 0;i < n;i++){
        a[i][0] = i+1;
        a[i][i] = i+1;
    }
    
    for(i = 0;i < n; i++){
        for (j = 1; j < i; j++) {
            a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
        }
    }
    int k;
    for (i = 0; i < n; i++) {
        for (k = i; k < n - 1; k++) {
            printf("   ");
        }
        for (j = 0; j <= i; j++)
            printf("%6d", a[i][j]);
        printf("\n");
    }
}

int main(void){
    int n = 0;
    printf("请输出n的值\n");
    scanf("%d",&n);
    if(n <= 0){
        printf("错误请重新输入\n");
    }else{
        draw(n);
    }
    return 0;
}

```







四、实现atof函数

```c
#include<stdio.h>
#define p 20
double my_atof(char *nptr){
    double a = 0;
    double temp = 10;
    
    while(*nptr !='\0' ){
        if(*nptr == '.'){
            nptr++;
            break;
        }
        a = a*10 + (*nptr - '0');
        nptr++;
    }
    while (*nptr != '\0'&& '0' <= *nptr && *nptr <= '9')
    {
        a = a + (*nptr - '0')/temp;
        temp = temp * 10;
        nptr++;
    }
    return a;
}

int main(void){
    while(1){
        char a[p] ={0};
        scanf("%s",a);
        printf("%lf\n",my_atof(a));
    }
    return 0;
}
```

第五题

```
Queue* enqueue(Queue* queue, int data){
    Stack* stack_temp = init_stack();
    while(!is_empty(queue)){
        int i = pop(queue);
        if(push(stack_temp, i))
            continue;
    }
    if(push(queue, data)){}
    while(!is_empty(stack_temp)){
        if(push(queue, pop(stack_temp))){
            continue;
        }
    }
    return queue;
}

int dequeue(Queue* queue){
    int i = pop(queue);
    return i;
}
```

本来想用递归 

进入队列和栈相同

出队列时

先调用pop函数获取出栈元素 未满足条件

递归函数 再调用pop

直到head指向最后一个元素 满足条件

此时在递归函数最里面 pop的值是2

把栈清空 依次出递归函数





