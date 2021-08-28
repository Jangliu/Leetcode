/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 */

// @lc code=start
class Solution {
    // 1.a^b%1337=(a%1337)^b
    // 2.(a * b) % k = (a % k)(b % k) % k
    // 有以上两个公式即可着手解题
    // 以a^[1,5,6,4]为例
    // a^[1,5,6,4]=a^4 * a^[1,5,6,0]=a^4 * (a^[1,5,6])^10;
    // 即a^[1,5,6,4]%1337 = ((a^4)%1337)*((a^[1,5,6])^10%1337)%1337
    // 所以只要写出一个函数求a^n%1337，n≤9,即可递归调用从而求解此问题
    public int superPow(int a, int[] b) {
        a=a%1337;
        Stack<Integer> stack = new Stack<>();
        int n = b.length;
        for (int i = 0; i < n; i++) {
            stack.push(b[i]);
        }
        return hpPow(a, stack);
    }

    public int hpPow(int a, Stack<Integer> stack) {
        // 递归实现
        if (stack.isEmpty()) {
            return 1;
        }
        int last = stack.pop();
        int part1 = myPow(a, last);
        int part2 = myPow(hpPow(a, stack), 10);
        return (part1 * part2) % 1337;
    }

    public int myPow(int a, int k) {
        // 取模防止溢出
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= 1337;
        }
        return res;
    }
}
// @lc code=end

