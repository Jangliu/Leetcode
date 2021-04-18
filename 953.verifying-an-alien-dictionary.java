import java.util.HashMap;

/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i), i);
        }
        for(int i=0;i<words.length-1;i++){
            String a=words[i];
            String b=words[i+1];
            for(int j=0;j<Math.min(a.length(),b.length());j++){
                if(map.get(a.charAt(j))<map.get(b.charAt(j))){
                    break;
                }
                if(map.get(a.charAt(j))==map.get(b.charAt(j))){
                    if (j == Math.min(a.length(), b.length()) - 1 && a.length() > b.length()) {
                        return false;
                    }
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

