import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1560 lang=java
 *
 * [1560] Most Visited Sector in  a Circular Track
 */

// @lc code=start
class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        List<Integer> res = new ArrayList<Integer>();
        //直接看起点那个人序号start的和终点的那个人序号end，
        //1.如果start>end那说明在经过n轮循环之后，start~end这几个人都被访问了n+1次
        //2.如果start<end那说明在经过n轮循环之后，1~end和start~n这个人被访问了n+1次
        if (start <= end) {
            for (int i = start; i <= end; i++)
                res.add(i);
        } else {
            for (int i = 1; i <= end; i++)
                res.add(i);
            for (int i = start; i <= n; i++)
                res.add(i);
        }
        return res;
    }
}
// @lc code=end

