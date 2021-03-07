#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        import math
        nums = 0
        twos = n // 2
        if n % 2 == 0:
            ones = 0
        else:
            ones = 1
        while(twos >= 0):
            nums += math.factorial(twos+ones)//(math.factorial(ones)*math.factorial(twos))
            twos -= 1
            ones += 2
        return nums
# @lc code=end

