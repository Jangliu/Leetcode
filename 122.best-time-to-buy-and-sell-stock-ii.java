/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy_in_price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (buy_in_price >= prices[i]) {
                buy_in_price = prices[i];
                continue;
            } else {
                int j = i;
                for (; j < prices.length; j++) {
                    if (prices[j] >= prices[j - 1]) {
                        continue;
                    }
                    profit += prices[j - 1] - buy_in_price;
                    i = j;
                    buy_in_price = prices[i];
                    break;
                }
                if (j <= prices.length - 1) {
                    continue;
                }
                profit += prices[j - 1] - buy_in_price;
                break;
            }
        }
        return profit;
    }
}
// @lc code=end

