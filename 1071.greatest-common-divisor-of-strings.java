import java.util.ArrayList;

/*
 * @lc app=leetcode id=1071 lang=java
 *
 * [1071] Greatest Common Divisor of Strings
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        //如果str1和str2都满足条件，那么
        //str1=s*p
        //str2=s*q,
        //s为输出的结果
        //每次用str1和str2里长的那个减去短的那个，再将减去的结果和短的那个再进行操作，直到找出最长的s
        while (!str2.isEmpty()) {
            if (str1.equals(str2)) {
                return str1;
            }

            // swap to make str1 longer than str2
            if (str1.length() < str2.length()) {
                String tmp = str1;
                str1 = str2;
                str2 = tmp;
            }

            if (str1.substring(0, str2.length()).equals(str2)) {
                String r = str1.substring(str2.length());

                str1 = str2;
                str2 = r;

            } else {
                return "";
            }
        }

        return str1;

    }
}
// @lc code=end

