/*
 * @lc app=leetcode id=1576 lang=java
 *
 * [1576] Replace All ?'s to Avoid Consecutive Repeating Characters
 */

// @lc code=start
class Solution {
    public String modifyString(String s) {
        if (s == null || s.isEmpty())
            return "";

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                for (char j = 'a'; j <= 'z'; j++) {
                    chars[i] = j;
                    if (i > 0 && chars[i - 1] == j)
                        continue;
                    if (i < chars.length - 1 && chars[i + 1] == j)
                        continue;
                    break;
                }
            }
        }

        return new String(chars);
    }
}
// @lc code=end

