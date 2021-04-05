import java.util.HashMap;

/*
 * @lc app=leetcode id=748 lang=java
 *
 * [748] Shortest Completing Word
 */

// @lc code=start
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        licensePlate = licensePlate.toLowerCase();
        String result = "aaaaaaaaaaaaaaaaaaaa";
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (c < 97 || c > 122) {
                continue;
            }
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.replace(c, map.get(c) + 1);
            }
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            HashMap<Character, Integer> val = new HashMap<Character, Integer>();
            for (int j = 0; j < word.length(); j++) {
                if (!val.containsKey(word.charAt(j))) {
                    val.put(word.charAt(j), 1);
                } else {
                    val.replace(word.charAt(j), val.get(word.charAt(j)) + 1);
                }
            }
            boolean flag = true;
            for (char c : map.keySet()) {
                if (val.containsKey(c) && val.get(c) >= map.get(c)) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag && word.length() < result.length()) {
                result = word;
            }
        }
        return result;
    }
}
// @lc code=end

