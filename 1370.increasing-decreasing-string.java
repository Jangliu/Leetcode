import java.util.HashMap;

/*
 * @lc app=leetcode id=1370 lang=java
 *
 * [1370] Increasing Decreasing String
 */

// @lc code=start
class Solution {
    public String sortString(String s) {
        StringBuffer result = new StringBuffer();
        int n=s.length();
        char[] c = new char[26];
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'a']++;
        }
        while(n>0){
            for(int i=0;i<26;i++){
                if(c[i]!=0){
                    result.append((char)(i+'a'));
                    c[i]--;
                    n--;
                }
            }
            if(n<=0){
                break;
            }
            for(int i=25;i>=0;i--){
                if (c[i] != 0) {
                    result.append((char) (i + 'a'));
                    c[i]--;
                    n--;
                }
            }
        }
        return result.toString();
    }
}
// @lc code=end

