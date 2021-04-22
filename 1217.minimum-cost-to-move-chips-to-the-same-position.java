import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=1217 lang=java
 *
 * [1217] Minimum Cost to Move Chips to The Same Position
 */

// @lc code=start
class Solution {
    //奇数位置上的互相移动不影响cost，偶数位置上的也是
    //奇偶互相移动才形象，互相移动一次花费1
    public int minCostToMoveChips(int[] chips) {
        int even = 0;
        for(int i:chips)
            if(i%2==0)
                even++;
        return Math.min(even,chips.length-even);
    }
}
// @lc code=end

