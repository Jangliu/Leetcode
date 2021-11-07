import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res=0;
        Arrays.sort(intervals,new Comparator<int[]>() {
            public int compare(int[] o1,int[] o2){
                if(o1[0]!=o1[0]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        int[] target = intervals[0];
        int i=1;
        for(;i<intervals.length;i++){
            if(intervals[i][0]==target[0]){
                res++;
            }
            else if(intervals[i][0]<=target[1]){
                if(intervals[i][0]==target[1]){
                    target=intervals[i];
                }
                else{
                    res++;
                }
            }else{
                target=intervals[i];
            }
        }
        return res;
    }
}
// @lc code=end

