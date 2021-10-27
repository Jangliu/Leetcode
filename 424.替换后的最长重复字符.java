import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        // 使用双指针的滑动窗口来解决
        // num记录当前窗口中出现过的字符的个数
        char[] c = s.toCharArray();
        int[] num = new int[26];
        // 本窗口中出现次数最多的字符的数量
        int maxn = 0;
        int left = 0, right = 0;
        // 当右端点没有抵达字符串的终点时
        while (right < c.length) {
            // 将此时右端点的字符加入到num中
            num[c[right] - 'A']++;
            // 记录最大数量（要么是之前的最大数量，要么是刚移进来的右端点的字符的个数）
            maxn = Math.max(maxn, num[c[right] - 'A']);
            // 判断左端点是否需要右移
            // 假设本区间内出现次数最多的字符是A
            // 那么假设本区间除A以外的其他字符数量大于K
            // 那么就说明即使全部替换，也无法使本区间全部是A
            // 那么就需要把左端点右移一位，然后要更新num
            if (right - left + 1 - maxn > k) {
                num[c[left] - 'A']--;
                left++;
            }
            // 右端点右移
            right++;
        }
        return right - left;
    }
}


// @lc code=end

