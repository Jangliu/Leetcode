/*
 * @lc app=leetcode id=804 lang=java
 *
 * [804] Unique Morse Code Words
 */

// @lc code=start
class Solution {
    //stupid question
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
                ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--.." };
        Set<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray())
                sb.append(arr[ch - 'a']);
            set.add(sb.toString());
        }

        return set.size();
    }
}
// @lc code=end

