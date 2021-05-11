import java.util.Arrays;

/*
 * @lc app=leetcode id=1502 lang=java
 *
 * [1502] Can Make Arithmetic Progression From Sequence
 */

// @lc code=start
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int difference = arr[1]-arr[0];
        for(int i=2;i<arr.length;i++){
            if(arr[i]-arr[i-1]!=difference){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

