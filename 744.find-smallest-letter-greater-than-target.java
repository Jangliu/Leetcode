/*
 * @lc app=leetcode id=744 lang=java
 *
 * [744] Find Smallest Letter Greater Than Target
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int i=0;
        for(;i<letters.length;i++){
            if(letters[i]>target){
                return letters[i];
            }
        }
        if(i==letters.length){
            return letters[0];
        }
        return 0;
    }
}
// @lc code=end

