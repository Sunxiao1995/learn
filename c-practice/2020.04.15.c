#include <stdio.h>
#include <math.h>
#include <stdlib.h>
typedef struct bstnode{
    int date;
    struct bstnode *lchild;             //结构体定义一个二叉搜索树的结点
    struct bstnode *rchild;
    struct bstnode *parent;
}BSTNode;

BSTNode* InSertBSTree(BSTNode *BST,int InsertVal){
    BSTNode *ROOT = BST;
    BSTNode *New = (BSTNode *)malloc(sizeof(BSTNode));
    if (New == NULL)
        exit(-1);
    New->date = InsertVal;
    New->lchild = New->rchild = NULL;
    BSTNode *Temp = NULL;
    while(BST != NULL){       //此while循环按照二叉搜索树的规则找到一个空位置的上一个结点temp
        Temp = BST;
        if(New->date <= BST->date)
            BST = BST->lchild;
        else
            BST = BST->rchild;
    }
    New->parent = Temp;         //新节点的parent是temp
    
    if(New->date <= Temp->date)
        Temp->lchild = New;     //在把这个节点放到temp的下面，判断一次左右
    else
        Temp->rchild = New;
    
    return ROOT;
}


void InTraverseBSTree(BSTNode *BST)      //中序遍历的函数先打印左边，在打印自己，在打印右边 使用递归的思想
{
    if(NULL != BST)
    {
        if(NULL != BST ->lchild )
            InTraverseBSTree(BST ->lchild);
        printf("%d ",BST ->date);
        if(NULL != BST ->rchild)
            InTraverseBSTree(BST ->rchild);
    }
}

int main(void){
    int a[10] = {5,7,1,4,6,6,3,8,10,9};
    BSTNode *Root = (BSTNode *)malloc(sizeof(BSTNode));   //定义一个头结点，也就是二叉树的根
    Root->date = a[0];
    Root->lchild = Root->rchild = Root->parent = NULL;
    int i = 1;
    while(i<10){
        InSertBSTree(Root,a[i]);                              //插入二叉搜索树结点的函数
        i++;
    }
    InTraverseBSTree(Root);     //中序遍历打印二叉树
    printf("\n");
    return 0;
}
