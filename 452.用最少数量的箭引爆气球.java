import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 对所有气球按照右边界从小到大的顺序进行排列
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        // 假设在pos位置射出一支箭，那么所有左边界小于等于pos的都会被射爆
        // 按照右边界递增排序可以保证只要左边界小于等于pos，就可以被射爆
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            // 当遇到无法射爆的，那么就换一支新的箭
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}

// @lc code=end

