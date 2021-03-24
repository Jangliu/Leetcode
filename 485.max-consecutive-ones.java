import org.graalvm.compiler.lir.LIRInstruction.Temp;

/*
 * @lc app=leetcode id=485 lang=java
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int i =0;
        for(;i<nums.length;i++){
            if(nums[i]!=0){
                int temp = 0;
                int j=i;
                for(;j<nums.length;j++){
                    if(nums[j]==0){
                        break;
                    }
                    temp+=nums[j];
                }
                count=Math.max(temp, count);
                i=j;
            }
        }
        return count;
    }
}
// @lc code=end

