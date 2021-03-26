/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        String result="";
        int countK=0;
        int count2K=0;
        int i=0;
        while(i<s.length()){
            if(i+2*k<s.length()){
                char[] c =new char[2*k];
                for(int j=i+k-1;j>=i;j--){
                    c[i+k-1-j]=s.charAt(j);
                }
                for(int j=i+k;j<i+2*k;j++){
                    c[j-i]=s.charAt(j);
                }
                result+=new String(c);
                i=i+2*k;
                continue;
            }
            if(i+k<s.length()){
                char[] c=new char[s.length()-i];
                for(int j=i+k-1;j>=i;j--){
                    c[i+k-1-j]=s.charAt(j);
                }
                for(int j=i+k;j<s.length();j++){
                    c[j-i]=s.charAt(j);
                }
                result+=new String(c);
                break;
            }
            char[] c=new char[s.length()-i];
            for(int j=s.length()-1;j>=i;j--){
                c[s.length()-1-j]=s.charAt(j);
            }
            result+=new String(c);
            break;
        }
        return result;
    }
}
// @lc code=end

