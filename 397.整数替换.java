/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 */

// @lc code=start
class Solution {
    Map<Integer, Integer> integerReplacementMap;
    public int integerReplacement(int n) {
        integerReplacementMap = new HashMap<>();
        return integerReplacementHelper(n);

    }
    public int integerReplacementHelper(int n) {
        if (n == 1) {
            return 0;
        }
        if (n <= 0) {
            return 100000;
        }
        if (n == (1 << 31) - 1) {
            return 32;
        }
        if (integerReplacementMap.containsKey(n)) {
            return integerReplacementMap.get(n);
        }
        if (n % 2 == 0) {
            integerReplacementMap.put(n, integerReplacementHelper(n / 2) + 1);
            return integerReplacementMap.get(n);
        }

        integerReplacementMap.put(n, Math.min(integerReplacementHelper(n + 1), integerReplacementHelper(n - 1)) + 1);

        return integerReplacementMap.get(n);
    }
}

// @lc code=end

