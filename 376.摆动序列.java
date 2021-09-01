/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        // 寻找转折点，但是要注意一些细节
        // 不能直接比较某点和左右的大小，因为可能会遇到两个连续的相同的数
        if(nums.length==1){
            return 1;
        }
        if(nums.length==2){
            return nums[0]==nums[1]?1:2;
        }
        int sp=-1;
        int count = 2;
        int flag = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                sp=i;
                flag = nums[i]<nums[i+1]?1:-1;
                break;
            }
        }
        if(sp==-1){
            return 1;
        }
        int i=sp+2;
        while(i<nums.length){
            if((nums[i]-nums[i-1])*flag<0){
                i++;
            }
            else{
                while(i<nums.length&&(nums[i]-nums[i-1])*flag>=0){
                    i++;
                }
                if(i>=nums.length){
                    return count;
                }
            }
            count++;
            flag = flag==1?-1:1;
        }
        return count;
    }
}
// @lc code=end

