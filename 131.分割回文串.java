import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;
    //假设当前搜索到字符串的第i个字符，且s[0...i-1]位置的所有字符都被分割成了若干个回文串
    //那么需要枚举下一个回文串的有边界j,使得s[i...j]为回文串
    public List<List<String>> partition(String s) {
        n = s.length();
        //用f[i][j]来表示s[i...j]这个子串是否为回文串
        //当s[i][j]为空串，长度为1或者s[i+1...j-1]为回文串且首尾字符相同时，其为回文串
        f = new boolean[n][n];
        //初始化f，f[i][j]==true表示s[i...j]为回文串
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }
        //更新f，要从后往前遍历这样可以保证f[i+1][j-1]一定是已经修改过的了
        //不然可能会出现f[i+1][j-1]本身应该是false，但是还没有遍历到，就是默认的true了
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }
    //传入的参数i是目前已经遍历到的子串右边界
    public void dfs(String s, int i) {
        if (i == n) {
            //如果最后一个子串已经到达了右边界，说明一个组合已经完成了
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            //通过f来遍历剩余的子串
            if (f[i][j]) {
                //将目前这个子串加到答案中
                ans.add(s.substring(i, j + 1));
                //递归
                dfs(s, j + 1);
                //删去这个子串，开始新一轮循环
                ans.remove(ans.size() - 1);
            }
        }
    }
}
// @lc code=end

