/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int sp=0;
        int ep=nums.length-1;
        int mid = (sp+ep)/2;
        while(ep-sp>=1){
            if(nums[mid]>=target){
                ep=mid;
                mid = (sp+ep)/2;
                continue;
            }
            if(nums[mid]==target){
                return mid;
            }
            if(sp==mid){
                break;
            }
            sp=mid;
            mid=(sp+ep)/2;
        }
        if(nums[sp]==target){
            return sp;
        }
        if(nums[ep]==target){
            return ep;
        }
        return -1;
    }
}
// @lc code=end

