/*
 * @lc app=leetcode id=1640 lang=java
 *
 * [1640] Check Array Formation Through Concatenation
 */

// @lc code=start
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int i=0;
        boolean flag = false;
        while(i<arr.length){
            int num=arr[i];
            for(int j=0;j<pieces.length;j++){
                if(pieces[j][0]==num){
                    int k=0;
                    for(;k<pieces[j].length;k++){
                        if(pieces[j][k]!=arr[i+k]){
                            break;
                        }
                    }
                    if(k==pieces[j].length){
                        i=i+pieces[j].length;
                        flag=true;
                        break;
                    }
                }
            }
            if(!flag){
                return false;
            }
            flag = false;
        }
        return true;
    }
}
// @lc code=end

