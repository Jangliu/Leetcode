/*
 * @lc app=leetcode id=1332 lang=java
 *
 * [1332] Remove Palindromic Subsequences
 */

// @lc code=start
class Solution {
    public int removePalindromeSub(String S) {
        //stupid problem
        if (S.length() == 0)
            return 0;
        for (int i = 0, j = S.length() - 1; i < j; i++, j--)
            if (S.charAt(i) != S.charAt(j))
                return 2;
        return 1;
    }
}
// @lc code=end

