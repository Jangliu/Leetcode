import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    private int minMutationRes = Integer.MAX_VALUE;
    // 整体思路为遍历每一种路径，如果可以抵达目标就记录步数，最后取步数最小值
    public int minMutation(String start, String end, String[] bank) {
        // 使用Map是为了找到目标的时候直接获取步数
        HashMap<Integer, Boolean> visited = new HashMap<>();
        minMutationDfs(start, end, visited, bank);
        return minMutationRes == Integer.MAX_VALUE ? -1 : minMutationRes;
    }

    private void minMutationDfs(String root, String result, HashMap<Integer, Boolean> visited, String[] bank) {
        if (root.equals(result)) {
            minMutationRes = Math.min(minMutationRes, visited.size());
            return;
        }

        for (int i = 0; i < bank.length; i++) {
            if (visited.get(i) != null || !canChange(root, bank[i])) {
                continue;
            }
            visited.put(i, true);
            minMutationDfs(bank[i], result, visited, bank);
            visited.remove(i);
        }
    }

    private boolean canChange(String one, String two) {
        int different = 0;
        for (int index = 0; index < 8; index++) {
            char first = one.charAt(index);
            char second = two.charAt(index);
            if (first == second) {
                continue;
            }
            if (different >= 1) {
                return false;
            }
            different++;
        }
        return different == 1;
    }
}

// @lc code=end

