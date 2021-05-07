/*
 * @lc app=leetcode id=1455 lang=java
 *
 * [1455] Check If a Word Occurs As a Prefix of Any Word in a Sentence
 */

// @lc code=start
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int result = -1;
        String[] words=sentence.split(" ");
        for(int i=0;i<words.length;i++){
            if(words[i].length()>=searchWord.length()){
                if(words[i].indexOf(searchWord)==0){
                    return i+1;
                }
            }
        }
        return result; 
    }
}
// @lc code=end

