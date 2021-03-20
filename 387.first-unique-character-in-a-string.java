import java.util.HashMap;

/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.replace(s.charAt(i), -1);
                continue;
            }
            map.put(s.charAt(i), i);
        }
        int count=s.length();
        for(Character key:map.keySet()){
            if(map.get(key)!=-1){
                count=Math.min(map.get(key), count);
            }
        }
        if(count==s.length()){
            return -1;
        }
        return count;
    }
}
// @lc code=end

