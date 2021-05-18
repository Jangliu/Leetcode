import java.util.HashMap;

/*
 * @lc app=leetcode id=1748 lang=java
 *
 * [1748] Sum of Unique Elements
 */

// @lc code=start
class Solution {
    public int sumOfUnique(int[] nums) {
        int res=0;
        int[] val = new int[101];
        for(int n:nums){
            val[n]++;
        }
        for(int i=0;i<val.length;i++){
            if(val[i]==1){
                res+=i;
            }
        }
        return res;
    }    
}

// @lc code=end

