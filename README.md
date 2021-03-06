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

##2.Same Tree
问题描述：判断给出的两颗树是否完全一致。

```python
def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
    if p and q:
        return p.val == q.val and self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
    return p is q
```

总结：解题的时候想到了需要嵌套调用，但是自己想的太浅了，没有用更简便的思维。比如这里，既然题目的函数就是判断是否一致，直接调用即可，只是要注意调用的条件。比如第一个判断就是节点是否为空，如果都非空，那么进行下面的步骤。否则的话就说明两个节点至少有一个为空，那么只需要判断两者是否都为空即可。

##3.Symmetric Tree
问题描述：
给出一个树，判断其是否为左右对称的。
```python
def isSymmetric(self, root: TreeNode) -> bool:
    def isSym(L, R):
        if not L and not R: 
            return True
        if L and R and L.val == R.val:
            return isSym(L.left, R.right) and isSym(L.right, R.left)
        return False

    return isSym(root, root)
```
解法思路：循环嵌套调用基本的判断函数，输入为对称的两个节点L和R，如果L和R的值相等，那么为了对称，L的左子节点和R的右子节点必须相同，且L的右子节点必须和R的左子节点相同，继续调用函数即可。