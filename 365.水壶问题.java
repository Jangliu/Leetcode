import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 */

// @lc code=start
class Solution {
    // 搜索算法
    // 任意时刻，本题目的状态可以用X壶中水剩余量和Y壶中水剩余量来表示
    // 在任意一个时刻，有6种操作
    // 1.装满X壶
    // 2.装满Y壶
    // 3.清空X壶
    // 4.清空Y壶
    // 5.将X壶的水灌入Y壶直到装满或者倒空
    // 6.将Y壶的水灌入X壶直到装满或者倒空
    // 从初始状态开始，每次可以产生6个新的状态，去掉重复状态之后继续产生新状态
    // 当遇到满足条件的状态时返回true
    // 搜索完之后还没有找到符合条件的，那就返回false
    public boolean canMeasureWater(int x, int y, int z) {
        Deque<int[]> stack = new LinkedList<int[]>();
        stack.push(new int[] { 0, 0 });
        Set<Long> seen = new HashSet<Long>();
        while (!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));

            int[] state = stack.pop();
            int remain_x = state[0], remain_y = state[1];
            if (remain_x == z || remain_y == z || remain_x + remain_y == z) {
                return true;
            }
            // 把 X 壶灌满。
            stack.push(new int[] { x, remain_y });
            // 把 Y 壶灌满。
            stack.push(new int[] { remain_x, y });
            // 把 X 壶倒空。
            stack.push(new int[] { 0, remain_y });
            // 把 Y 壶倒空。
            stack.push(new int[] { remain_x, 0 });
            // 把 X 壶的水灌进 Y 壶，直至灌满或倒空。
            stack.push(new int[] { remain_x - Math.min(remain_x, y - remain_y),
                    remain_y + Math.min(remain_x, y - remain_y) });
            // 把 Y 壶的水灌进 X 壶，直至灌满或倒空。
            stack.push(new int[] { remain_x + Math.min(remain_y, x - remain_x),
                    remain_y - Math.min(remain_y, x - remain_x) });
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }
}
// @lc code=end

