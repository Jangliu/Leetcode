/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        serializeHelper(root, stringBuilder);
        String res=stringBuilder.toString();
        return res.substring(0,res.length()-1<=0?0: res.length() - 1);
    }
    public void serializeHelper(TreeNode root,StringBuilder stringBuilder){
        if(root==null){
            return;
        }
        stringBuilder.append(String.valueOf(root.val));
        stringBuilder.append(" ");
        serializeHelper(root.left, stringBuilder);
        serializeHelper(root.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] strs = data.split(" ");
        int[] vals =new int[strs.length];
        if(vals.length==0){
            return null;
        }
        for(int i=0;i<vals.length;i++){
            vals[i]=Integer.valueOf(strs[i]);
        }
        int ep = -1;
        for(int i=1;i<vals.length;i++){
            if(vals[i]>vals[0]){
                ep=i;
                break;
            }
        }
        TreeNode res = new TreeNode(vals[0]);
        res.left = deserializeHelper(vals, 1, ep==-1?vals.length:ep);
        res.right = deserializeHelper(vals,ep==-1?vals.length:ep,vals.length);
        return res;
    }
    public TreeNode deserializeHelper(int[] vals,int sp,int ep){
        if(sp==ep){
            return null;
        }
        TreeNode res = new TreeNode(vals[sp]);
        int n = -1;
        for(int i=sp+1;i<ep;i++){
            if(vals[i]>vals[sp]){
                n=i;
                break;
            }
        }
        res.left = deserializeHelper(vals, sp+1, n==-1?ep:n);
        res.right = deserializeHelper(vals, n==-1?ep:n, ep);
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end

