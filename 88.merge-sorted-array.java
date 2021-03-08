import org.graalvm.compiler.phases.common.ConditionalEliminationUtil;

/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
            return;
        }
        int l = m + n;
        int i = 0, j = 0;
        for (; i < m; i++) {
            if (nums1[i] <= nums2[j]) {
                continue;
            }
            for (int k = m - 1; k >= i; k--) {
                nums1[k + 1] = nums1[k];
            }
            m++;
            nums1[i] = nums2[j];
            j++;
            if (j >= n) {
                break;
            }
        }
        if (j <= n - 1) {
            for (; i < l; i++) {
                nums1[i] = nums2[j];
                j++;
            }
        }
    }
}
// @lc code=end

