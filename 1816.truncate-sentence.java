/*
 * @lc app=leetcode id=1816 lang=java
 *
 * [1816] Truncate Sentence
 */

// @lc code=start
class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");
        if(k>=words.length){
            return s;
        }
        StringBuffer res = new StringBuffer();
        for(int i=0;i<k;i++){
            res.append(words[i]);
            if(i!=k-1){
                res.append(" ");
            }
        }
        return res.toString();
    }
}
// @lc code=end

