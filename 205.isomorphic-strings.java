/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

import java.util.HashMap;
// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        return singleCheck(s, t) && singleCheck(t, s);
    }
    public static boolean singleCheck(String s,String t){
        HashMap<Character, Character> Map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (Map.containsKey(s.charAt(i)) && (Map.get(s.charAt(i)) != t.charAt(i))) {
                return false;
            }
            Map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}
// @lc code=end

