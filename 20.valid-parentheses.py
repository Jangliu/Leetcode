#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        l = len(s)
        R = []
        if l % 2 != 0:
            return False
        else:
            for i in range(l):
                if s[i] == '(':
                    R.append("(")
                elif s[i] == '[':
                    R.append("[")
                elif s[i] == '{':
                    R.append("{")
                elif s[i] == ')':
                    if len(R) == 0:
                        return False
                    else:
                        if R[-1] == '(':
                            R.pop()
                        else:
                            return False
                elif s[i] == ']':
                    if len(R) == 0:
                        return False
                    else:
                        if R[-1] == '[':
                            R.pop()
                        else:
                            return False
                elif s[i] == '}':
                    if len(R) == 0:
                        return False
                    else:
                        if R[-1] == '{':
                            R.pop()
                        else:
                            return False
            if len(R) != 0:
                return False
            else:
                return True
# @lc code=end
