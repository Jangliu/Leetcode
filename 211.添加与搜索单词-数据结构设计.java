/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class Trie {

    Trie[] children;
    boolean isEnd;

    public Trie() { // 初始化

        children = new Trie[26];
        isEnd = false;
    }
}

class WordDictionary {

    Trie root;

    public WordDictionary() {

        root = new Trie(); // 初始化
    }

    public void addWord(String word) { // 将 word 添加到数据结构中，之后可以对它进行匹配

        Trie node = this.root;
        int n = word.length();
        for (int i = 0; i < n; i++) {

            if (node.children[word.charAt(i) - 'a'] == null) {

                node.children[word.charAt(i) - 'a'] = new Trie();
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {

        return searchWord(word, this.root);
    }

    public boolean searchWord(String word, Trie root) { // 递归

        Trie node = root;
        int n = word.length();
        for (int i=0;i<n;i++) {

            char c = word.charAt(i);
            if (c != '.' && node.children[c - 'a'] == null) return false;
            if (c == '.') { // 如果是 '.'，则对该节点所有不为空的节点进行深度搜索

                for (int j=0;j<26;j++) { // 继续遍历 node.children[26]

                    // 如果存在下一个字母，则从下一个字母开始再继续做检查
                    if (node.children[j] != null) {

                        if (searchWord(word.substring(i + 1), node.children[j])) {

                            return true;
                        }
                    }
                }
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

