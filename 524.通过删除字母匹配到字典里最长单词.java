import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        // 假定当前需要匹配字符 c，而字符 c 在 s 中的位置 x1​ 和 x2出现（x1<x2），
        // 那么贪心取 x1 是最优解，因为 x2 后面能取到的字符，x1也都能取到
        // 并且通过 x1与 x2之间的可选字符，更有希望能匹配成功。
        int m = s.length();
        int[][] f = new int[m + 1][26];
        // f[i][j]表示i位置之后每一个字符第一次出现的位置
        Arrays.fill(f[m], m);

        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < 26; ++j) {
                if (s.charAt(i) == (char) ('a' + j)) {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        String res = "";
        for (String t : dictionary) {
            boolean match = true;
            int j = 0;
            for (int i = 0; i < t.length(); ++i) {
                if (f[j][t.charAt(i) - 'a'] == m) {
                    match = false;
                    break;
                }
                j = f[j][t.charAt(i) - 'a'] + 1;
            }
            if (match) {
                if (t.length() > res.length() ||  (t.length() == res.length() && t.compareTo(res) < 0)) {
                    res = t;
                }
            }
        }
        return res;
    }
}
// @lc code=end

