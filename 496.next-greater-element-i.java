/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result =new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums2[j]==nums1[i]){
                    int k=j+1;
                    for(;k<nums2.length;k++){
                        if(nums2[k]>nums1[i]){
                            result[i]=nums2[k];
                            break;
                        }
                    }
                    if(k==nums2.length){
                        result[i]=-1;
                    }
                    break;
                }
            }
        }
        return result;
    }
}
// @lc code=end

