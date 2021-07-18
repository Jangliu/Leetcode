/*
 * @lc app=leetcode.cn id=275 lang=java
 *
 * [275] H 指数 II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==1){
            return citations[0]>=1?1:0;
        }
        int sp=0;
        int ep=citations.length-1;
        while(sp<=ep){
            int mid=(sp+ep)/2;
            if(citations[mid]>=citations.length-mid){
                ep=mid-1;
                continue;
            }
            else{
                sp=mid+1;
            }
        }
        return citations.length-sp;
    }
}
// @lc code=end

