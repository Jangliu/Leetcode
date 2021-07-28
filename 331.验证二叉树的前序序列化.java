/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        // 将二叉树考虑成一个逐渐生成的树
        // 每一个节点代表一个槽位
        int n = preorder.length();
        int i = 0;
        // 初始化槽位为1，代表根节点
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                // 当槽位已经没有了，而遍历还没结束，说明不合法
                return false;
            }
            if (preorder.charAt(i) == ',') {
                // 遇到","则顺序前移
                i++;
            } else if (preorder.charAt(i) == '#'){
                // 遇到一个"#"就需要消耗一个槽位
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                // 读到一个数字，说明这个节点非空，那么就有左右子节点
                // 槽位+2，然后消耗本节点的槽位
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;
    }
}

// @lc code=end

