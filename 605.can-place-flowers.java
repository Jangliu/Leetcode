/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] != 0) {
                continue;
            } else {
                if (i - 1 < 0 && i + 1 < flowerbed.length) {
                    if (flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                    continue;
                }
                if (i - 1 >= 0 && i + 1 < flowerbed.length) {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                    continue;
                }
                if (i - 1 >= 0 && i + 1 >= flowerbed.length) {
                    if (flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                    continue;
                }
                if (i - 1 < 0 && i + 1 >= flowerbed.length) {
                    if (flowerbed[i] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                    continue;
                }
            }
        }
        return n <= count;
    }
}
// @lc code=end

