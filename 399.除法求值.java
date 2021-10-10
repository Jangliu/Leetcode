import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 */

// @lc code=start
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /*
     * 本题使用的方法叫做并查集 比如a/b=2,b/c=3，那么就可以说明a,b,c都在一个集合里 同一个集合里任意两个元素都可以通过某种方法计算出比值
     * 当两个元素处于不同集合时返回-1.0 在同一集合中，可以构造出一张图，图的顶点就是元素，边是带有权值的
     * 图的思想跟我一开始的想法是一样的，我最初的解法也是用的图 但是我没有对图进行路径优化 比如图里出现的某个树层级过高，这样就会增加查询的时间
     * 官方解法的优越在于对图也进行了优化，降低了层数 比如若是有一棵树是a→b→c→d,就可以优化为a→d,c→d,c→d
     * 这样在图中显示就会降低树的层级
     * 通过代码也可以发现，并查集的一个特点就是一边查询，一边修改节点的指向
     * 值得注意的是，在我原本的解法里面使用的是双向图
     * 但是使用并查集的话使用单向图即可
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);

            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {

        private int[] parent;

        /**
         * 指向的父结点的权值
         */
        private double[] weight;


        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        // 对两个节点进行并集操作
        public void union(int x, int y, double value) {
            // 找到两个节点的根节点
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            // 如果两个节点的关系还没有更新到图中，那么设置x的根节点就应该是y的根节点
            parent[rootX] = rootY;
          	// 关系式的推导请见「参考代码」下方的示意图
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         *
         * @param x
         * @return 根结点的 id
         */
        public int find(int x) {
            // 如果x不是根节点
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            } else {
                return -1.0d;
            }
        }
    }
}
// @lc code=end

