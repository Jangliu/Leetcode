/*
 * @lc app=leetcode id=1720 lang=java
 *
 * [1720] Decode XORed Array
 */

// @lc code=start
class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 0; i < encoded.length; i++)
            res[i + 1] = res[i] ^ encoded[i];
        return res;
    }
}
// @lc code=end

