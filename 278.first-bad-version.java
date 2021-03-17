/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long sp = 1;
        if (isBadVersion((int) sp)) {
            return (int) sp;
        }
        long ep = n;
        long mid = (sp + ep) / 2;
        while (ep - sp > 1) {
            if (isBadVersion((int) mid)) {
                ep = mid;
            } else {
                sp = mid;
            }
            mid = (sp + ep) / 2;
        }
        return (int) ep;
    }
}
// @lc code=end

