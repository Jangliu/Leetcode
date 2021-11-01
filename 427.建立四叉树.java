import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=427 lang=java
 *
 * [427] 建立四叉树
 */

// @lc code=start
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        //left, right, up, down
        return helper(grid, 0, grid.length - 1, 0, grid[0].length - 1);
    }

    private Node helper(int[][] grid, int left, int right, int up, int down){
        Node root  = new Node();
        if(isSame(grid, left, right, up, down)){
            root.val = grid[up][left] == 1 ? true : false;
            root.isLeaf = true;
            return root;
        }

        root.isLeaf = false;
        root.topLeft     = helper(grid, left, (right + left) / 2,  up, (up + down) / 2);
        root.topRight    = helper(grid, (right + left) / 2 + 1 , right, up, (up + down) / 2);
        root.bottomLeft  = helper(grid, left, (right + left) / 2 , (up + down) / 2 + 1, down);
        root.bottomRight = helper(grid, (right + left) / 2 + 1, right, (up + down) / 2 + 1, down);
        
        return root;
    }
    // 判断left,right,up,down圈出来的区域里的值是否一致
    private boolean isSame(int[][] grid, int left, int right, int up, int down){
        int pre = grid[up][left];
        for(int i = up; i <= down; i++)
            for(int j = left; j <= right; j++)
                if(pre != grid[i][j])
                    return false;
        return true;
    }
}
// @lc code=end

