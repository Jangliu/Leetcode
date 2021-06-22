/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    //使用组合数学
    public int uniquePaths(int m, int n) {
        //对于一个m*n的网格，要从左上角到右下角，一共需要移动m+n-2次
        //其中向下移动m-1次向右移动n-1次
        //所以就是计算一个组合数
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
// @lc code=end

