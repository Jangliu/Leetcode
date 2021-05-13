/*
 * @lc app=leetcode id=1624 lang=java
 *
 * [1624] Largest Substring Between Two Equal Characters
 */

// @lc code=start
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] csp = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int[] cep = new int[26];
        int res=-1;
        for(int i=0;i<s.length();i++){
            if(csp[s.charAt(i)-'a']!=-1){
                cep[s.charAt(i)-'a']=i;
            }
            else{
                csp[s.charAt(i)-'a']=i;
            }
        }
        for(int i=0;i<26;i++){
            if(csp[i]!=-1&&cep[i]!=0){
                res = Math.max(res, cep[i] - csp[i] - 1);
            }
        }
        return res;
    }
}
// @lc code=end

