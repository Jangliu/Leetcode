/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        //注意，split函数的参数是一个正则表达式
        String[] words = s.split(" +");
        StringBuffer res = new StringBuffer();
        res.append(words[words.length - 1]);
        for (int i = words.length - 2; i >= 0; i--) {
            res.append(" ");
            res.append(words[i]);
        }
        return res.toString();
    }
}
// @lc code=end

