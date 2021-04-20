/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String S) {
        char[] a = S.toCharArray();
        int end = -1;
        for (char c : a) {
            if (end >= 0 && a[end] == c) {
                --end;
                //遇到相邻且重复的，就往回倒一个
            } else {
                a[++end] = c;
                //不是重复的就往前走一个
            }
        }
        return String.valueOf(a, 0, end + 1);
    }
}
// @lc code=end

