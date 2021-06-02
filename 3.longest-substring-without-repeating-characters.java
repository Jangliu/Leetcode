import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.stream.events.Characters;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //思想与我的方法类似
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
                //当没有出现重复元素时就一直往后走。
            } else {
                set.remove(s.charAt(i++));
                //当出现重复元素，那么重复元素就会有两个坐标，x1和x2，此时x2=j
                //那么就要把x1(及其之前)的所有元素都删掉，这样相当于把原来的字符串截去前面一部分
                //再计算后面一部分的最长子串。
            }
        }

        return max;
    }
}
// @lc code=end

