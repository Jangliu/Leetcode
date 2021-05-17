/*
 * @lc app=leetcode id=1710 lang=java
 *
 * [1710] Maximum Units on a Truck
 */

// @lc code=start
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] unitCount = new int[1001];

        for (int[] boxType : boxTypes) {
            unitCount[boxType[1]] += boxType[0];
            //unitCount的index代表其大小，unitCount[index]代表其数量，妙啊
        }

        int count = 0;

        for (int i = unitCount.length - 1; i >= 0; i--) {
            if (unitCount[i] == 0)
                continue;

            int num = Math.min(unitCount[i], truckSize);
            count += num * i;
            truckSize -= num;
            if (truckSize == 0)
                break;
        }

        return count;
    }
}
// @lc code=end

