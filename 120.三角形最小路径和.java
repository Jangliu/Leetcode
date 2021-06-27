import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        //用f来储存遍历到当前行时到当前行每一个点的最小距离
        //f的空间是按照最大化来分配的，比如遍历到第0行，一共只有1个元素
        //所以此时f的有效长度就是1
        //初始化为n+1是假设三角形最下面还有一行全为0
        int[] f = new int[n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                //到(i,j)这个点的最短距离
                //按照规则计算
                f[j]=Math.min(f[j], f[j+1])+triangle.get(i).get(j);
            }
        }
        return f[0];
    }
}
// @lc code=end

