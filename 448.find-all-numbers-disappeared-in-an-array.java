/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int[] number = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            number[nums[i]-1]=1;
        }
        for(int i=0;i<number.length;i++){
            if(number[i]==0){
                result.add(i+1);
            }
        }
        return result;
    }
}
// @lc code=end

