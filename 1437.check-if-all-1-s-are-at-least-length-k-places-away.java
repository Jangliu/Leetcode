/*
 * @lc app=leetcode id=1437 lang=java
 *
 * [1437] Check If All 1's Are at Least Length K Places Away
 */

// @lc code=start
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        //每次遇到1就清零距离，然后计算两个1之间的距离
        int dist = k;
        for (int i : nums) {
            if (i == 0)
                dist += 1;
            else if (dist < k)
                return false;
            else
                dist = 0;
        }
        return true;
    }
}
// @lc code=end

