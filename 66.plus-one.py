#
# @lc app=leetcode id=66 lang=python3
#
# [66] Plus One
#

# @lc code=start
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n = len(digits)
        digits[-1] = digits[-1] + 1
        i = 2
        if digits[-1] == 10:
            digits[-1] = 0
            flag = True
        else:
            flag = False
        while(i < n + 1):
            if flag is True:
                digits[-i] += 1
                if digits[-i] == 10:
                    digits[-i] = 0
                    flag = True
                    i += 1
                else:
                    flag = False
                    i += 1
            else:
                break
        if i == n + 1 and flag is True:
            digits.insert(0, 1)
        return digits
# @lc code=end

