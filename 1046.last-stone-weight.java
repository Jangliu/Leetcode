import java.util.Arrays;

/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        //果然每次都要重新排一遍
        if (stones.length == 1)
            return stones[0];
        Arrays.sort(stones);
        int y = stones.length - 1;
        int x = stones.length - 2;
        while (x >= 0) {
            if (stones[x] == stones[y]) {
                stones[x] = 0;
                stones[y] = 0;
            } else {
                stones[y] -= stones[x];
                stones[x] = 0;
            }
            Arrays.sort(stones);
            if (stones[x] == 0)
                break;
        }
        return stones[y];
    }
}
// @lc code=end

