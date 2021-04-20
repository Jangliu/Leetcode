/*
 * @lc app=leetcode id=1033 lang=java
 *
 * [1033] Moving Stones Until Consecutive
 */

// @lc code=start
class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        //stupid question
        int A = Math.min(a, Math.min(b, c)); // Lowest
        int C = Math.max(a, Math.max(b, c)); // Highest
        int B = a ^ b ^ c ^ A ^ C; // Middle

        int minMoves = 0;
        if (C - A >= 4 && (A == B - 2 || C == B + 2))
            minMoves = 1; // A.B.._..C or A.._..B.C (one move of farthest
                          // outer num to between two other nums)
        else {
            if (A != B - 1)
                minMoves++; // A.._..B (else if AB then no moves needed for B)
            if (C != B + 1)
                minMoves++; // B.._..C (else if BC then no moves needed for C)
        }

        int maxMoves = C - A - 2; // max is number of positions between highest and lowest
                                  // number (C - A - 1) minus a position that is
                                  // used by the middle number (-1).
        return new int[] { minMoves, maxMoves };
    }
}
// @lc code=end

