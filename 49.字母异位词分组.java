import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        //用哈希表的思路
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()){
                ca[c - 'a']++;
            }
            //对于每一个字符串，都将其字母的排序之后组成的字符串作为哈希表的键
            String keyStr = String.valueOf(ca);
            //如果排序后的字符串是一样的，那么就是符合题目要求的字母异位词
            if (!map.containsKey(keyStr)){
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        //返回哈希表的值
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

