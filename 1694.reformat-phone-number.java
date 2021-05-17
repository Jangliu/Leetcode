/*
 * @lc app=leetcode id=1694 lang=java
 *
 * [1694] Reformat Phone Number
 */

// @lc code=start
class Solution {
    public String reformatNumber(String number) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != ' ' && number.charAt(i) != '-') {
                res.append(number.charAt(i));
            }
        }
        if (res.length() <= 3) {
            return res.toString();
        }
        if (res.length() == 4) {
            res.insert(2, '-');
            return res.toString();
        }
        if (res.length() <= 6) {
            res.insert(3, '-');
            return res.toString();
        }
        int n = 0;
        int block2;
        switch (res.length() % 3) {
            case 0:
                n = res.length() / 3;
                block2 = 0;
                break;
            case 1:
                n = res.length() / 3 - 1;
                block2 = 2;
                res.insert(res.length() - 2, '-');
                res.insert(res.length() - 5, '-');
                break;
            case 2:
                n = res.length() / 3;
                block2 = 1;
                res.insert(res.length() - 2, '-');
                break;
        }
        for (int j = 0; j < n - 1; j++) {
            res.insert(3 + 4 * j, '-');
        }
        return res.toString();
    }
}
// @lc code=end

