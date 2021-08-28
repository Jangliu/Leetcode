/*
 * @lc app=leetcode.cn id=357 lang=java
 *
 * [357] 计算各个位数不同的数字个数
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        switch(n){
            case 0:
                return 1;
            case 1:
                return 10;
            default:
                int res =81;
                int index=n-2;
                for(;index>0;index--){
                    res*=10-(n-index);
                }
                return res+countNumbersWithUniqueDigits(n-1);
        }
    }
}
// @lc code=end

