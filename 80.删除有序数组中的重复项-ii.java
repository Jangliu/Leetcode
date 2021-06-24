import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // 双指针解决
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        // 慢指针slow-1表示已经检查了的数组
        // 快指针fast表示当前待检查的元素
        // 同一个元素最多出现两次，所以比较的时候得比较fast和slow-2
        // 并且数组是排好序的，所以只需要比较fast和slow-2就可以了
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
// @lc code=end

