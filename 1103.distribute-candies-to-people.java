/*
 * @lc app=leetcode id=1103 lang=java
 *
 * [1103] Distribute Candies to People
 */

// @lc code=start
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        candies--;
        int turn = 1;
        int i = 0;
        while (candies >= 0) {
            result[i] += turn;
            i = i == num_people - 1 ? 0 : i + 1;
            if (candies >= turn + 1) {
                turn = turn + 1;
                candies = candies - turn;
            } else {
                result[i] += candies;
                break;
            }
        }
        return result;
    }
}
// @lc code=end

