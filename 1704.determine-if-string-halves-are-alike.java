/*
 * @lc app=leetcode id=1704 lang=java
 *
 * [1704] Determine if String Halves Are Alike
 */

// @lc code=start
class Solution {
    String vowels = "aeiouAEIOU";
    public boolean halvesAreAlike(String S) {
        int mid = S.length() / 2, ans = 0;
        for (int i = 0, j = mid; i < mid; i++, j++) {
            if (vowels.indexOf(S.charAt(i)) >= 0)
                ans++;
            if (vowels.indexOf(S.charAt(j)) >= 0)
                ans--;
        }
        return ans == 0;
    }
}
// @lc code=end

