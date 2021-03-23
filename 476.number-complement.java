/*
 * @lc app=leetcode id=476 lang=java
 *
 * [476] Number Complement
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        long number = num;
        int i = 0;
        for (; i < num; i++) {
            if (Math.pow(2, i) <= num && Math.pow(2, i + 1) > num) {
                break;
            }
        }
        long c = (long) Math.pow(2, i + 1) - 1;
        return (int) (c ^ number);
    }
}
// @lc code=end

