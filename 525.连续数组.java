/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        // 解题思路为前缀和
        // 遍历数组，遇到1则前缀+1，遇到0则前缀-1
        // 将经历过的全部前缀及其下标保存在hash表中
        // 当遍历到某个前缀，并且这个前缀在hash表中出现过时就可以断定，这两个前缀下标之间的那个子数组中0和1的数目相等
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}
// @lc code=end

