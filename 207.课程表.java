import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    // visisted[i]=0表示节点i尚未搜索
    // visisted[i]=1表示节点i正在搜索
    // visisted[i]=2表示节点i完成搜索
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //深度优先遍历和图结合
        //edges里第i个列表存储的是上了哪些课（任意一门）以后才能上i这门课
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                //对未搜索的节点进行搜索
                canFinishDfs(i);
            }
        }
        return valid;
    }

    public void canFinishDfs(int u) {
        //将节点状态设置为搜索中
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                canFinishDfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                //遇到的节点正在搜索，说明这个图里出现了环
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}

// @lc code=end

