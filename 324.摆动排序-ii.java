import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        int[] help = nums.clone(); // 不能写成int[] help = nums,排序后两个数组都改变
        Arrays.sort(help);
        int N = nums.length;
        // 比如123456
        // 为了防止类似于112233这种情况
        // 插入值的时候要把数字倒着插
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = help[--N]; // 遍历完成后 x 6 x 5 x 4
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = help[--N]; // 便利完成后 3 6 2 5 1 4
        }
    }
}

// @lc code=end

