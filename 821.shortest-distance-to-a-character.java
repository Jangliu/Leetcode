import java.util.ArrayList;

/*
 * @lc app=leetcode id=821 lang=java
 *
 * [821] Shortest Distance to a Character
 */

// @lc code=start
class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] result = new int[s.length()];
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                pos.add(i);
            }
        }
        int p = 0;
        int indexFront = -10000;
        int indexBack = pos.get(p);
        for (int i = 0; i < result.length; i++) {
            if (indexBack < i) {
                if (p < pos.size() - 1) {
                    p++;
                    indexFront = indexBack;
                    indexBack = pos.get(p);
                } else {
                    indexFront = indexBack;
                    indexBack = Integer.MAX_VALUE;
                }
            }
            result[i] = Math.min(i - indexFront, indexBack - i);
        }
        return result;
    }
}
// @lc code=end

