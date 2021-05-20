/*
 * @lc app=leetcode id=1812 lang=java
 *
 * [1812] Determine Color of a Chessboard Square
 */

// @lc code=start
class Solution {
    public boolean squareIsWhite(String coordinates) {
        switch (coordinates.charAt(0)) {
            case 'a':
                if(Integer.valueOf(coordinates.charAt(1))%2==0){
                    return true;
                }
                return false;
            case 'c':
                if (Integer.valueOf(coordinates.charAt(1)) % 2 == 0) {
                    return true;
                }
                return false;
            case 'e':
                if (Integer.valueOf(coordinates.charAt(1)) % 2 == 0) {
                    return true;
                }
                return false;
            case 'g':
                if (Integer.valueOf(coordinates.charAt(1)) % 2 == 0) {
                    return true;
                }
                return false;
            default:
                if (Integer.valueOf(coordinates.charAt(1)) % 2 != 0) {
                    return true;
                }
                return false;
        }
    }
}
// @lc code=end

