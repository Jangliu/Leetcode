import java.util.ArrayList;
import java.util.Comparator;
/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        ArrayList<Integer> greed = new ArrayList<Integer>();
        ArrayList<Integer> cookie = new ArrayList<Integer>();
        for(int i=0;i<s.length;i++){
            cookie.add(s[i]);
        }
        for(int i=0;i<g.length;i++){
            greed.add(g[i]);
        }
        greed.sort(Comparator.naturalOrder());
        cookie.sort(Comparator.naturalOrder());
        int i=0;
        int j=0;
        while(i<greed.size()&&j<cookie.size()){
            if(greed.get(i)<=cookie.get(j)){
                count++;
                i++;
                j++;
                continue;
            }
            j++;
        }
        return count;
    }
}
// @lc code=end

