import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        // 对于任意一个字符串s，找到最小的满足s[i]>s[i+1]的下标i
        // 去除s[i]则可以使得s的字典序最小
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        // 统计各个字母出现的次数
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        // 维护一个栈结构
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 当ch没有在栈中时
            if (!vis[ch - 'a']) {
                // 寻找最小的需要去除的下标
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                // 将ch入栈
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
// @lc code=end

