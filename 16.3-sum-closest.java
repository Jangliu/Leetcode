import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int l, r, sum, temCha;

        int n = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        int cha = Math.abs(target - result);
        
        for(int i = 0; i < n - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            else{
                l = i + 1;
                r = n - 1;
                while(l < r){
                    sum = nums[i] + nums[l] + nums[r];
                    if(sum == target){
                        return target;
                    }else{
                        temCha = Math.abs(sum - target);
                        if(cha > temCha){result = sum; cha = temCha;}
                        if(sum < target) l++;
                        else r--;
                    }           
                }
            }  
        }
        return result;
    }
}

// @lc code=end

