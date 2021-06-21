import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //对intervals进行排序，按intervals[i][0]作升序排序
        //也就是说把这些区间的起点进行升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                //当已合并区间为0的时候把现在遍历的这个区间加进去
                //当当前这个区间在可合并区间的右边（由于排序了，所以肯定在右边）
                //加入当前区间
                merged.add(new int[] { L, R });
            } else {
                //有可以合并的，由于当前已合并的区间的起点必定是最小的，所以只需要修改终点即可
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
// @lc code=end

