import java.util.ArrayList;
import java.util.List;

import jdk.vm.ci.aarch64.AArch64.Flag;

/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 */

// @lc code=start
class Solution {
    boolean[][] pacificAtlanticPVisited;
    boolean[][] pacificAtlanticAVisited;
    List<List<Integer>> pacificAtlanticResult;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        pacificAtlanticResult = new ArrayList<>();
        int M = heights.length, N = heights[0].length;
        pacificAtlanticPVisited = new boolean[M][N];
        pacificAtlanticAVisited = new boolean[M][N];
        // 左右 + 上下两边dfs
        // left right
        for (int i = 0; i < M; i++) {
            pacificAtlanticDfs(heights, pacificAtlanticPVisited, i, 0);
            pacificAtlanticDfs(heights, pacificAtlanticAVisited, i, N - 1);
        }
        // top bottom
        for (int j = 0; j < N; j++) {
            pacificAtlanticDfs(heights, pacificAtlanticPVisited, 0, j);
            pacificAtlanticDfs(heights, pacificAtlanticAVisited, M - 1, j);
        }
        return pacificAtlanticResult;
    }

    void pacificAtlanticDfs(int[][] heights, boolean[][] visited, int row, int col) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        // 大西洋和太平洋 都遍历过这点 满足条件
        if (pacificAtlanticPVisited[row][col] && pacificAtlanticAVisited[row][col]) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(row);
            tmp.add(col);
            pacificAtlanticResult.add(tmp);
        }

        if (row - 1 >= 0 && heights[row - 1][col] >= heights[row][col]) {
            pacificAtlanticDfs(heights, visited, row - 1, col);
        }

        if (row + 1 < heights.length && heights[row + 1][col] >= heights[row][col]) {
            pacificAtlanticDfs(heights, visited, row + 1, col);
        }

        if (col - 1 >= 0 && heights[row][col - 1] >= heights[row][col]) {
            pacificAtlanticDfs(heights, visited, row, col - 1);
        }

        if (col + 1 < heights[0].length && heights[row][col + 1] >= heights[row][col]) {
            pacificAtlanticDfs(heights, visited, row, col + 1);
        }
    }
}

// @lc code=end

