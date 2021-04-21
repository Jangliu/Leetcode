import java.util.ArrayList;

/*
 * @lc app=leetcode id=1078 lang=java
 *
 * [1078] Occurrences After Bigram
 */

// @lc code=start
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> s = new ArrayList<>();
        String[] words = text.split(" ");
        for(int i=0;i<words.length-2;i++){
            if(words[i].equals(first)&&words[i+1].equals(second)){
                s.add(words[i+2]);
            }
        }
        return s.toArray(new String[s.size()]);
    }
}
// @lc code=end

