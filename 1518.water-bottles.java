/*
 * @lc app=leetcode id=1518 lang=java
 *
 * [1518] Water Bottles
 */

// @lc code=start
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = 0;
        int result = 0;
        while(numBottles>0){
            result+=numBottles;
            int temp = numBottles+emptyBottles;
            numBottles =temp/numExchange;
            emptyBottles=temp%numExchange;
        }
        return result;
    }
}
// @lc code=end

