/*
 * @lc app=leetcode id=557 lang=java
 *
 * [557] Reverse Words in a String III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String result = "";
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)!=' '){
                int j=i;
                for(;j<s.length();j++){
                    if(s.charAt(j)==' '){
                        break;
                    }
                }
                char[] c=new char[j-i];
                for(int k=i;k<j;k++){
                    c[k-i]=s.charAt(j-1-k+i);
                }
                result+= new String(c);
                i=j;
                continue;
            }
            result += " ";
            i++;
        }
        return result;
    }
}
// @lc code=end

