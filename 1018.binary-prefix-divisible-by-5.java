import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1018 lang=java
 *
 * [1018] Binary Prefix Divisible By 5
 */

// @lc code=start
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int s = 0;
        for (int i : A){
            result.add((s = (s * 2 + i) % 5) == 0);
        }
        return result;
    }
}
// @lc code=end

