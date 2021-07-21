/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 整体思路：
        // 将这棵树从叶子节点开始剪枝
        // 每一次都将叶子节点剪完
        // 这样做的原因是，最小高度树的根节点一定是在这个图的最中心位置
        // 所以一层一层地剪去叶子节点就能到达最中心位置
        List<Integer> res = new ArrayList<>();
        // 如果只有一个节点，那么他就是最小高度树
        if (n == 1) {
            res.add(0);
            return res;
        }
        // 建立各个节点的出度表
        int[] degree = new int[n];
        // 建立图关系，在每个节点的list中存储相连节点
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            // 添加相邻节点
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        // 建立队列
        Queue<Integer> queue = new LinkedList<>();
        // 把所有出度为1的节点，也就是叶子节点入队
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            // 每层循环都要new一个新的结果集合
            // 这样最后保存的就是最终的最小高度树了
            res = new ArrayList<>();
            // 最外层节点的数量，也就是叶子节点的数量
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                // 把当前节点加入结果集
                // 为什么当前只是叶子节点为什么要加入结果集呢?
                // 因为每次循环都会新建一个list，所以最后保存的就是最后一个状态下的叶子节点，
                // 即剪掉叶子节点的部分，想象成一个图，每层遍历完，都会把该层（也就是叶子节点层）这一层从队列中移除掉
                //就相当于把原来的图给剪掉一圈叶子节点，形成一个缩小的新的图
                res.add(cur);
                List<Integer> neighbors = map.get(cur);
                // bfs，把当前节点的相邻接点都拿出来，
                // 把它们的出度都减1
                // 因为将当前节点剪掉了， 所以其相邻的节点可能变成叶子节点
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        // 如果是叶子节点就入队
                        queue.offer(neighbor);
                    }
                }
            }
        }
        // 返回最后一次保存的list
        return res;
    }

}

// @lc code=end

