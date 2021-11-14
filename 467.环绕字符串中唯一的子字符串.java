/*
 * @lc app=leetcode.cn id=467 lang=java
 *
 * [467] 环绕字符串中唯一的子字符串
 */

// @lc code=start
class Solution {
    // 说明：
    // 假设以d结尾的最长连续子串为abcd,
    // 那么，这个最长连续子串就包含了 d,cd,bcd,abcd这四个以d结尾的子串
    // 子串个数等于最长连续子串长度
    // 这样就完成了最核心的去重
    public int findSubstringInWraproundString(String p) {
        int res=0;
        int n = p.length();
        // 记录 p 中以每个下标i处的字符array[i]结尾的最长连续子串的长度
        int[] dp = new int[n];
        dp[0]=1;
        char[] array = p.toCharArray();
        // 遍历 p 中的所有字符
        for (int i = 1; i < array.length; i++) {
            // 以下标i出的字符array[i]为结尾的最长连续子串的长度最少为1
            dp[i] = 1;
            // 如果下标i-1到下标i是连续，比如从'z'到'a',从'c'到'd'
            if((array[i]=='a'&&array[i-1]=='z')||(array[i]-array[i-1])==1){
                dp[i]+=dp[i-1];
            }
        }
        int[] map = new int[26];
        // map记录以每个字符为结尾的最长子串的长度
        for(int i=0;i<n;i++){
            map[array[i]-'a']=Math.max(map[array[i]-'a'], dp[i]);
        }
        for(int num:map){
            res+=num;
        }
        return res;
    }
}
// @lc code=end

