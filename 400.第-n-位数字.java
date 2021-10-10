/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第 N 位数字
 */

// @lc code=start
class Solution {
    public int findNthDigit(int n) {
        /**
         * 0-9:9个数，9*1位数字
         * 10-99：90个数，90*2位数字
         * 100-999：900个数，900*3为数字
         * ...
         */
        long num = n;

        long size = 1;
        long max = 9;
        // 以n=365为例

        while (n > 0) {
            // 判断目标在哪个区间
            // 由规律可以发现，n=365时应该落在的区间为100-999
            if (num - max * size > 0) {
                num = num - max * size;
                size++;
                max = max * 10;
            } else {
                // 365-9-90*2=176
                // 176 表示最后的返回结果应该是100-999区间内的第176位数字
                // 100+176/3=158，说明100-999区间内的第176位数字落在数158里
                // 100：因为区间起点为100
                // 176除以3是因为这个区间的数字都是三位
                // 176%3=2可以得知最后的返回结果是数158的第二位数字
                // 同样，176对3取余是因为这个区间的数字都是三位
                long count = num / size;
                long left = num % size;
                if (left == 0) {
                    return (int) (((long) Math.pow(10, size - 1) + count - 1) % 10);
                } else {
                    return (int) (((long) Math.pow(10, size - 1) + count) / ((long) Math.pow(10, (size - left))) % 10);
                }
            }
        }

        return 0;
    }
}

// @lc code=end

