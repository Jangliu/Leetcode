/*
 * @lc app=leetcode id=788 lang=java
 *
 * [788] Rotated Digits
 */

// @lc code=start
class Solution {
    //stupid question
    public int rotatedDigits(int N) {
        // need contains one of 2,5,6,9, can't container 3,4,7
        // 0,1,8 will be 0, 2,5,6,9 will be 1, 3,4,7:2
        int[] validTable = { 0, 0, 1, -1, -1, 1, 1, -1, 0, 1 };
        int res = 0;
        for (int i = 2; i <= N; i++) {
            if (isGoodNumber(validTable, i))
                res++;
        }
        return res;

    }

    private boolean isGoodNumber(int[] validTable, int num) {
        // in order to be a good number, num mustn't contain any digits of 3,4,7,
        // and must contain one of 2,5,6,9
        // 0,1,8 has no effect on the result;

        boolean isDifferent = false;
        while (num > 0) {
            int digit = num % 10;
            if (validTable[digit] == -1)
                return false;
            else if (validTable[digit] == 1)
                isDifferent = true;
            num /= 10;
        }
        return isDifferent;
    }

}
// @lc code=end

