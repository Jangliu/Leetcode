/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // len为当前最长上升子序列的长度
        int len = 1, n = nums.length;
        // 数组d储存当前求出的最长上升子序列
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            // 遍历数组
            // 若是nums[i]大于当前最长上升子序列的最大值
            // 就将nums[i]加入当前最长上升子序列的末尾
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 如果nums[i]比当前最长上升子序列的最大值要小
                // 那么可以将nums[i]加入到当前最长上升子序列中
                // 这样做的好处是当成一个简单的贪心算法
                // 要使上升子序列尽可能的
                // 则需要让序列上升得尽可能慢
                //因此希望每次在上升子序列最后加上的那个数尽可能的小。
                int l = 1, r = len, pos = 0; 
                // 如果找不到说明所有的数都比 nums[i] 大
                // 此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r)/2;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}

// @lc code=end

