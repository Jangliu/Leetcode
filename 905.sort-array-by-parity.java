import java.util.ArrayList;

/*
 * @lc app=leetcode id=905 lang=java
 *
 * [905] Sort Array By Parity
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int sp=0;
        int ep=A.length-1;
        int[] result=new int[A.length];
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                result[sp]=A[i];
                sp++;
            }
            else{
                result[ep]=A[i];
                ep--;
            }
        }
        return result;
    }
}
// @lc code=end

