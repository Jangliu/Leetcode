import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=1365 lang=java
 *
 * [1365] How Many Numbers Are Smaller Than the Current Number
 */

// @lc code=start
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer> val = new HashMap<>();
        for(int i=0;i<temp.length;i++){
            if(!val.containsKey(temp[i])){
                val.put(temp[i], i);
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=val.get(nums[i]);
        }
        return nums;
    }
}
// @lc code=end

