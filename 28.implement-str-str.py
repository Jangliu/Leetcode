#
# @lc app=leetcode id=28 lang=python3
#
# [28] Implement strStr()
#

# @lc code=start
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == '':
            return 0
        flag = -1
        n = len(haystack)-len(needle)
        if n == 0:
            if haystack == needle:
                return 0
            else:
                return flag
        else:
            for i in range(n+1):
                temp = haystack[i:i+len(needle)]
                if temp == needle:
                    return i
                else:
                    continue
            return flag
# @lc code=end
