#
# @lc app=leetcode id=35 lang=python3
#
# [35] Search Insert Position
#

# @lc code=start
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if target <= nums[0]:
            return 0
        elif target > nums[-1]:
            return len(nums)
        start_point = 0
        end_point = len(nums) - 1
        while (True):
            mid_point = (start_point + end_point) // 2
            if mid_point == start_point:
                if target <= nums[start_point]:
                    return start_point
                elif target > nums[start_point] and target <= nums[end_point]:
                    return end_point
                else:
                    return end_point + 1
            else:
                if nums[mid_point] <= target:
                    start_point = mid_point
                else:
                    end_point = mid_point
# @lc code=end

