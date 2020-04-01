/*
 
#include<stdio.h>
#include <stdlib.h>

int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    
    int* result = malloc(2 * sizeof(int));
    for (int i = 0; i < numsSize - 1; i++)
    {
        for (int j = i + 1; j < numsSize; j++)
        {
            if (nums[i] + nums[j] == target)
            {
                result [0] = i;
                result [1] = j;
                *returnSize = 2;
                return result;
            }
        }
    }
    return NULL;
}
*/
/*

#include<stdio.h>
#include <stdlib.h>
int* smallerNumbersThanCurrent(int* nums, int numsSize, int* returnSize)
{
    int* result = malloc(numsSize * sizeof(int));
    
    for (int i=0; i < numsSize; i++)
    {
        int x = 0;
        for (int j =0; j < numsSize; j++)
        {
            if (nums[i] > nums[j])
                x++;
        }
        result[i] = x;
    }
    *returnSize = numsSize;
    return result;
}

*/

/*
 1、原数组假设为nums
 2、定义一个数组nums1，空间和给定的数组空间大小相同；
 3、从第0项开始，判断第x项的字符有无与之前的0-(x-1)项字符相等的
 4、若不相等，把x项的字符赋值给数组的nums1[x]
 5、同时count加1
 6、当某个n的值nums[n]与前面有值相等时nums[i]，
 7、定义一个新的数组nums2,nums2[0]=nums[i+1],以此类推，这个数组的元素个数为count
 8、重复之前的操作，判断这个新的数组内有无重复的，
 9、如果有，第一个重复的位置为j,则还是以count为长度，把nums数组中j+1的值再次赋值给nums2的第0-（count-1）项，
 10、直到出现都不相等重复步骤4.
 11、遍历数组，得到count值
*/
