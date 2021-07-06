import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

// @lc code=start
class Solution {
    //我要吐了，就是一个长除法的细节，妈的，浪费一个上午
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        // 如果其中一个数为负数的话，增加负号
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // 转换成长整型（防止溢出）
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }
        //如果没除尽，增加一个小数点
        fraction.append(".");
        //用哈希表来存储余数和其出现的位置
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            //出现相同余数，说明要开始重复了
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            //注意乘10的细节
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}
// @lc code=end

