/*
#include <stdio.h>
#include <stdlib.h>
#define SIZE 100
#define ADDNUM 0
#define ADDPOS 0
#define DELPOS 0
#define SEARCHNUM 4
#define MODIFYNUM 27

typedef struct {
    int *head;
    int length;
    int capacity;
    
} SeqList;

SeqList initSeqList() {
    SeqList list;
    list.head = (int *)malloc(SIZE * sizeof(int));
    
    if (!list.head) {
        printf("初始化失败！\n");
        exit(0);
    }
    
    list.length = 0;
    list.capacity = SIZE;
    return list;
}

void displayList(SeqList list) {
    for (int i = 0; i < list.length; i++) {
        printf("%d  ", list.head[i]);
    }
    
    printf("\n");
}

SeqList add(SeqList list, int elem, int pos) {
    
    if (pos > list.length  || pos < 0) {
        printf("插入位置有误\n");
        return list;
    }
    while(list.length >= list.capacity) {
        int *temp = (int *)realloc(list.head, (list.capacity << 1) * sizeof(int));
        
        if (!temp) {
            printf("内存分配失败！\n");
            return list;
        }
        
        list.head = temp;
        list.capacity <<= 1;
    }
    
    
    for (int i = list.length - 1; i >= pos ; i--) {
        list.head[i + 1] = list.head[i];
    }
    
    list.head[pos] = elem;
    
    list.length++;
    
    return list;
}

SeqList delete(SeqList list , int pos) {
    
    if (pos >= list.length || pos < 0) {
        printf("删除位置有误\n");
        return list;
    }
    for (int i = pos ; i < list.length - 1 ; i++) {
        list.head[i] = list.head[i + 1];
    }
    list.length--;//表长度-1
    while (list.length <= (list.capacity * 1/2)) {
        int *temp = (int *)realloc(list.head, (list.capacity >> 1) * sizeof(int));
        
        if (!temp) {
            printf("内存分配失败！\n");
            return list;
        }
        list.head = temp;
        list.capacity >>= 1;
    }
    return list;
}

int main(void) {
    SeqList list = initSeqList();
    list.head[0] = 1;
    for (int i = 0; i < 100; i++) {
        list = add(list,i,0);
        displayList(list);
    }
    for (int i = 0; i < 100; i++) {
        list = delete(list,0);
        displayList(list);
    }
   
    
    free(list.head);
    list.head = NULL;
    
    return 0;
}

*/



#include <stdio.h>
#include <stdlib.h>
#define SIZE 5
#define ADDNUM 0
#define ADDPOS 0
#define DELPOS 0
#define SEARCHNUM 3
#define MODIFYPOS 3
#define MODIFYNUM 27

typedef struct node {
    int elem;
    struct node *next;
} Node;


Node *initNode(Node *pre, int elem) {
    Node *node = (Node *)malloc(sizeof(Node));
    node->elem = elem;
    node->next = NULL;
    pre->next = node;
    return node;
}


void display(Node *p) {
    Node *temp = p;
    printf("共%d个元素：", temp->elem);
    
    while (temp->next) {
        temp = temp->next;//跳过头结点
        printf("  %d", temp->elem);
    }
    
    printf("\n");
}


void add(Node *p, int elem, int pos) {
    //插入位置判断，取值范围为0～length
    int length = p->elem;//传入的是头结点，直接取链表长度值
    
    if (pos > length   || pos < 0) {
        printf("插入位置有误\n");
        return;
    }
    
    //找到需要插入位置的上一个结点
    Node *temp = p;
    
    for (int i = 0; i < pos; i++) {
        temp = temp->next;
    }
    
    //新建一个结点
    Node *add = (Node *)malloc(sizeof(Node));
    add->elem = elem;
    add->next = temp->next;//将新结点的next指向上一个结点原来的next
    temp->next = add;//将上一个结点指向新结点
    
    p->elem ++;//表长度+1
}


void delete(Node *p, int pos) {
    //删除位置判断，取值范围为0～length-1
    int length = p->elem;//传入的是头结点，直接取链表长度值
    
    if (pos >= length || pos < 0) {
        printf("删除位置有误\n");
        return;
    }
    
    //找到需要删除位置的上一个结点
    Node *temp = p;
    
    for (int i = 0; i < pos; i++) {
        temp = temp->next;
    }
    
    Node *del = temp->next;//需要删除的结点
    temp->next = del->next;//将上一个结点的指针指向删除结点的后一个结点
    free(del);//释放内存
    del = NULL;
    
    p->elem --;//表长度-1
}
int main(void) {
    Node *head = (Node *)malloc(sizeof(Node)); //创建头结点
    Node *pre = head;//将头结点作为首元结点的前一个结点
    
    for (int i = 0; i < SIZE; i++) {
        pre = initNode(pre, i + 1);//创建结点，并将新建结点作为后一个结点的前结点
    }
    
    head->elem = SIZE;
    
    display(head);
    
    for (int i = 0; i < 100; i++) {
        add(head, i, ADDPOS);
        display(head);
    }
    for (int i = 0; i < 100; i++) {
        delete(head, DELPOS);
        display(head);
    }
    return 0;
}



