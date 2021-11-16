/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 */

// @lc code=start
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // 先排序，我还以为默认就是排了序的，淦
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int m = houses.length;
        int n = heaters.length;
        int minRadius = 0;
        // i表示遍历的heater的下标
        // j表示遍历的house的下标
        int i = 0;
        int j = 0;
        // 遍历房子
        while (j < m) {
            // 如果该房子目前还在供暖器的左边
            if (houses[j] <= heaters[i]) {
                if (i == 0) {
                    minRadius = Math.max(minRadius, heaters[i] - houses[j]);
                } else {
                    int temp = Math.min(heaters[i] - houses[j], houses[j] - heaters[i - 1]);
                    minRadius = Math.max(temp, minRadius);
                }
            } else {
                // 该房子目前在供暖器右边
                // 寻找该房子右边第一个供暖器
                while (i < n) {
                    if (heaters[i] < houses[j]) {
                        i++;
                    } else {
                        break;
                    }
                }
                // 如果所有供暖器都在该房子的左边
                if (i == n) {
                    minRadius = Math.max(minRadius, houses[m - 1] - heaters[n - 1]);
                    return minRadius;
                }
                int temp = Math.min(heaters[i] - houses[j], houses[j] - heaters[i - 1]);
                minRadius = Math.max(temp, minRadius);
            }
            j++;
        }
        return minRadius;
    }
}
// @lc code=end

