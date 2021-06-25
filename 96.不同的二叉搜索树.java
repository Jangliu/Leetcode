/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    /*
     * public int numTrees(int n) { // 用G[i]来表示i个数的二叉搜索树一共有多少种 int[] G = new int[n +
     * 1]; G[0] = 1; G[1] = 1;
     * 
     * for (int i = 2; i <= n; ++i) { // G[i]就等于以1到i每一个数作为根节点所得到的树的数目之和 //
     * 其中G[0]和G[1]已知 // 一个由n个不同的数组成的二叉搜索树的种类与其中具体的数无关，只与数的个数有关 for (int j = 1; j <=
     * i; ++j) { G[i] += G[j - 1] * G[i - j]; } } return G[n]; }
     */
    // 将以上思路通过数学归纳整理获得公式
    public int numTrees(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}

// @lc code=end

