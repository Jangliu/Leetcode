import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int numsLen = nums.length;
        if (numsLen < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[numsLen - 1] + nums[numsLen - 2] + nums[numsLen - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int low = j + 1;
                int high = nums.length - 1;
                int sum = target - nums[i] - nums[j];
                while (high > low) {
                    if (sum == nums[low] + nums[high]) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        res.add(temp);
                        while (low < nums.length - 1) {
                            if (nums[low] != nums[low + 1]) {
                                low++;
                                break;
                            }
                            low++;
                        }
                        continue;
                    }
                    if (sum > nums[low] + nums[high]) {
                        low++;
                        continue;
                    }
                    if (sum < nums[low] + nums[high]) {
                        high--;
                        continue;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

