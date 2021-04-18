/*
 * @lc app=leetcode id=944 lang=java
 *
 * [944] Delete Columns to Make Sorted
 */

// @lc code=start
class Solution {
    public int minDeletionSize(String[] strs) {
        int result = 0;
        for(int i=0;i<strs[0].length();i++){
            for(int j=0;j<strs.length-1;j++){
                if(strs[j].charAt(i)>strs[j+1].charAt(i)){
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
// @lc code=end

