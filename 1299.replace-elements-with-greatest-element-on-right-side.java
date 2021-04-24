import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode id=1299 lang=java
 *
 * [1299] Replace Elements with Greatest Element on Right Side
 */

// @lc code=start
class Solution {
    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        int maxValue = -1;
        for(int x = arr.length-1; x >=0; x--) {
        	result[x] = maxValue;
        	maxValue = Math.max(arr[x], maxValue);
        }
        return result;
    }
}
// @lc code=end

