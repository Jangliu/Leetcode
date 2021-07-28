import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start
class Solution {
    // 储存边
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    // 储存结果
    List<String> itinerary = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 储存边的时候使用PriorityQueue，这样保证了字典序最小的在最上面
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        // dfs从JFK开始
        dfs("JFK");
        // 要逆转回来
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr) {
        // 已知必然存在一种合理的形成，且所有机票都会被使用一次
        // 那么只要每次都不走那个死胡同节点，就会最终完成遍历
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        // 对curr的所有相连的边都遍历完了再将curr放入结果中
        itinerary.add(curr);
    }
}

// @lc code=end

