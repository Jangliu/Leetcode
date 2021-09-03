import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        // 递归的思路
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            if(i > n) {
                break;
            }
            list.add(i);
            lexicalOrderDfs(i, n, list);
        }
        return list;
    }

    public void lexicalOrderDfs(int i, int n, List<Integer> list) {
        // 传入参数，i代表以i开头
        // 比如传入参数为10代表以10开头
        for(int j = 0; j <= 9; j++) {
            if(i * 10 + j > n) {
                break;
            }
            list.add(i * 10 + j);
            lexicalOrderDfs(i * 10 + j, n, list);
        }
    }
}

// @lc code=end

