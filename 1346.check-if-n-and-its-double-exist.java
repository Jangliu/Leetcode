import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=1346 lang=java
 *
 * [1346] Check If N and Its Double Exist
 */

// @lc code=start
class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet();
        for (int n : arr) {
            if (set.contains(2 * n) || (n % 2 == 0 && set.contains(n / 2)))
                return true;
            set.add(n);
        }
        return false;
    }
}
// @lc code=end

