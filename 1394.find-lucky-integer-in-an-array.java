import java.util.HashMap;

/*
 * @lc app=leetcode id=1394 lang=java
 *
 * [1394] Find Lucky Integer in an Array
 */

// @lc code=start
class Solution {
    public int findLucky(int[] arr) {
        //数组操作起来似乎比HashMap要快一些。
        int[] nums = new int[501];
        for (int a : arr)
            nums[a]++;
        for (int i = 500; i > 0; i--)
            if (nums[i] == i)
                return i;
        return -1;
    }
}
// @lc code=end

