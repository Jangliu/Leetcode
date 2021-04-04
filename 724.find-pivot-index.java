import java.util.HashMap;

/*
 * @lc app=leetcode id=724 lang=java
 *
 * [724] Find Pivot Index
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length < 1)
            return -1;
        int rsum = 0, lsum = 0;
        for (int x : nums) // calculating sum of the array
            rsum += x;
        for (int x = 0; x < nums.length; x++) {
            rsum -= nums[x];
            if (rsum == lsum)
                return x;
            lsum += nums[x];
        }
        return -1;
    }
}
// @lc code=end

