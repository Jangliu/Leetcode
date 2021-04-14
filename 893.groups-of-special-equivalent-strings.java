import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=893 lang=java
 *
 * [893] Groups of Special-Equivalent Strings
 */

// @lc code=start
class Solution {
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> set = new HashSet<>();
        int result = 0;
        for (String str : A) {
            if (set.add(getHashBySwap(str.toCharArray()))) {
                result++;
            }
        }
        return result;
    }

    private String getHashBySwap(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 2; j < chars.length;) {
                if (chars[i] > chars[j]) {
                    char temp = chars[j];
                    chars[j] = chars[i];
                    chars[i] = temp;
                }
                j += 2;
            }
        }
        //这个循环的意义在于，将这个字符数组的奇数下标和偶数下标都按照从小到大的顺序重新排列
        //如果两个字符串特殊相等，那么经过如此排列，他们两个一定会相等。

        return String.valueOf(chars);
    }

}
// @lc code=end

