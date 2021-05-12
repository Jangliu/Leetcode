/*
 * @lc app=leetcode id=1598 lang=java
 *
 * [1598] Crawler Log Folder
 */

// @lc code=start
class Solution {
    public int minOperations(String[] logs) {
        int res=0;
        for(String s:logs){
            if(s.charAt(s.length()-2)=='.'){
                res+=s.length()==2?0:-1;
                if(res<=0){
                    res=0;
                }
            }
            else{
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

