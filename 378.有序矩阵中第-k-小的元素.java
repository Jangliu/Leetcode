import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第 K 小的元素
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // 首先对于这个矩阵，最小的值肯定是在左上角，最大值在右下角
        // 那么我们可以得到一个mid,mid=(left+right)/2
        // 然后统计在这个矩阵里，比mid小的数有多少个，假设有num个
        // 如果num≥k,那么说明第k小元素比mid还要小反之比mid大，然后更新left和right的值
        // 于是只要一直收缩left和right，直到left=right
        // 那么此时k=left,因为k一直在left和right之间
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        // 以左下角为起点
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}
// @lc code=end

