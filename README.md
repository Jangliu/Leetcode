#Leetcode
**my leetcode record**

##1.Maximum Subarray
问题描述：
给出一个整数的数组，从中找出连续的几个元素，并使之和最大。
```python
def maxSubArray(self, nums: List[int]) -> int:
    if not nums:
        return 0

    curSum = maxSum = nums[0]
    for num in nums[1:]:
        curSum = max(num, curSum + num)
        maxSum = max(maxSum, curSum)
    return maxSum
```
解法思路：
* 这样的问题最好是用一次遍历解决。
* 循环体中的第一行保证了一定可以找到一个正数作为连续片段的开头。
* 在找到正数作为片段开头之后，如果片段后续全是正数，那没有影响，如果开始出现负数只会影响curSum不会影响maxSum，当cursum被负数片段减小到0以下，循环体的第一行就又开始寻找正数作为新的连续片段开头。

