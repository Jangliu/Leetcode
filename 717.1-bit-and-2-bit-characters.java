/*
 * @lc app=leetcode id=717 lang=java
 *
 * [717] 1-bit and 2-bit Characters
 */

// @lc code=start
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        // SB题目，题目里的意思是两种字符，而不是两个字符。
        //从头遍历，如果第一个遇到的是0，那么它只能代表1比特的那个字符，如果遇到的是1，那必然代表2比特的字符
        //所以，遇到0则i+1 遇到1则i+2，这样如果最后到达末尾的时候，i恰好停在最后一个位置
        //则正确。
        int i = 0;
        while (i < bits.length) {
            if (i == bits.length - 1) {
                return true;
            }
            i += bits[i] + 1;
        }
        return false;
    }
}
// @lc code=end

