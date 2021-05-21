/*
 * @lc app=leetcode id=1832 lang=java
 *
 * [1832] Check if the Sentence Is Pangram
 */

// @lc code=start
class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] c= new int[26];
        for(int i=0;i<sentence.length();i++){
            c[sentence.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(c[i]==0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

