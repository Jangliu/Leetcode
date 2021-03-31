import java.util.HashMap;

/*
 * @lc app=leetcode id=657 lang=java
 *
 * [657] Robot Return to Origin
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < moves.length(); i++) {
            if (map.containsKey(moves.charAt(i))) {
                map.replace(moves.charAt(i), map.get(moves.charAt(i)) + 1);
            } else {
                map.put(moves.charAt(i), 1);
            }
        }
        int l = 0;
        if (map.containsKey('L')) {
            l = map.get('L');
        }
        int r = 0;
        if (map.containsKey('R')) {
            r = map.get('R');
        }
        int u = 0;
        if (map.containsKey('U')) {
            u = map.get('U');
        }
        int d = 0;
        if (map.containsKey('D')) {
            d = map.get('D');
        }
        if (l == r && u == d) {
            return true;
        }
        return false;
    }
}
// @lc code=end

