#
# @lc app=leetcode id=26 lang=python3
#
# [26] Remove Duplicates from Sorted Array
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        while (i < len(nums)-1):
            sp = i
            i += 1
            if nums[sp] == nums[i]:
                del nums[i]
                i = sp
                continue
            else:
                continue
        return len(nums)


        
# @lc code=end

