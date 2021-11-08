import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // 数组长度为n
        // 1<=nums[i]<=n
        // 所以当第一次遇到某个元素k=nums[i]时，将nums[k-1]置为-1
        // 当检测到某个元素为负数时，则说明遇到重复的了则将k放入res中
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int n=nums[i]>=0?nums[i]:-nums[i];
            if(nums[n-1]<0){
                res.add(n);
            }else{
                nums[n-1]*=-1;
            }
        }
        return res;
    }
}
// @lc code=end

