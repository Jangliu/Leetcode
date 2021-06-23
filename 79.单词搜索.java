/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int k = 0;
        char[] c = word.toCharArray();
        boolean[][] isViststed = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == c[k]) {
                    isViststed[i][j] = true;
                    if (existCheck(board, c, i, j, k + 1, isViststed)) {
                        return true;
                    } else {
                        isViststed[i][j] = false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean existCheck(char[][] board, char[] c, int x, int y, int k, boolean[][] isViststed) {
        if (k == c.length) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        if (x - 1 >= 0 && c[k] == board[x - 1][y] && !isViststed[x - 1][y]) {
            isViststed[x - 1][y] = true;
            if (existCheck(board, c, x - 1, y, k + 1, isViststed)) {
                return true;
            } else {
                isViststed[x - 1][y] = false;
            }
        }
        if (x + 1 < m && c[k] == board[x + 1][y] && !isViststed[x + 1][y]) {
            isViststed[x + 1][y] = true;
            if (existCheck(board, c, x + 1, y, k + 1, isViststed)) {
                return true;
            } else {
                isViststed[x + 1][y] = false;
            }
        }
        if (y - 1 >= 0 && c[k] == board[x][y - 1] && !isViststed[x][y - 1]) {
            isViststed[x][y - 1] = true;
            if (existCheck(board, c, x, y - 1, k + 1, isViststed)) {
                return true;
            } else {
                isViststed[x][y - 1] = false;
            }
        }
        if (y + 1 < n && c[k] == board[x][y + 1] && !isViststed[x][y + 1]) {
            isViststed[x][y + 1] = true;
            if (existCheck(board, c, x, y + 1, k + 1, isViststed)) {
                return true;
            } else {
                isViststed[x][y + 1] = false;
            }
        }
        return false;
    }
}

// @lc code=end

