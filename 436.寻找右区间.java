import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start
class Solution {
    // O(n) 的解
    public int[] findRightInterval(int[][] intervals) {

        int N = intervals.length;
        int[] ans = new int[N];
        int min = -1000000;
        int minStart = 1000000;
        int maxEnd = min;
        for (int[] interval : intervals) {
            minStart = Math.min(minStart, interval[0]);
            maxEnd = Math.max(maxEnd, interval[1]);
        }
        // map中记录的是 大于等于某个数为start的区间在哪个下标
        int[] startIndexMap = new int[maxEnd - minStart + 1];
        Arrays.fill(startIndexMap, min);
        for (int i = 0; i < N; i++) {
            startIndexMap[intervals[i][0] - minStart] = i;
        }
        for (int i = startIndexMap.length - 2; i >= 0; i--) {
            // 如果没有以某个数开始的区间，那以它开始的位置和以比它大1的位置一样
            if (startIndexMap[i] == min) {
                startIndexMap[i] = startIndexMap[i + 1];
            }
        }
        for (int i = 0; i < N; i++) {
            // 找到以end为开始的区间的下标
            int index = startIndexMap[intervals[i][1] - minStart];
            ans[i] = index == min ? -1 : index;
        }
        return ans;
    }
}

// @lc code=end

