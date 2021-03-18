/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('u');
        vowels.add('o');
        vowels.add('i');
        vowels.add('e');
        vowels.add('A');
        vowels.add('U');
        vowels.add('O');
        vowels.add('I');
        vowels.add('E');

        int i = 0, j = s.length() - 1;
        char[] ss = s.toCharArray();

        while (i < j) {
            if (!vowels.contains(ss[i]))
                i++;
            else if (!vowels.contains(ss[j]))
                j--;
            else {
                char t = ss[i];
                ss[i] = ss[j];
                ss[j] = t;

                i++;
                j--;
            }
        }

        return String.valueOf(ss);
    }
}
// @lc code=end

