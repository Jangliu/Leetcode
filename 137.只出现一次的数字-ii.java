import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int num:nums){
            if(set.add(num)){
                res.add(num);
            }
            else{
                res.remove(num);
            }
        }
        for(int i:res){
            return i;
        }
        return 0;
    }
}
// @lc code=end

