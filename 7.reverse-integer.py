#
# @lc app=leetcode id=7 lang=python3
#
# [7] Reverse Integer
#

# @lc code=start
class Solution:
    def reverse(self, x: int) -> int:
        if x > 2**31 - 1:
            return 0
        elif x < -2**31:
            return 0
        else:
            if x >= 0:
                dig = []
                l = len(str(x))
                for i in range(1, l + 1):
                    n = x // (10**(l - i))
                    dig.append(n)
                    x = x - n * (10**(l - i))
                num = 0
                dig.reverse()
                for i in range(l):
                    num += dig[i] * (10**(l - 1 - i))
                if num > 2**31 - 1:
                    return 0
                elif num < -2**31:
                    return 0
                else:
                    return num
            else:
                x = -x
                dig = []
                l = len(str(x))
                for i in range(1, l + 1):
                    n = x // (10**(l - i))
                    dig.append(n)
                    x = x - n * (10**(l - i))
                num = 0
                dig.reverse()
                for i in range(l):
                    num += dig[i] * (10**(l - 1 - i))
                if num > 2**31 - 1:
                    return 0
                elif num < -2**31:
                    return 0
                else:
                    return -num
# @lc code=end
