import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=1013 lang=java
 *
 * [1013] Partition Array Into Three Parts With Equal Sum
 */

// @lc code=start
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();

        // if the total sum doesn't divide into three, return false
        if (sum % 3 != 0)
            return false;
        int each = sum / 3, temp = 0, found = 0;

        // count parts with right sum
        for (int i = 0; i < arr.length; i++) {
            temp += arr[i];
            if (temp == each) {
                temp = 0;
                found++;
            }
        }
        return found >= 3 ? true : false;
    }
}
// @lc code=end

