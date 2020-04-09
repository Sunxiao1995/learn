/*双向链表的增删操作
 typedef struct node{
   struct node *pre;      //指向前一个节点
   struct node *next;     //指向后一个节点
   int elem;
 }Node;

 //添加至表头
 newnode->pre = NULL
 newnode->next = head
 head->pre = newnode
 head = newnode

   
 //添加至中间
 newnode->next = node1->next
 node1->next->pre =newnode
 node1->next = newnode
 newnode->pre = node1

 //添加至结尾
 endnode->next = newnode
 newnode->pre = endnode
 newnode->next = NULL
   
 //删除节点
 delnode->pre->next = delnode->next
 delnode->next->pre = delnode->pre
 free

*/


// 循环链表解决约瑟夫环问题

/*
#include<stdio.h>
#include<stdlib.h>

typedef struct node{
    int elem;
    struct node * next;
} Node;
//生成一个循环链表
Node *initNode(int length){
    Node * head = (Node *)malloc(sizeof(Node));
    head->elem = 1;
    head->next = NULL;
    Node * pre = head;     //定义一个头节点
    for (int i=2; i <= length;i++){         //生成后面的节点
        Node * node = (Node *)malloc(sizeof(Node));
        node->elem = i;
        node->next = NULL;
        pre->next = node;
        pre = pre->next;
    }
    pre->next = head;      //尾节点指向头节点
    return head;
}

// 找到并删除节点
void find_del_node(Node * head,int k,int m){
    Node * pre = head;
    while(pre->next != head){   //找到链表第一个节点节点的前一个节点
        pre = pre->next;
    }
    Node * p = head;
    while (p->elem != k){
        pre = p;
        p = p->next;         //找到第k个人
    }
    while (p->next!= p){
        for (int i = 1;i < m; i++){    //找到k后的第m个人
            pre = p;
            p = p->next;
        }
        pre->next = p->next;
        printf("%d号出列\n",p->elem);
        free(p);
        p = pre->next;
    }
    printf("剩余%d号\n",p->elem);
    free(p);
}

int main(void){
    int n,m,k;
    printf("请输入圆桌上的人数n:");scanf("%d",&n);
    for(int i = 0;i < n;i++){
        printf(" %d ",i+1);
    }
    printf("\n");
    printf("从第几人开始:");scanf("%d",&k);
    printf("第m人开始出列，输入m的值:");scanf("%d",&m);
    Node * head = initNode(n);
    find_del_node(head,k,m);
    return 0;
}
*/

//搜索并理解约瑟夫问题使用数组来解决  (只求出最后一个人)
/*
#include<stdio.h>
int main(void){
    int n,k,m;
    printf("请输入圆桌上的人数n:");scanf("%d",&n);
    printf("从第几人开始:");scanf("%d",&k);
    printf("第m人开始出列，输入m的值:");scanf("%d",&m);
    int a[n];
    for(int i = 0;i < n; i++)
    {
        a[i] = 1;
    }   // 数组初始化，1：表示在圆桌上；0：表示出列
    
    int leftCount = n;                   // leftCount：计录在圆桌上的人
    int index = 0,count = 0;            // 1.数组下标index；2.循环计数器count
    
    while(leftCount>1){                 // 当还剩下一个人结束
        
        if(a[index] == 1){
            count++;
            if(count == m){              // 计数到m；2.循环计数器count重新开始计数；3.计数器leftCount减1
                a[index] = 0;            //  出列；
                count = 0;                //  循环计数器count重新开始计数；
                leftCount--;            //  人数减1
            }
        }
        index++;
        
        if(index == n)
        {
            index = 0;
        }    // 当到数组尾，数组下标index置零，重新开始
    }
    
    for(int j = 0;j < n ;j++){             // 输出结果
        if(1 == a[j]){ printf("剩下的人为第%d个\n",j+k); }  //由于没有元素被删除，所以从k开始的话，可以理解为一个新的数组，下标和之前的相差k-1
    }
}
*/


#include <stdio.h>
#define size 10


int push(int *p, int top, int elem) {
    top++;
    p[top] = elem;
    printf("入栈元素：%d，栈顶为：%d\n", elem, top);
    return top;
}

int pop(int *p, int top,int elem) {
    if (top == -1) {
        printf("空栈\n");
        return -1;
    }
    
    printf("出栈元素：%d  ", p[top]);
    elem = p[top];
    p[top--] = 0;
    printf("栈顶为：%d\n", top);
    return elem;
}

int main(void){
    int elem = 0 ;
    int elem1 = 0;
    int elem2 = 0;
    int a[size] = {0};
    int top = -1;
    char c;
    while(scanf("%c",&c) != EOF){
        
        getchar();
        if(c >= '0' && c <= '9'){
            int b = (int) (c - '0');
            top = push(a,top,b);
        }
        switch(c){
            case '+':
            {
                if (top + 1 < 2){
                    printf("用户没有足够的操作数。\n");
                }
                else{
                    elem1 = pop(a,top,elem);
                top --;
                elem2 = pop(a,top,elem);
                top --;
                elem =  elem1+ elem2;
                    top = push(a,top,elem);}
            }break;
            case '-':
            {
                if (top + 1 < 2){
                    printf("用户没有足够的操作数。\n");
                }
                else{
                    elem1 = pop(a,top,elem);
                top --;
                elem2 = pop(a,top,elem);
                top --;
                elem =  elem2 - elem1;
                    top = push(a,top,elem);}
            }break;
            case '*':
            {
                if (top + 1 < 2){
                    printf("用户没有足够的操作数。\n");
                }
                else{
                    elem1 = pop(a,top,elem);
                    top --;
                    elem2 = pop(a,top,elem);
                    top --;
                    elem =  elem1 * elem2;
                    top = push(a,top,elem);}
            }break;
            case '/':
            {
                if (top + 1 < 2){
                    printf("用户没有足够的操作数。\n");
                }
                else{
                elem1 = pop(a,top,elem);
                top --;
                elem2 = pop(a,top,elem);
                top --;
                elem =  elem2 / elem1;
                    top = push(a,top,elem);}
            }break;
        }
        
    }
    if(scanf("%c",&c) == EOF){
        if(top == 0){
            printf("这个值%d就是整个计算式的结果\n",elem);
        }
        else {
            printf("用户输入了多余的操作数\n");
        }
    }
    return 0;
}


