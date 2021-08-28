import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=368 lang=java
 *
 * [368] 最大整除子集
 */

// @lc code=start
class Solution {
    // 刚开始做的时候用的是递归，但是递归方法消耗的时间太多了，无法接受
    // 考虑使用动态转移法
    // 当然本题先排序再做是必须的
    // 设f[i]表示以nums[i]作为结尾的整除子集的最大长度
    // 对于任意nums[j]，如果存在x1,x2,x3...<j,且nums[j]%nums[x1]=0,nums[j]%nums[x2]=0,nums[j]%nums[x3]=0...
    // 那么f[j]=max(f[x1],f[x2],f[x3]....)+1
    // 同时使用一个额外的数组记录转移路径（因为最后输出的是一个具体的最大整除子集，而不是其长度）
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 先排序，此算法基于排序
        Arrays.sort(nums);
        int n = nums.length;
        // f[i]记录以nums[i]为结尾的最大整除子集的长度
        int[] f = new int[n];
        // g[i]记录nums[i]由哪个数转移而来
        int[] g = new int[n];
        // 记录最大长度和对应下标
        int max = -1, idx = -1;
        for (int i = 0; i < n; i++) {
            // 至少包含自身一个数，因此起始长度为 1，由自身转移而来
            int len = 1, prev = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    // 如果能接在更长的序列后面，则更新「最大长度」&「从何转移而来」
                    if (f[j] + 1 > len) {
                        len = f[j] + 1;
                        prev = j;
                    }
                }
            }
            // 记录「最终长度」&「从何转移而来」
            f[i] = len;
            g[i] = prev;
            if(f[i]>max){
                max=f[i];
                idx=i;
            }
        }
        // 使用 g[] 数组回溯出具体方案
        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max) {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}
// @lc code=end

