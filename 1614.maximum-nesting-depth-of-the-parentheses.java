/*
 * @lc app=leetcode id=1614 lang=java
 *
 * [1614] Maximum Nesting Depth of the Parentheses
 */

// @lc code=start
class Solution {
    public int maxDepth(String s) {
        int res=0;
        int n=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                n++;
                res=Math.max(n, res);
            }
            if(s.charAt(i)==')'){
                n--;
            }
        }
        return res;
    }
}
// @lc code=end

