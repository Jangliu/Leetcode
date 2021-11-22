/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    // 遍历一次数组
    // 如果元素是单调递减的（则他们的「下一个更大元素」相同），就把这些元素保存，直到找到一个较大的元素；
    // 把该较大元素逐一跟保存了的元素比较，如果该元素更大，那么它就是前面元素的「下一个更大元素」。

    public int[] nextGreaterElements(int[] nums) {
        // 构建返回数组
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        // 设置单调栈
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            // 如果栈为空则将当前元素（下标）放入栈内
            // 如果栈非空，判断当前元素和栈顶元素大小：
            // 如果当前元素比栈顶元素大：说明当前元素一定是前面一些元素的「下一个更大元素」
            // 则逐个弹出栈顶元素，直到当前元素比栈顶元素小为止
            // 如果当前元素比栈顶元素小，那么说明当前元素的「下一个更大元素」与栈顶元素相同，则把当前元素入栈
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }
}

// @lc code=end

