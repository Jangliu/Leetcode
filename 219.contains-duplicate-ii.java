import java.util.HashMap;
/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */
import java.util.Map;

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> Map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(Map.containsKey(Integer.valueOf(nums[i]))&&(i-Map.get(nums[i]))<=k){
                return true;
            }
            Map.put(nums[i],i);
        }
        return false;
    }
}
// @lc code=end

