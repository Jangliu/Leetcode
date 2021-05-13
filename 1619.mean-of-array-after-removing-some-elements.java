import java.util.Arrays;

/*
 * @lc app=leetcode id=1619 lang=java
 *
 * [1619] Mean of Array After Removing Some Elements
 */

// @lc code=start
class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int ret = arr.length/20;
        double res=0;
        for(int i=ret;i<arr.length-ret;i++){
            res+=arr[i];
        }
        return res/(double)(arr.length-2*ret);
    }
}
// @lc code=end

