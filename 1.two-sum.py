#
# @lc app=leetcode id=1 lang=python3
#
# [1] Two Sum
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        Rest = {}
        for i in range(len(nums)):
            temp = target - nums[i]
            if temp not in Rest:
                Rest[nums[i]] = i
            else:
                return [i, Rest[temp]]
# @lc code=end
