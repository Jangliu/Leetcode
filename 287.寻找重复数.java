/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    // 我们对 nums数组建图，每个位置 i连一条 i→nums[i]的边
    // 由于存在的重复的数字 target
    // 因此target这个位置一定有起码两条指向它的边，因此整张图一定存在环

    public int findDuplicate(int[] nums) {
        // 设置慢指针 slow和快指针 fast。
        // 慢指针每次走一步，快指针每次走两步
        // 在有环的情况下一定会相遇
        // 相遇时将慢指针放回起点位置
        // 两个指针每次同时走一步
        // 再相遇的点就是答案
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
// @lc code=end

