/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {
    // 本题适合采用线段树方法
    // 线段树是一种非常灵活的数据结构
    // 可以用于解决多种范围查询问题
    // 比如在对数时间内从数组中找到最小值、最大值、总和、最大公约数、最小公倍数等
    

    int[] tree;
    int n;
    // 数组 A[0,1,…,n−1]的线段树是一个二叉树
    // 其中每个节点都包含数组的一个子范围 [i…j]上的聚合信息
    // 聚合信息自己设定，可以是最小值、最大值、总和等
    // 其左、右子节点分别包含范围 [i…(i+j)/2]和 [(i+j)/2+1,j]上的信息
    // 比如本题关注的是总和
    // 那么线段树的每一个叶子节点就代表数组中的每一个初始元素
    // 非叶子节点代表了一个范围之内的元素的总和
    public NumArray(int[] nums) {
        if(nums.length>0){
            this.n=nums.length;
            this.tree=new int[2*n];
            buildTree(nums);
        }
    }
    // 具有 n个元素的数组线段树有 n个叶节点（数组元素本身）。
    // 每一层中的节点数是下面一层中节点数的一半(因为这个树的结构是二叉树)。
    // n+n/2+n/4+n/8+....1≈2n
    private void buildTree(int[] nums) {
        // 叶子节点
        for (int i = n, j = 0;  i < 2 * n; i++,  j++){
            tree[i] = nums[j];
        }
        // 通过各个叶子节点来更新根节点
        for (int i = n - 1; i > 0; --i){
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public void update(int pos, int val) {
        pos += n;
        // 更新叶子节点的值
        tree[pos] = val;
        // 从下往上更新父节点的值
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }
    
    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                // 移动到父节点右侧的兄弟节点
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                // 移动到父节点左侧的兄弟节点
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

