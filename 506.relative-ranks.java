import java.util.ArrayList;

/*
 * @lc app=leetcode id=506 lang=java
 *
 * [506] Relative Ranks
 */

// @lc code=start
class Solution {
    public String[] findRelativeRanks(int[] score) {
        ArrayList<Integer> val = new ArrayList<Integer>();
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            val.add(score[i]);
        }
        val.sort(Comparator.reverseOrder());
        for (int i = 0; i < score.length; i++) {
            if (val.indexOf(Integer.valueOf(score[i])) + 1 == 1) {
                result[i] = "Gold Medal";
                continue;
            }
            if (val.indexOf(Integer.valueOf(score[i])) + 1 == 2) {
                result[i] = "Silver Medal";
                continue;
            }
            if (val.indexOf(Integer.valueOf(score[i])) + 1 == 3) {
                result[i] = "Bronze Medal";
                continue;
            } else {
                result[i] = String.valueOf(val.indexOf(Integer.valueOf(score[i])) + 1);
            }
        }
        return result;
    }
}
// @lc code=end

