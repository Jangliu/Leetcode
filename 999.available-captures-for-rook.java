/*
 * @lc app=leetcode id=999 lang=java
 *
 * [999] Available Captures for Rook
 */

// @lc code=start
class Solution {
    public int numRookCaptures(char[][] board) {
        int i = 0;
        int j = 0;
        int result = 0;
        for (; i < 8; i++) {
            j = 0;
            for (; j < 8; j++) {
                if (board[i][j] == 'R') {
                    break;
                }
            }
            if (j != 8) {
                break;
            }
        }
        for (int k = i - 1; k >= 0; k--) {
            if (board[k][j] == 'B') {
                break;
            }
            if (board[k][j] == 'p') {
                result++;
                break;
            }
        }
        for (int k = i + 1; k < 8; k++) {
            if (board[k][j] == 'B') {
                break;
            }
            if (board[k][j] == 'p') {
                result++;
                break;
            }
        }
        for (int k = j - 1; k >= 0; k--) {
            if (board[i][k] == 'B') {
                break;
            }
            if (board[i][k] == 'p') {
                result++;
                break;
            }
        }
        for (int k = j + 1; k < 8; k++) {
            if (board[i][k] == 'B') {
                break;
            }
            if (board[i][k] == 'p') {
                result++;
                break;
            }
        }
        return result;
    }
}
// @lc code=end

