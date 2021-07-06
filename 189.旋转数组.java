/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    //数组元素向右移动k次后，尾部的k mod n个元素会移动到数组的头部
    //其余元素向后移动k mod n个位置
    //将数组先全部进行翻转，这样尾部的k mod n个元素会移动到数组的头部
    //然后再反转[0,k mod n -1]区间的元素和[k mod n,n-1]区间，的元素即可得到最后答案
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}

// @lc code=end

