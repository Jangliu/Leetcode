import org.graalvm.compiler.replacements.arraycopy.ArrayCopy;

/*
 * @lc app=leetcode id=1566 lang=java
 *
 * [1566] Detect Pattern of Length M Repeated K or More Times
 */

// @lc code=start
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int count=0;
        for(int i=0,j=i+m;j<arr.length;i++,j++){
            if(arr[i]!=arr[j]){
                count=0;
            }
            else{
                count++;
                if(count==(k-1)*m){
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

