import java.util.ArrayList;

/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        ArrayList<Integer> val = new ArrayList<Integer>();
        while (true) {
            if (val.contains(Integer.valueOf(n))) {
                return false;
            }
            val.add(n);
            int count = 0;
            int rest = n % 10;
            count += rest * rest;
            while (n / 10 > 0) {
                n = (n - rest) / 10;
                rest = n % 10;
                count += rest * rest;
            }
            n = count;
            if (n == 1) {
                return true;
            }
        }
    }
}
// @lc code=end

