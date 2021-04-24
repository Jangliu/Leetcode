/*
 * @lc app=leetcode id=1281 lang=java
 *
 * [1281] Subtract the Product and Sum of Digits of an Integer
 */

// @lc code=start
class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while(n>=10){
            product*=n%10;
            sum+=n%10;
            n=(n-n%10)/10;
        }
        product*=n;
        sum+=n;
        return product-sum;
    }
}
// @lc code=end

