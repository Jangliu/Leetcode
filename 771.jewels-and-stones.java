import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=771 lang=java
 *
 * [771] Jewels and Stones
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> map = new HashSet<>();
        int count = 0;
        for(int i=0;i<jewels.length();i++){
            if(!map.contains(jewels.charAt(i))){
                map.add(jewels.charAt(i));
            }
        }
        for(int i=0;i<stones.length();i++){
            if(map.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

