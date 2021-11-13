/*
 * @lc app=leetcode.cn id=464 lang=java
 *
 * [464] 我能赢吗
 */

// @lc code=start
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 特判
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        Boolean[] memo = new Boolean[1 << maxChoosableInteger];
        return canIWinDfs(0, maxChoosableInteger, desiredTotal, memo);
    }

    // 用idx和n表示数字的选择与否，只看idx的前n个二进制位
    private boolean canIWinDfs(int idx, int n, int t, Boolean[] memo) {
        if (memo[idx] != null) {
            return memo[idx];
        }
        if (getMaxOfUnSelect(idx, n) >= t) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            int tmp = 1 << i;
            // 数字i+1未被选择
            if ((idx & tmp) == 0) {
                // 选择数字i+1
                int nxtIdx = idx | tmp;
                if (!canIWinDfs(nxtIdx, n, t - i - 1, memo)) {
                    return memo[idx] = true;
                }
            }
        }
        return memo[idx] = false;
    }

    private int getMaxOfUnSelect(int idx, int n) {
        int max = 0;
        for (int i = n - 1; i > -1; i--) {
            if ((idx & 1 << i) == 0) {
                max = i + 1;
                break;
            }
        }
        return max;
    }

}

// @lc code=end

