#
# @lc app=leetcode id=14 lang=python3
#
# [14] Longest Common Prefix
#

# @lc code=start
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        def TwoCommonPrefix(str1, str2):
            longest = ''
            i = 0
            j = 0
            while (i < len(str1) and j < len(str2)):
                if str1[i] == str2[j]:
                    longest += str1[i]
                    i += 1
                    j += 1
                else:
                    break
            return longest

        if len(strs) <= 1:
            if strs == []:
                return ''
            else:
                return strs[0]
        else:
            longestCommon = TwoCommonPrefix(strs[0], strs[1])
            for i in range(2, len(strs)):
                longestCommon = TwoCommonPrefix(longestCommon, strs[i])
            return longestCommon
# @lc code=end
