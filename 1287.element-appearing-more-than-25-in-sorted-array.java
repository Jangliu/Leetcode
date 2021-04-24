/*
 * @lc app=leetcode id=1287 lang=java
 *
 * [1287] Element Appearing More Than 25% In Sorted Array
 */

// @lc code=start
class Solution {
    public int findSpecialInteger(int[] arr) {
        int num = arr.length/4+1;
        int c = arr[0];
        int count = num;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==c){
                count=count-1;
                if(count==0){
                    return c;
                }
            }
            else{
                c=arr[i];
                count=num-1;
            }
        }
        return 0;
    }
}
// @lc code=end

