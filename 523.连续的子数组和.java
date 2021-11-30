/*
 * @lc app=leetcode.cn id=523 lang=java
 *
 * [523] 连续的子数组和
 */

// @lc code=start
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        // remainder记录从数组从[0,i]的数组元素之和
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            // 假设remainder加到i的时候与remainder加到j的时候，两者和k的余数都相同，那么这两者之差肯定是k的倍数
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                // 如果两者下标差距大于等于2说明符合条件
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                // 存储此时的下标
                map.put(remainder, i);
            }
        }
        return false;
    }
}
// @lc code=end

