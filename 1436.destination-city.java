import java.util.HashSet;

/*
 * @lc app=leetcode id=1436 lang=java
 *
 * [1436] Destination City
 */

// @lc code=start
class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> sp = new HashSet<>();
        String[] ep = new String[paths.size()];
        for(int i=0;i<paths.size();i++){
            sp.add(paths.get(i).get(0));
            ep[i]=paths.get(i).get(1);
        }
        for(int i=0;i<ep.length;i++){
            if(!sp.contains(ep[i])){
                return ep[i];
            }
        }
        return "";
    }
}
// @lc code=end

