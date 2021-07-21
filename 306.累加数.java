/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 */

// @lc code=start
class Solution {
    /**
     * 字符串
     */
    String s;
    /**
     * 字符串的长度
     */
    int n;

    // 回溯+剪枝
    // 回溯：对字符串进行拆分来生成数字，从头开始遍历所有可能。
    // 从第三个数开始，需要判断拆分出的数是否等于前两个数的和
    // 满足时才进行拆分，然后寻找下一个数
    // 否则不进行拆分，继续循环拼接生成新的数字。
    // 剪枝：除 0 以外，其他数字不能以 0 开头，如果第一个字符为 0，则不再向下拼接。
    // 从第三个数开始，如果该值比前两个数值的和大，则没必要再向下拼接，越往后拼接的数只会越大。

    public boolean isAdditiveNumber(String num) {
        this.s = num;
        this.n = num.length();
        return toFlashBack(0, 0, 0, 0);
    }

    /**
     * @param index    当前的下标
     * @param sum      前两个数的和
     * @param previous 前一个数的值
     * @param count    已生成几个数
     */
    public boolean toFlashBack(int index, long sum, long previous, int count) {
        // 如果已生成三个数及以上则返回 true
        if (index == n) {
            return count >= 3;
        }
        // 拼接数字的值，值可能越 int 界所以使用 long
        long value = 0;
        // 开始拼接数字
        for (int i = index; i < n; i++) {
            // 除 0 以外，其他数字第一位不能为 0
            if (i > index && s.charAt(index) == '0') {
                break;
            }
            // 计算数值
            value = value * 10 + s.charAt(i) - '0';
            // 判断数值是否合法，如果前面有两个以上的数，则判断前两个数的和是否等于这个数
            if (count >= 2) {
                if (value < sum) {
                    // 小的话继续向后继续拼接
                    continue;
                } else if (value > sum) {
                    // 大的话直接结束，再往后拼接无意义
                    break;
                }
            }
            // 使用该数，向下递归
            if (toFlashBack(i + 1, previous + value, value, count + 1)) {
                return true;
            }
            // 没有可恢复原样的变量
        }
        return false;
    }
}

// @lc code=end

