import java.util.HashSet;

/*
 * @lc app=leetcode id=1496 lang=java
 *
 * [1496] Path Crossing
 */

// @lc code=start
class Solution {
    public boolean isPathCrossing(String path) {
        int[] pos = new int[2];
        HashMap<Integer, Object> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(pos[1]);
        map.put(pos[0], set);
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    pos[1]++;
                    break;
                case 'S':
                    pos[1]--;
                    break;
                case 'E':
                    pos[0]++;
                    break;
                default:
                    pos[0]--;
                    break;
            }
            if (map.containsKey(pos[0])) {
                HashSet<Integer> temp = (HashSet<Integer>) map.get(pos[0]);
                if (!temp.add(pos[1])) {
                    return true;
                }
            } else {
                HashSet<Integer> temp = new HashSet<>();
                temp.add(pos[1]);
                map.put(pos[0], temp);
            }
        }
        return false;
    }
}
// @lc code=end

