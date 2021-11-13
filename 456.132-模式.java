/*
 * @lc app=leetcode.cn id=456 lang=java
 *
 * [456] 132 模式
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        // 单调栈，用来存放备用的nums[k]的值
        Deque<Integer> candidateK = new LinkedList<Integer>();
        // 因为要从后往前遍历，先将最后一个元素放入栈中
        candidateK.push(nums[n - 1]);
        // 最大的nums[k]值
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            // 栈底元素最小，但是下标最大，如果此时遍历到的nums[i]<最大的nums[k]
            // 那么一定在栈中还存在下标小于k的j，nums[j]>nums[k]
            if (nums[i] < maxK) {
                return true;
            }
            // 如果栈非空，且栈顶元素小于nums[i]则将其移出栈
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                maxK = candidateK.pop();
            }
            // 如果nums[i]大于备选的nums[k]，则将其放入栈中
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }
}
// @lc code=end

