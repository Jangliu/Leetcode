import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
class Solution {
    // 想到了解决的思路，但是在滑动窗口+有序集合这个方法上面自己写结构在细节上没有成功实现
    // 略显失败
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 用一个哈希表来维护滑动窗口
        // 这个滑动窗口里代表的是桶
        // 对于int范围内的任意一个整数x,可以将其表示为x=(t+1)*a+b,其中 0≤b≤t。
        // 这样就意味着每一个整数x都属于一个编号为a的桶，每一个桶内的所有元素差的绝对值小于t，桶的容量为t+1
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long ID = getID(nums[i], t + 1);
            // 如果发现有两个元素都在一个桶里
            if (map.containsKey(ID)) {
                return true;
            }
            // 如果相邻的桶存在，那么就检查这两个相邻桶里的元素是否符合条件
            if (map.containsKey(ID - 1)) {
                if (Math.abs(map.get(ID - 1) - nums[i]) <= t) {
                    return true;
                }
            }
            if (map.containsKey(ID + 1)) {
                if (Math.abs(map.get(ID + 1) - nums[i]) <= t) {
                    return true;
                }
            }
            // 将此ID与元素放入桶中
            map.put(ID, (long) nums[i]);
            // 滑动窗口中桶的个数满了，就移出最头部的一个桶
            if (map.size() > k) {
                map.remove(getID(nums[i - k], t + 1));
            }
        }
        return false;
    }

    public long getID(long x, long w) {
        // 因为x可能是负数，为了保证0≤b≤t，当x<0时要将ID-1
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }
}
// @lc code=end

