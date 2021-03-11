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

```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p==null && q==null){
        return true;
    }
    while(p != null && q != null){
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    return false;
}
```

总结：解题的时候想到了需要嵌套调用，但是自己想的太浅了，没有用更简便的思维。比如这里，既然题目的函数就是判断是否一致，直接调用即可，只是要注意调用的条件。比如第一个判断就是节点是否为空，如果都非空，那么进行下面的步骤。否则的话就说明两个节点至少有一个为空，那么只需要判断两者是否都为空即可。

##5.Symmetric Tree
问题描述：
给出一个树，判断其是否为左右对称的。
```java
public boolean isSymmetric(TreeNode root) {
    return isSym(root, root);
}
public static boolean isSym(TreeNode t1,TreeNode t2){
    if(t1==null &&t2==null){
        return true;
    }
    while(t1!= null && t2!=null){
        if(t1.val!=t2.val){
            return false;
        }
        return isSym(t1.left, t2.right) &&isSym(t1.right, t2.left);
    }
    return false;
    }
```
解法思路：循环嵌套调用基本的判断函数，输入为对称的两个节点L和R，如果L和R的值相等，那么为了对称，L的左子节点和R的右子节点必须相同，且L的右子节点必须和R的左子节点相同，继续调用函数即可。

##6.Pascals-Triangle
问题描述：输入numRow,输出杨辉三角的numRos+1行。
```java
public List<Integer> getRow(int rowIndex) {
    Integer[] arr = new Integer[rowIndex + 1];
    Arrays.fill(arr, 0);
    arr[0] = 1;

    for (int i = 1; i <= rowIndex; i++)
        for (int j = i; j > 0; j--)
            arr[j] = arr[j] + arr[j - 1];

    return Arrays.asList(arr);
    }
```
解题思路：如果使用先构造杨辉三角再输出指定行，耗时更多，所以采用直接构造杨辉三角的指定行。
* 初始化数组，杨辉三角的第n行有n个元素，同时首个元素必定为1。
* 初始化了数组，数组中的非0元素就组成了杨辉三角的第一行。
* 根据杨辉三角的第一行开始构造第二行，然后循环，直到构造出杨辉三角的所求行。

##7.Single Number
问题描述：给出一个非空数组，只有一个元素只出现一次，别的元素都出现两次
```java
public int singleNumber(int[] nums) {
    int result = 0;
    for (int i : nums) {
        result ^= i;
    }
    return result;
}
```
解题思路：其余元素都出现两次，即可以使用按位异或操作^,两个相同的数异或等于0，而0异或任何数等于任何数本身。

##8.Linked List Cycle
问题描述：给出一个链表的head，判断在这个链表中是否有循环，即在这个链表中有一个圈。
```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null)
        return false;
    if (head.next == head)
        return true;
    ListNode nextNode = head.next;
    head.next = head;
    boolean isCycle = hasCycle(nextNode);
    return isCycle;
}
```
解法思路：
* 首先判断此链表是单链表非循环的情况，即有尾节点。
* 再判断是否头节点就是循环的圈。
* 接下来，假设head没有在圈里，那么head将被抛开，此节点从链表中断开。
* 最后假设head是在循环中的，那么相当于把循环的圈断开了，head指向自身，又因为head在循环中，那么必定在此循环的圈中有一个节点指向head。如此嵌套调用hasCycle()函数，即可。

##9.Two Sum II - Input array is sorted
问题描述：给出一个升序的数组，从数组中找到两个数的和等于给定的目标值。返回两数的下标+1；
```java
public int[] twoSum(int[] numbers, int target) {
    int l = 0, r = numbers.length - 1;
    while (numbers[l] + numbers[r] != target) {
        if (numbers[l] + numbers[r] > target)
            r--;
        else
            l++;
    }
    return new int[] { l + 1, r + 1 };
    }
```
解题思路：从一首（l）一尾（r）开始，因为数组是升序的，如果首尾的值相加大于目标值就说明应该r=r-1,否则的话就应该l=l+1。