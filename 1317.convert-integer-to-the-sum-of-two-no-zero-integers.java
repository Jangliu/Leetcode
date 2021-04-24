import jdk.vm.ci.aarch64.AArch64.Flag;

/*
 * @lc app=leetcode id=1317 lang=java
 *
 * [1317] Convert Integer to the Sum of Two No-Zero Integers
 */

// @lc code=start
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];
        for(int i=1;i<=n/2;i++){
            if(containsZero(i)&&containsZero(n-i)){
                result[0]=i;
                result[1]=n-i;
                break;
            }
        }
        return result;
    }
    public boolean containsZero(int n){
        while(n>=10){
            if(n%10==0){
                return false;
            }
            n=n/10;
        }
        if(n%10==0){
            return false;
        }
        return true;
    }
}
// @lc code=end

