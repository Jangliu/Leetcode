/*
 * @lc app=leetcode id=1758 lang=java
 *
 * [1758] Minimum Changes To Make Alternating Binary String
 */

// @lc code=start
class Solution {
    public int minOperations(String s) {
        char[] val = new char[s.length()];
        val[0]=s.charAt(0);
        int res=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==val[i-1]){
                if(val[i-1]=='1'){
                    val[i]='0';
                }
                else{
                    val[i]='1';
                }
                res++;
            }
            else{
                val[i]=s.charAt(i);
            }
        }
        return Math.min(res, s.length()-res);
    }
}
// @lc code=end

