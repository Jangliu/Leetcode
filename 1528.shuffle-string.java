/*
 * @lc app=leetcode id=1528 lang=java
 *
 * [1528] Shuffle String
 */

// @lc code=start
class Solution {
    public String restoreString(String s, int[] indices) {
        //注意这里最后不能用c.toString(),会生成乱码
        char[] c = new char[s.length()];
        for(int i=0;i<s.length();i++){
            c[indices[i]]=s.charAt(i);
        }
        return new String(c);
    }
}
// @lc code=end

