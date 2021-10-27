
/*
 * @lc app=leetcode.cn id=423 lang=java
 *
 * [423] 从英文中重建数字
 */

// @lc code=start
class Solution {
    public String originalDigits(String s) {
        // 对英文数字找规律即可，比如只有zero里面才有z
        int[] wordCount = new int[26];
        for (char word : s.toCharArray()) {
            wordCount[word - 'a']++;
        }

        int[] results = new int[10];
        results[0] = wordCount['z' - 'a'];
        results[2] = wordCount['w' - 'a'];
        results[4] = wordCount['u' - 'a'];
        results[6] = wordCount['x' - 'a'];
        results[8] = wordCount['g' - 'a'];
        results[3] = wordCount['h' - 'a'] - results[8];
        results[5] = wordCount['f' - 'a'] - results[4];
        results[7] = wordCount['s' - 'a'] - results[6];
        results[9] = wordCount['i' - 'a'] - results[5] - results[6] - results[8];
        results[1] = wordCount['n' - 'a'] - results[7] - 2 * results[9];

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < results[i]; j++) {
                result.append(i);
            }
        }
        return result.toString();
    }
}

// @lc code=end

