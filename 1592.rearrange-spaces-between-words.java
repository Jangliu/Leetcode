/*
 * @lc app=leetcode id=1592 lang=java
 *
 * [1592] Rearrange Spaces Between Words
 */

// @lc code=start
class Solution {
    public String reorderSpaces(String text) {
        //stupid question
        int countSpaces = 0;
        String space = " ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                countSpaces++;
            }
        }

        if (countSpaces == 0) {
            return text;
        }

        String trimmedText = text.trim();
        String[] arr = trimmedText.split("\\s+");

        if (arr.length == 1) {
            sb.append(arr[0]);
            sb.append(space.repeat(countSpaces));
            return sb.toString();
        }

        int divideSpaces = countSpaces / (arr.length - 1);
        int spaceLeft = countSpaces - (divideSpaces * (arr.length - 1));
        if (spaceLeft == 0) {
            // We can divide the spaces evenly in the string
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if (i <= arr.length - 2) {
                    sb.append(space.repeat(divideSpaces));
                }
            }
        } else {
            // Extra spaces would be kept in the end of string
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
                if (i <= arr.length - 2) {
                    sb.append(space.repeat(divideSpaces));
                }
            }
            sb.append(space.repeat(spaceLeft));
        }
        return sb.toString();
    }
}
// @lc code=end

