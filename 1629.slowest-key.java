/*
 * @lc app=leetcode id=1629 lang=java
 *
 * [1629] Slowest Key
 */

// @lc code=start
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int longPress = releaseTimes[0];
        int index = 0;
        for (int i = 1; i < releaseTimes.length; i++) {
            int currentPress = releaseTimes[i] - releaseTimes[i - 1];
            if (currentPress > longPress) {
                index = i;
                longPress = currentPress;
            } else if (currentPress == longPress && keysPressed.charAt(i) > keysPressed.charAt(index)) {
                index = i;
                longPress = currentPress;
            }
        }
        return keysPressed.charAt(index);
    }
}
// @lc code=end

