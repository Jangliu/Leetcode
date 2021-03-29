import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=599 lang=java
 *
 * [599] Minimum Index Sum of Two Lists
 */

// @lc code=start
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int minSumOfIndex = Integer.MAX_VALUE;
        ArrayList<String> val = new ArrayList<String>();
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int j = 0; j < list2.length; j++) {
            map2.put(list2[j], j);
        }
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                if (map1.get(key) + map2.get(key) < minSumOfIndex) {
                    minSumOfIndex = map1.get(key) + map2.get(key);
                    val.clear();
                    val.add(key);
                    continue;
                }
                if (map1.get(key) + map2.get(key) == minSumOfIndex) {
                    val.add(key);
                }
            }
        }
        String[] result = new String[val.size()];
        for (int i = 0; i < val.size(); i++) {
            result[i] = val.get(i);
        }
        return result;
    }
}
// @lc code=end

