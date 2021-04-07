/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet();
        for (String word : banned)
            banSet.add(word);
        Map<String, Integer> strCount = new HashMap();
        int n = paragraph.length();

        int left = 0, right = 1;
        if (Character.isLetter(paragraph.charAt(n - 1)))
            paragraph += ".";
        char[] charParagraph = paragraph.toCharArray();
        int max = 0;
        String maxWord = "";
        while (left < n) {
            while (Character.isLetter(charParagraph[right])) {
                right++;
            }
            String currWord = paragraph.substring(left, right).toLowerCase();
            if (!banSet.contains(currWord)) {
                int newCount = strCount.getOrDefault(currWord, 0) + 1;
                strCount.put(currWord, newCount);
                if (newCount > max) {
                    max = newCount;
                    maxWord = currWord;
                }
            }
            while (right < n && !Character.isLetter(charParagraph[right]))
                right++;
            left = right;
        }
        return maxWord;
    }
}
// @lc code=end

