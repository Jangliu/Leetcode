#Leetcode
**my leetcode record**

##1.Remove Duplicates from Sorted Array
问题描述：给出一个升序的整数数组，调整数组，使数组前n个元素都是不重复的（n为数组中不重复元素的个数）。
```java
public static int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i == 0 || n > nums[i-1])
            nums[i++] = n;
    return i;
}
```
解题思路：用一遍循环完成。i为下一个非重复元素放置在数组中的位置。执行逻辑为：数组中的第一个元素不变，i++，然后开始比较数组中后面的元素n与上一个非重复元素nums[i-1]，因为数组是升序，所以只要n>nums[i-1]就说明n不是重复的，就可以把n放到相应位置，然后循环完成。
##2.Maximum Subarray
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
##3.Climbing Stairs
问题描述：一共n级台阶，每一次只能跨越1级或者两级台阶，求上台阶的方法数目。
比如n=2时有两种解法：1+1 or 2。n=3时有三种解法：1+1+1 or 1+2 or 2+1。
```java
public int climbStairs(int n) {
    if(n == 0 || n == 1 || n == 2){return n;}
    int[] mem = new int[n];
    mem[0] = 1;
    mem[1] = 2;
    for(int i = 2; i < n; i++){
        mem[i] = mem[i-1] + mem[i-2];
    }
    return mem[n-1];
}
```
解题思路：假设走到n级有a种方法，走到n+1级有b种方法，那么求走到n+2级的方法数就等于a+b。
因为：走到n+2级的方法=走到n级的方法*2+走到n+1级的方法-重复的方法
重复的方法就是从n级走到n+1级再走到n+2级。
##4.Same Tree
问题描述：判断给出的两颗树是否完全一致。

```python
def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
    if p and q:
        return p.val == q.val and self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
    return p is q
```

总结：解题的时候想到了需要嵌套调用，但是自己想的太浅了，没有用更简便的思维。比如这里，既然题目的函数就是判断是否一致，直接调用即可，只是要注意调用的条件。比如第一个判断就是节点是否为空，如果都非空，那么进行下面的步骤。否则的话就说明两个节点至少有一个为空，那么只需要判断两者是否都为空即可。

##5.Symmetric Tree
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