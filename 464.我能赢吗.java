/*
 * @lc app=leetcode.cn id=464 lang=java
 *
 * [464] 我能赢吗
 */

// @lc code=start
class Solution {
    // 没有取巧，也等同于暴力枚举
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 特判 第一步就能直接赢、走完全部数字双方都不能赢
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        // 使用二进制位来表示某一个数字是否已经被使用过了
        // 比如0000 0000 0000 0000 0001表示maxChoosableInteger=20 时，数字1被选中了
        // memo一共有2^n 个数字下标表示2^n种组合，值表示这个组合是否可以让先手稳赢
        Boolean[] memo = new Boolean[1 << maxChoosableInteger];
        return canIWinDfs(0, maxChoosableInteger, desiredTotal, memo);
    }

    // 用idx和n表示数字的选择与否，只看idx的前n个二进制位
    private boolean canIWinDfs(int idx, int n, int t, Boolean[] memo) {
        // 如果此时这个状态已经出现过了，那么就直接返回
        if (memo[idx] != null) {
            return memo[idx];
        }
        // 如果在剩余可选的数字里面可以选一个大于目标的，那么就表示可以赢
        if (getMaxOfUnSelect(idx, n) >= t) {
            return true;
        }
        // 如果选任意一个数字都无法保证这一轮获胜，那么就遍历可选数字，递归
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

    // 在没有被选择过的数字里选一个最大的
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

