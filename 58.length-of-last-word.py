#
# @lc app=leetcode id=58 lang=python3
#
# [58] Length of Last Word
#

# @lc code=start
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        n = len(s)
        length = 0
        i = 1
        while(i < len(s)+1):
            if s[-i] == ' ':
                i += 1
            else:
                break
        if i == len(s)+1:
            return length
        else:
            while(i < len(s)+1):
                if s[-i] != ' ':
                    length += 1
                    i += 1
                else:
                    break
            return length
# @lc code=end

