import java.util.ArrayList;

/*
 * @lc app=leetcode id=561 lang=java
 *
 * [561] Array Partition I
 */

// @lc code=start
class Solution {
    public int arrayPairSum(int[] nums) {
        int count=0;
        ArrayList<Integer> val = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            val.add(nums[i]);
        }
        val.sort(Comparator.naturalOrder());
        for(int i=0;i<val.size();i+=2){
            count+=val.get(i);
        }
        return count;
    }
}
// @lc code=end

