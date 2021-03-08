/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        boolean flag = false;
        String c = "";
        String longer;
        int i = a.length() - 1, j = b.length() - 1;
        if (i >= j) {
            longer = a;
        } else {
            longer = b;
        }
        while (i >= 0 && j >= 0) {
            char[] ab = { a.charAt(i), b.charAt(j) };
            String s = new String(ab);
            if (flag) {
                switch (s) {
                case "00":
                    c = "1" + c;
                    flag = false;
                    break;
                case "01":
                    c = "0" + c;
                    break;
                case "10":
                    c = "0" + c;
                    break;
                case "11":
                    c = "1" + c;
                    break;
                }
                i--;
                j--;
                continue;
            } else {
                switch (s) {
                case "00":
                    c = "0" + c;
                    break;
                case "01":
                    c = "1" + c;
                    break;
                case "10":
                    c = "1" + c;
                    break;
                case "11":
                    c = "0" + c;
                    flag = true;
                    break;
                }
                i--;
                j--;
            }

        }
        int n = Math.max(i, j);
        while (n >= 0) {
            if (flag) {
                if (longer.charAt(n) == '0') {
                    c = "1" + c;
                    n--;
                    flag = false;
                } else {
                    c = "0" + c;
                    n--;
                }
            } else {
                c = longer.substring(0, n + 1) + c;
                return c;
            }
        }
        if (flag) {
            return "1" + c;
        }
        return c;
    }
    
}
// @lc code=end

