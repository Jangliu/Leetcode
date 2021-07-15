/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        // 由于乘除优先于加减计算，因此先进行所有乘除运算
        //并将这些乘除运算后的整数值放回原表达式的相应位置
        //则随后整个表达式的值，就等于一系列整数加减后的值。
        Deque<Integer> stack = new LinkedList<Integer>();
        // 默认前一个运算符为+
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            // 先获取两个运算符号之间的数字
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            // 筛选条件，找到运算符，或者循环即将结束
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    //对于乘除号后面的元素，都与栈顶元素计算，然后放到栈顶
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        //此时栈中保存的都是数字，加起来即可（减号已经用负数代替了）
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}

// @lc code=end

