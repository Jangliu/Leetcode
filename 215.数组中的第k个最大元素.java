import java.util.Random;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        // 核心思想是使用简化的快速排序
        // 重点是要掌握快速排序算法
        // 快速排序算法的重点是如何做到生成左右子区间
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            // 如果下标比index大，那说明在右边子区间，反之则在左边子区间
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        // 先把随机选择的下标的数挪到最右边
        swap(a, i, r);
        // 排序，返回下标
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        // 待比较的目标是x,在传入此函数之前就换过一次位置，其位置为r
        // 如果x的左边的数都比它小，那么其实等价于左边没做处理
        // 每次如果遇到了比x要小的数，就更新大的部分和小的部分的分界线，即i
        // 这样即使遍历的过程中出现大小数交替出现的情况也可以保持更新
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        // 交换数组中两个元素的位置
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

// @lc code=end

