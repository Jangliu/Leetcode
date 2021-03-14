import java.util.HashMap;

/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> Map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(Map.containsKey(Integer.valueOf(nums[i]))){
                return true;
            }
            Map.put(nums[i],i);
        }
        return false;
    }
}
// @lc code=end

