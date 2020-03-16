#!/bin/zsh
touch ex01.c ex02.c ex03.c
mkdir example
mv ex01.c example
mv example/ex01.c example/example.c
mkdir practice
mv ex02.c practice
mv practice/ex02.c practice/practice.c
rm ex03.c
echo '## example/example.c  
判断是奇数还是偶  
## practice/practice.c  
比较两个数大小' > README.md
git add .
git commit -m"提交所有改动"
git push 


