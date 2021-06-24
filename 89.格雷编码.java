import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(1);
        for (int k = 1; k <= n - 1; k++) {
            int originalSize = ans.size();
            for (int i = originalSize - 1; i >= 0; i--) {
                ans.add((int) Math.pow(2, k) + ans.get(i));
            }
        }
        return ans;
    }
}
// @lc code=end

