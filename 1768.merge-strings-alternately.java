/*
 * @lc app=leetcode id=1768 lang=java
 *
 * [1768] Merge Strings Alternately
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer res = new StringBuffer();
        int i=0;
        while(i<Math.max(word1.length(), word2.length())){
            if(i<word1.length()){
                res.append(word1.charAt(i));
            }
            if(i<word2.length()){
                res.append(word2.charAt(i));
            }
            i++;
        }
        return res.toString();
    }
}
// @lc code=end

