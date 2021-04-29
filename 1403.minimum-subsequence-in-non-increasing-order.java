import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode id=1403 lang=java
 *
 * [1403] Minimum Subsequence in Non-Increasing Order
 */

// @lc code=start
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        int rest = 0;
        for(int i=nums.length-1;i>=0;i--){
            rest+=nums[i];
            sum-=nums[i];
            result.add(nums[i]);
            if(rest>sum){
                break;
            }
        }
        return result;
    }
}
// @lc code=end

