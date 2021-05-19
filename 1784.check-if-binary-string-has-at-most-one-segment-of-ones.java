/*
 * @lc app=leetcode id=1784 lang=java
 *
 * [1784] Check if Binary String Has at Most One Segment of Ones
 */

// @lc code=start
class Solution {
    public boolean checkOnesSegment(String s) {
        //stupid question..这题的意思是最多只能有一串连着的1
        int count = 0;
        char ch = '1';

        for (char c : s.toCharArray()) {
            if ((c ^ ch) == 1) {
                ++count;
                ch = c;
                if (count > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
// @lc code=end

