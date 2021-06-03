import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                // 要加一个不相等判断是为了直接去除重复的项
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) {
                            lo++;
                            //跳过重复项
                        }
                        while (lo < hi && num[hi] == num[hi - 1]) {
                            // 跳过重复项
                            hi--;
                        }
                        //取下一个不同的组合
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        //因为数组是排过序的，所以要往和更大的方向走
                        lo++;
                    } else {
                        // 因为数组是排过序的，所以要往和更小的方向走
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

