/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    boolean[][] isVisisted;
    //O和0看错了是真的难顶
    public void solve(char[][] board) {
        // 思路如下：
        // 通过对四条边界遍历，找到边界上的O
        // 然后与边界上O相连通O都不动
        // 其他位置都置为X
        int m = board.length;
        int n = board[0].length;
        // 记录哪些位置是属于边界O的连通0
        isVisisted = new boolean[m][n];

        // 遍历第一行
        for (int i = 0; i < n; i++) {
            if (!isVisisted[0][i] && board[0][i] == 'O') {
                solveHelper(board, 0, i);
            }
        }
        // 遍历最后一行
        for (int i = 0; i < n; i++) {
            if (!isVisisted[m - 1][i] && board[m - 1][i] == 'O') {
                solveHelper(board, m - 1, i);
            }
        }
        // 遍历第一列
        for (int i = 0; i < m; i++) {
            if (!isVisisted[i][0] && board[i][0] == 'O') {
                solveHelper(board, i, 0);
            }
        }
        // 遍历最后一列
        for (int i = 0; i < m; i++) {
            if (!isVisisted[i][n - 1] && board[i][n - 1] == 'O') {
                solveHelper(board, i, n - 1);
            }
        }
        // 替换
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisisted[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public void solveHelper(char[][] board, int x, int y) {
        isVisisted[x][y] = true;
        if (x + 1 < board.length) {
            if (!isVisisted[x + 1][y] && board[x + 1][y] == 'O') {
                solveHelper(board, x + 1, y);
            }
        }
        if (x - 1 >= 0) {
            if (!isVisisted[x - 1][y] && board[x - 1][y] == 'O') {
                solveHelper(board, x - 1, y);
            }
        }
        if (y + 1 < board[0].length) {
            if (!isVisisted[x][y + 1] && board[x][y + 1] == 'O') {
                solveHelper(board, x, y + 1);
            }
        }
        if (y - 1 >= 0) {
            if (!isVisisted[x][y - 1] && board[x][y - 1] == 'O') {
                solveHelper(board, x, y - 1);
            }
        }
    }
}
// @lc code=end

