/*
 * @lc app=leetcode.cn id=318 lang=java
 *
 * [318] 最大单词长度乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(String[] words) {
        int res = 0;
        int[] bytes = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                // <<这是按位左移
                // 左操作数按位左移右操作数指定的位数
                // 因为是按位或操作，所以val从低位到高位的每位代表一个字母是否存在
                // 最低位代表a最高位代表z
                val |= (1 << words[i].charAt(j) - 'a');
            }
            bytes[i] = val;
        }

        for (int i = 1; i < bytes.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果与的结果是0那么说明没有重复的字母
                if ((bytes[i] & bytes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }
}

// @lc code=end

