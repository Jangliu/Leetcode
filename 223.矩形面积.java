import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */

// @lc code=start
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return (ay2 - ay1) * (ax2 - ax1) + (by2 - by1) * (bx2 - bx1)
                - isOverlapped(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
    }

    public int isOverlapped(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 没有重叠的情况
        if ((ax2 <= bx1 || ax1 >= bx2) || (ay1 >= by2 || ay2 <= by1)) {
            return 0;
        }
        // a与b有重叠部分
        int leftX = Math.max(ax1,bx1);
        int rightX = Math.min(ax2, bx2);
        int upY = Math.min(ay2, by2);
        int downY = Math.max(ay1, by1);
        return (upY - downY) * (rightX - leftX);
    }
}
// @lc code=end

