import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        //dp[i]记录字符串s的前i个字符组成的字符串s[0...i-1]是否可以被拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //如果前j个字符组成的字符串可以被拆分
                //并且字典中包含字符串s[j...i-1]
                //说明前i个字符组成的字符串可以背拆分
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

// @lc code=end

