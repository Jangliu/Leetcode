/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] isTrusted = new int[N + 1];
        for (int[] person : trust) {
            isTrusted[person[0]]--;
            isTrusted[person[1]]++;
        }
        for (int i = 1; i < isTrusted.length; i++) {
            if (isTrusted[i] == N - 1)
                return i;
        }
        return -1;
    }
}
// @lc code=end

