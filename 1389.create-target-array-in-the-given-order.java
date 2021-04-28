import java.util.ArrayList;

/*
 * @lc app=leetcode id=1389 lang=java
 *
 * [1389] Create Target Array in the Given Order
 */

// @lc code=start
class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> result = new ArrayList<>();
        int[] val = new int[index.length];
        for(int i=0;i<nums.length;i++){
            result.add(index[i], nums[i]);
        }
        for(int i=0;i<val.length;i++){
            val[i]=result.get(i);
        }
        return val;
    }
}
// @lc code=end

