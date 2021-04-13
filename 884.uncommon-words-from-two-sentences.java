import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=884 lang=java
 *
 * [884] Uncommon Words from Two Sentences
 */

// @lc code=start
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] wordsA = A.split(" ");
        String[] wordsB = B.split(" ");
        HashMap<String,Integer> words = new HashMap<>();
        for(int i=0;i<wordsA.length;i++){
            if(words.containsKey(wordsA[i])){
                words.replace(wordsA[i], words.get(wordsA[i])+1);
            }
            else{
                words.put(wordsA[i],1);
            }
        }
        for (int i = 0; i < wordsB.length; i++) {
            if (words.containsKey(wordsB[i])) {
                words.replace(wordsB[i], words.get(wordsB[i]) + 1);
            } else {
                words.put(wordsB[i], 1);
            }
        }
        ArrayList<String> s = new ArrayList<>();
        for(String key:words.keySet()){
            if(words.get(key)==1){
                s.add(key);
            }
        }
        return s.toArray(new String[s.size()]);
    }
}
// @lc code=end

