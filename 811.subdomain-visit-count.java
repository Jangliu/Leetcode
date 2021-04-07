import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=811 lang=java
 *
 * [811] Subdomain Visit Count
 */

// @lc code=start
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] words = cpdomains[i].split("\\.| ");
            int count = Integer.parseInt(words[0]);
            String temp = words[words.length - 1];
            if (map.containsKey(temp)) {
                map.replace(temp, map.get(temp) + count);
            } else {
                map.put(temp, count);
            }
            for (int j = words.length - 2; j >= 1; j--) {
                temp = words[j] + "." + temp;
                if (map.containsKey(temp)) {
                    map.replace(temp, map.get(temp) + count);
                } else {
                    map.put(temp, count);
                }
            }
        }
        for (String key : map.keySet()) {
            result.add(String.valueOf(map.get(key)) + " " + key);
        }
        return result;
    }
}
// @lc code=end

