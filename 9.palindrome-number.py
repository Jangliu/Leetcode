#
# @lc app=leetcode id=9 lang=python3
#
# [9] Palindrome Number
#

# @lc code=start
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        else:
            x = str(x)
            l = len(x)
            for i in range(l // 2):
                if x[i] == x[l - 1 - i]:
                    continue
                else:
                    return False
            return True
# @lc code=end
