/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //从下标0开始检查
        //先检查第0个加油站，看是否能环绕一周
        //如果不能就从第一个无法到达的加油站开始继续检查
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                //当下标超过n以后自动回去
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                //判断消耗量和储存量
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            //遍历完成以后
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

