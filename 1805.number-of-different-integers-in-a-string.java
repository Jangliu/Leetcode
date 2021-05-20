import java.util.HashSet;

/*
 * @lc app=leetcode id=1805 lang=java
 *
 * [1805] Number of Different Integers in a String
 */

// @lc code=start
class Solution {
    public int numDifferentIntegers(String word) {
        StringBuffer buffer = new StringBuffer();
        HashSet<String> set = new HashSet<>();
        char last = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                if (last == 0) {
                    continue;
                }
                if (last != ' ') {
                    last = ' ';
                    buffer.append(" ");
                }
                continue;
            }
            last = word.charAt(i);
            buffer.append(word.charAt(i));
        }
        if (buffer.length() == 0) {
            return 0;
        }
        String[] temp = buffer.toString().split(" ");
        for (int i = 0; i < temp.length; i++) {
            int j = 0;
            for (; j < temp[i].length(); j++) {
                if (temp[i].charAt(j) != '0') {
                    break;
                }
            }
            if (j == temp[i].length()) {
                temp[i] = "0";
            } else {
                temp[i] = temp[i].substring(j, temp[i].length());
            }
        }
        for (String s : temp) {
            set.add(s);
        }
        return set.size();
    }
}
// @lc code=end

