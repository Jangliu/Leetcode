import java.util.List;

/*
 * @lc app=leetcode id=1773 lang=java
 *
 * [1773] Count Items Matching a Rule
 */

// @lc code=start
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        for(int i=0;i<items.size();i++){
            List<String> item = items.get(i);
            if(ruleKey.equals("type")&&ruleValue.equals(item.get(0))){
                res++;
            }
            if (ruleKey.equals("color") && ruleValue.equals(item.get(1))) {
                res++;
            }
            if (ruleKey.equals("name") && ruleValue.equals(item.get(2))) {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

