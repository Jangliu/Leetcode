/*
 * @lc app=leetcode.cn id=421 lang=java
 *
 * [421] 数组中两个数的最大异或值
 */

// @lc code=start
class Solution {
    // 前缀树
    // 本题中的每一个数字都是一个整型，那么可以用31位0、1来表示
    // 这样就可以构造出一颗前缀树，树中包含数组中的所有元素
    class Trie {
        // 左子树指向表示 0 的子节点
        Trie left = null;
        // 右子树指向表示 1 的子节点
        Trie right = null;
    }

    // 前缀树的根节点
    Trie root = new Trie();
    // 最高位的二进制位编号为 30
    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int res=0;
        for(int i=1;i<nums.length;i++){
            // 最大值的产生肯定是两个不同的数异或得到的
            // 那么肯定这两个数在数组中是一前一后的关系
            addToTrie(nums[i-1]);
            res = Math.max(res, checkTrie(nums[i]));
        }
        return res;
    }
    public void addToTrie(int n){
        Trie cur = root;
        for(int i=HIGH_BIT;i>=0;i--){
            int bit = (n>>i)&1;
            if(bit==0){
                if(cur.left==null){
                    cur.left = new Trie();
                }
                cur = cur.left;
            }
            else{
                if(cur.right==null){
                    cur.right = new Trie();
                }
                cur = cur.right;
            }
        }
    }
    public int checkTrie(int n){
        // 对于输入的数字n,对前缀树进行查找，查找与n异或最大的值
        Trie cur = root;
        int x = 0;
        for(int i=HIGH_BIT;i>=0;i--){
            // 从最高位开始
            int bit = (n>>i)&1;
            // 如果n的当前位为0那么所寻找的目标就是当前位为1的，即优先找右子树
            if(bit==0){
                // 如果父节点的右子树为空，说明数组中不存在当前位为1的
                if(cur.right==null){
                    // 往左子树走，右边加一个0，所以x=x*2
                    cur = cur.left;
                    x=x*2;
                }
                else{
                    // 往右子树走，右边加一个1，所以x=x*2+1
                    cur = cur.right;
                    x=x*2+1;
                }
            }
            // 如果n当前位为1，那么所寻找的目标就是当前位为0的，即优先找左子树
            // 注意，当前位为不同时，往右边加0和1的结果是不一样的
            else{
                // 如果父节点的左子树为空，
                if(cur.left==null){
                    cur = cur.right;
                    x=x*2;
                }
                else{
                    cur = cur.left;
                    x=x*2+1;
                }
            }
        }
        return x;
    }
}
// @lc code=end

