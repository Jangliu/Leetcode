/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        StringBuffer buffer = new StringBuffer();
        int[] digitS = new int[10];
        int[] digitG = new int[10];
        char[] s=secret.toCharArray();
        char[] g=guess.toCharArray();
        int count=0;
        for(int i=0;i<s.length;i++){
            digitS[s[i]-'0']++;
            digitG[g[i]-'0']++;
            if(s[i]==g[i]){
                count++;
            }
        }
        int temp = 0;
        for(int i=0;i<10;i++){
            temp+=Math.min(digitG[i], digitS[i]);
        }
        buffer.append(String.valueOf(count));
        buffer.append("A");
        buffer.append(String.valueOf(temp-count));
        buffer.append("B");
        return buffer.toString();
    }
}
// @lc code=end

