import java.math.BigDecimal;
import java.text.DecimalFormat;

/*
 * @lc app=leetcode id=1491 lang=java
 *
 * [1491] Average Salary Excluding the Minimum and Maximum Salary
 */

// @lc code=start
class Solution {
    public double average(int[] salary) {
        //注意java中除法的坑
        int sum=0;
        int min=1000001;
        int max=999;
        for(int n:salary){
            min=Math.min(n, min);
            max=Math.max(n, max);
            sum+=n;
        }
        return (double)(sum-min-max)/(double)(salary.length-2);
    }
}
// @lc code=end

