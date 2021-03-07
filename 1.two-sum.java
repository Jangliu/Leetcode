/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> val = new ArrayList<>();
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int n = val.indexOf(target - nums[i]);
            if (n != -1) {
                result[0] = Math.min(i, n);
                result[1] = Math.max(i, n);
                return result;
            } else {
                val.add(nums[i]);
            }
        }
        return result;      
    }
}
// @lc code=end

