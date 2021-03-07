#
# @lc app=leetcode id=13 lang=python3
#
# [13] Roman to Integer
#

# @lc code=start
class Solution:
    def romanToInt(self, s: str) -> int:
        num = 0
        i = 0
        while (i < len(s) - 1):
            if s[i] == 'I':
                if s[i + 1] == 'V':
                    num += 4
                    if i == len(s) - 2:
                        return num
                    i = i + 2
                    continue
                elif s[i + 1] == 'X':
                    num += 9
                    if i == len(s) - 2:
                        return num
                    i = i + 2
                    continue
                else:
                    num = num + 1
                    i = i + 1
                    continue
            elif s[i] == 'V':
                num += 5
                i = i + 1
                continue
            elif s[i] == 'X':
                if s[i + 1] == 'L':
                    num += 40
                    if i == len(s) - 2:
                        return num
                    i = i + 2
                    continue
                elif s[i + 1] == 'C':
                    num += 90
                    if i == len(s) - 2:
                        return num
                    i = i + 2
                    continue
                else:
                    num += 10
                    i = i + 1
                    continue
            elif s[i] == 'L':
                num += 50
                i = i + 1
                continue
            elif s[i] == 'C':
                if s[i + 1] == 'D':
                    num += 400
                    if i == len(s) - 2:
                        return num
                    i = i + 2
                    continue
                elif s[i + 1] == 'M':
                    num += 900
                    if i == len(s) - 2:
                        return num
                    i = i + 2
                    continue
                else:
                    num += 100
                    i = i + 1
                    continue
            elif s[i] == 'D':
                num += 500
                i = i + 1
                continue
            elif s[i] == 'M':
                num += 1000
                i = i + 1
                continue
        if s[-1] == 'I':
            num += 1
        elif s[-1] == 'V':
            num += 5
        elif s[-1] == 'X':
            num += 10
        elif s[-1] == 'L':
            num += 50
        elif s[-1] == 'C':
            num += 100
        elif s[-1] == 'D':
            num += 500
        elif s[-1] == 'M':
            num += 1000
        return num
# @lc code=end
