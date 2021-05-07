/*
 * @lc app=leetcode id=1460 lang=java
 *
 * [1460] Make Two Arrays Equal by Reversing Sub-arrays
 */

// @lc code=start
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] t = new int[1001];
        int[] a = new int[1001];
        for(int i=0;i<target.length;i++){
            t[target[i]]++;
            a[arr[i]]++;
        }
        for(int i=0;i<1001;i++){
            if(t[i]!=a[i]){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

