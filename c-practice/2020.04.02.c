
/*
#include<stdio.h>
#include<time.h>
#include<stdlib.h>
#include<string.h>

int judge (char * s, int n){
    for (int i = 0; i < n; i++){
        if (s[i] == s[n])
            return 1;
    }
    return 0;
}

int find_lengthOfLongsSubstring(char * s){
    int i;
    int len = (int)strlen(s);
    if (len == 1)
        return 1;
    for (i = 1; i < len ; i++)
    {
        if (judge(s,i))
            break;
    }
    return i;
}

int lengthOfLongestSubstring(char * s){
    int max = 0;
    unsigned int n = (unsigned int)strlen(s);
    for (int i = 0; i < n; i++)
    {
        int length = find_lengthOfLongsSubstring(s + i);
        max = length;
    }
    return max;
}

int main()
{
    char * s = malloc(100);
    while(1){
        printf("input:");
        scanf("%s",s);
        printf("%d\n",find_lengthOfLongsSubstring(s));
    }
    return 0;
}

*/

/*
#include<stdio.h>
#include<time.h>
#include<stdlib.h>
#include<string.h>

int singleNumber(int* nums, int numsSize){
    int output=nums[0];
    for(int i = 1;i < numsSize; i++){
        output=output^nums[i];
    }
    return output;
}
int main()
{
    int s[5] = {0,1,2,1,2};
        printf("%d\n",singleNumber(s,5));
    return 0;
}
*/


int singleNumber(int* nums, int numsSize){
    if(numsSize <= 1)
    {
        return nums[0];
    }
    int judge=0;
    int i,j;
    for (i=0;i < numsSize;++i)
    {   judge=0;
        for(j= 0;j < numsSize;++j)
        {
            if( i == j ){
                continue;
            }
            if (nums[i] == nums[j])
            {
                judge = 1;
                break;
            }
        }
        if(judge == 1){
            continue;
        }else{
            break;
        }
        
    }
    return nums[i];
}

