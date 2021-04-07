/*
 * @lc app=leetcode id=824 lang=java
 *
 * [824] Goat Latin
 */

// @lc code=start
class Solution {
    public String toGoatLatin(String S) {
        String result = "";
        String[] words = S.split(" ");
        int count = 1;
        for (int i = 0; i < words.length; i++) {
            String temp = words[i].toLowerCase();
            if (temp.charAt(0) == 'a' || temp.charAt(0) == 'e' || temp.charAt(0) == 'i' || temp.charAt(0) == 'o'
                    || temp.charAt(0) == 'u') {
                result = result + words[i] + "ma";
                for (int j = 0; j < count; j++) {
                    result = result + "a";
                }
                count++;
                if (i != words.length - 1) {
                    result = result + " ";
                }
            } else {
                result = result + words[i].substring(1, words[i].length()) + words[i].substring(0, 1);
                result = result + "ma";
                for (int j = 0; j < count; j++) {
                    result = result + "a";
                }
                count++;
                if (i != words.length - 1) {
                    result = result + " ";
                }
            }
        }
        return result;
    }
}
// @lc code=end

