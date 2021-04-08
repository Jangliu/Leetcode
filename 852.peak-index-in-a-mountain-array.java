/*
 * @lc app=leetcode id=852 lang=java
 *
 * [852] Peak Index in a Mountain Array
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int sp=0;
        int ep=arr.length;
        int mid = (sp+ep)/2;
        while(ep-sp>1){
            if(arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]){
                return mid;
            }
            if(arr[mid]>arr[mid+1]&&arr[mid-1]>arr[mid]){
                ep=mid;
                mid = (sp+ep)/2;
                continue;
            }
            sp = mid;
            mid = (sp + ep) / 2;
        }
        return arr[ep]>=arr[sp]?ep:sp;
    }
}
// @lc code=end

