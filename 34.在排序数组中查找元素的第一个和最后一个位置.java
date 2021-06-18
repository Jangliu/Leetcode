/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };
        int n = nums.length;
        int sp;
        int ep;
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            if (nums[0] == target) {
                res[0] = 0;
                res[1] = 0;
            }
            return res;
        }
        if (target < nums[0] || target > nums[n - 1]) {
            return res;
        }
        sp = 0;
        ep = n - 1;
        int mid = (ep + sp) / 2;
        while (sp <= ep) {
            if (target == nums[mid]) {
                for (int i = mid; i >= 0; i--) {
                    if (target == nums[i]) {
                        res[0] = i;
                    } else {
                        break;
                    }
                }
                for (int i = mid; i < n; i++) {
                    if (target == nums[i]) {
                        res[1] = i;
                    } else {
                        break;
                    }
                }
                return res;
            }
            if (target > nums[mid]) {
                sp = mid + 1;
                mid = (sp + ep) / 2;
            } else {
                ep = mid - 1;
                mid = (sp + ep) / 2;
            }
        }
        return res;
    }
}
// @lc code=end

