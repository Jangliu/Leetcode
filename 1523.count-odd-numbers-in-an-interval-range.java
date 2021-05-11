import javax.naming.spi.DirStateFactory.Result;

/*
 * @lc app=leetcode id=1523 lang=java
 *
 * [1523] Count Odd Numbers in an Interval Range
 */

// @lc code=start
class Solution {
    public int countOdds(int low, int high) {
        int result = high - low + 1;
        if (low % 2 == 1 && high % 2 == 1)
            return (result + 1) / 2;
        return result / 2;
    }
}
// @lc code=end

