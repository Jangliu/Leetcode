import java.util.Arrays;

/*
 * @lc app=leetcode id=1356 lang=java
 *
 * [1356] Sort Integers by The Number of 1 Bits
 */

// @lc code=start
class Solution {
    public int[] sortByBits(int[] arr) {
        int[][] rank = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            rank[i][0] = arr[i];
            int a = arr[i];
            int count = 0;
            while (a > 0) {
                if ((a & 1) == 1) {
                    count++;
                }
                a = a >> 1;
            }
            rank[i][1] = count;
        }
        for (int i = 1; i < rank.length; i++) {
            for (int j = 0; j < rank.length - i; j++) {
                if (rank[j][1] > rank[j + 1][1] || (rank[j][1] == rank[j + 1][1] && rank[j][0] > rank[j + 1][0])) {
                    int[] temp = rank[j + 1];
                    rank[j + 1] = rank[j];
                    rank[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank[i][0];
        }
        return arr;
    }
}
// @lc code=end

