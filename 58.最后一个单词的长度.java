/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int i;
        for (i = length - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }
        if (i == -1) {
            return 0;
        }
        int num = 0;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                num++;
            } else {
                break;
            }
        }
        return num;
    }
}
// @lc code=end

