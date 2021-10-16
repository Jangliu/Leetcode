/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        // num假设有n位数字，那么可以理解为在n为数字钟挑选k个组成最小的
        // 假设目前有num有9000为数字，k=1000，即需要挑选8000位数字组成target，target为最小
        // 1. 挑选第一位数字，在[0,1000]内寻找第一位数字，最左边的最小的即为目标，假设其下标为3
        // 2. 挑选第二位数字，在[3+1,1001]内寻找第二位，最左边的最小的即为目标
        // 3. 重复上述步骤，寻找范围的起点为上一次目标下标+1，终点为上一次的终点+1
        StringBuilder ans = new StringBuilder();
        char[] numbers = num.toCharArray();
        int step = numbers.length - k;
        int minValPos = -1;
        while (step > 0) {
            char minVal = '9';
            int sp = minValPos + 1;
            int ep = numbers.length - step;
            for (int i = sp; i <= ep; i++) {
                if (numbers[i] < minVal) {
                    minVal = numbers[i];
                    minValPos = i;
                }
            }
            if (!(minVal == '0' && ans.length() == 0)) {
                ans.append(minVal);
            }
            step--;
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
// @lc code=end

