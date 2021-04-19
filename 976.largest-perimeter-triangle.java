import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * @lc app=leetcode id=976 lang=java
 *
 * [976] Largest Perimeter Triangle
 */

// @lc code=start
class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int x, y, z;
        for (int i = A.length - 1; i >= 2; i--)
            if ((x = A[i]) < (y = A[i - 1]) + (z = A[i - 2]))
                return x + y + z;

        return 0;
    }
}
// @lc code=end

