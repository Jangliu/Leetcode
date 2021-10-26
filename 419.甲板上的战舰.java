/*
 * @lc app=leetcode.cn id=419 lang=java
 *
 * [419] 甲板上的战舰
 */

// @lc code=start
class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int res=0;
        boolean[][] isVisited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // 若当前节点没有被算入到战舰中过，并且是X
                if(!isVisited[i][j]&&board[i][j]=='X'){
                    // 战舰数量加1
                    res++;
                    // 查看左边的邻居是否为X
                    if(j-1>=0){
                        if(board[i][j-1]=='X'){
                            for(int k=j-1;k>=0;k--){
                                if(board[i][k]=='X'){
                                    isVisited[i][k] = true;
                                }
                                else{
                                    break;
                                }
                            }
                        }
                    }
                    // 查看右边的邻居是否为X
                    if(j+1<n){
                        if(board[i][j+1]=='X'){
                            for (int k = j+1; k < n; k++) {
                                if (board[i][k] == 'X') {
                                    isVisited[i][k] = true;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    // 查看上边的邻居是否为X
                    if (i - 1 >= 0) {
                        if (board[i - 1][j] == 'X') {
                            for (int k = i-1; k >= 0; k--) {
                                if(board[k][j]=='X'){
                                    isVisited[k][j] = true;
                                }
                                else{
                                    break;
                                }
                            }
                        }
                    }
                    // 查看下边的邻居是否为X
                    if(i+1<m){
                        if(board[i+1][j]=='X'){
                            for(int k=i+1;k<m;k++){
                                if (board[k][j] == 'X') {
                                    isVisited[k][j] = true;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

