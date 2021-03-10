/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int buy_in_price=10001;
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            if(buy_in_price>=prices[i]){
                buy_in_price=prices[i];
            }
            profit=Math.max(profit, prices[i]-buy_in_price);
        }
        return profit;
    }
}
// @lc code=end

