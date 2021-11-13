import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=457 lang=java
 *
 * [457] 环形数组是否存在循环
 */

// @lc code=start
class Solution {
    // 循环问题都用快慢指针
    public boolean circularArrayLoop(int[] nums) {
        // 快慢指针法，一个快指针一个慢指针，快指针每次走两步，慢指针只走一步
        // 当一次尝试中，如果不能构成循环，那本次尝试中快慢指针经过的点必定都不是循环包含的点，所以可以都置0
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = getNext(i, nums);
            while (isSameDirection(slow, fast, nums) && isSameDirection(slow, getNext(fast, nums), nums)) {
                if (slow == fast) {
                    if (slow == getNext(slow, nums)) {
                        break;
                    }
                    return true;
                }
                slow = getNext(slow, nums);
                fast = getNext(getNext(fast, nums), nums);
            }
            int idx = i;
            while (idx != slow) {
                int tmp = idx;
                idx = getNext(idx, nums);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    private int getNext(int i, int[] nums) {
        return Math.floorMod(i + nums[i], nums.length);
    }

    private boolean isSameDirection(int d1, int d2, int[] nums) {
        return nums[d1] * nums[d2] > 0;
    }
}

// @lc code=end

