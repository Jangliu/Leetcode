/*
 * @lc app=leetcode id=941 lang=java
 *
 * [941] Valid Mountain Array
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<=2){
            return false;
        }
        boolean flag=true;
        if(arr[1]<=arr[0]){
            return false;
        }
        for(int i=0;i<arr.length-1;i++){
            if(flag){
                if(arr[i+1]<=arr[i]){
                    flag=false;
                    if(i==arr.length-2&&arr[i+1]>=arr[i]){
                        return false;
                    }
                }
            }
            else{
                if(arr[i+1]>=arr[i]){
                    return false;
                }
            }
        }
        return flag==false?true:false;
    }
}
// @lc code=end

