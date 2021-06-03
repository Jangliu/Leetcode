import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        //首尾两个指针同时移动
        //当左边的高度小于右边高度时将左边指针向右移
        //反之将右边指针向左移
        //这样移动的原因：指针只要移动，那么宽度就会减小。
        //所以必须让高度提升，不然总面积不可能增加，总面积减小的情况就不用考虑了。
        int maxWater = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxWater = Math.max(maxWater, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxWater;
        //太可惜了，想到过两个指针的这种方法，但是没有想出如何移动的规律。
    }
}
// @lc code=end

