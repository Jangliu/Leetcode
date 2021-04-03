import java.util.HashMap;

/*
 * @lc app=leetcode id=720 lang=java
 *
 * [720] Longest Word in Dictionary
 */

// @lc code=start
class Solution {
    private TreeNode root;
    private String result = "";
    //真的是傻逼题目，还要按照字典顺序，吐了
    public String longestWord(String[] words) {
        root = new TreeNode();

        for (String w : words)
            insert(w);

        dfs(root);

        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null)
            return;

        if (node.word != null) {
            if (node.word.length() > result.length())
                result = node.word;
            else if (node.word.length() == result.length() && node.word.compareTo(result) < 0)
                result = node.word;
        }

        for (TreeNode child : node.children)
            if (child != null && child.word != null)
                dfs(child);
    }

    private void insert(String word) {
        TreeNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TreeNode();
            current = current.children[c - 'a'];
        }
        current.word = word;
    }

}

class TreeNode {
    TreeNode[] children = new TreeNode[26];
    String word;

    TreeNode() {
    }
}
// @lc code=end

