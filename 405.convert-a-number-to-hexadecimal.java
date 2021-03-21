/*
 * @lc app=leetcode id=405 lang=java
 *
 * [405] Convert a Number to Hexadecimal
 */

// @lc code=start
class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        long number;
        if (num < 0) {
            int temp = 2147483647;
            number = temp & num;
            number += 2147483648l;
        } else {
            number = num;
        }
        String result = "";
        int n = (int) (number / 16);
        int rest = (int) (number % 16);
        while (n >= 1) {
            switch (rest) {
            case 0:
                result = "0" + result;
                break;
            case 1:
                result = "1" + result;
                break;
            case 2:
                result = "2" + result;
                break;
            case 3:
                result = "3" + result;
                break;
            case 4:
                result = "4" + result;
                break;
            case 5:
                result = "5" + result;
                break;
            case 6:
                result = "6" + result;
                break;
            case 7:
                result = "7" + result;
                break;
            case 8:
                result = "8" + result;
                break;
            case 9:
                result = "9" + result;
                break;
            case 10:
                result = "a" + result;
                break;
            case 11:
                result = "b" + result;
                break;
            case 12:
                result = "c" + result;
                break;
            case 13:
                result = "d" + result;
                break;
            case 14:
                result = "e" + result;
                break;
            case 15:
                result = "f" + result;
                break;
            }
            number = (number - rest) / 16;
            n = (int) (number / 16);
            rest = (int) (number % 16);
        }
        if (rest == 0) {
            return result;
        } else {
            switch (rest) {
            case 0:
                result = "0" + result;
                break;
            case 1:
                result = "1" + result;
                break;
            case 2:
                result = "2" + result;
                break;
            case 3:
                result = "3" + result;
                break;
            case 4:
                result = "4" + result;
                break;
            case 5:
                result = "5" + result;
                break;
            case 6:
                result = "6" + result;
                break;
            case 7:
                result = "7" + result;
                break;
            case 8:
                result = "8" + result;
                break;
            case 9:
                result = "9" + result;
                break;
            case 10:
                result = "a" + result;
                break;
            case 11:
                result = "b" + result;
                break;
            case 12:
                result = "c" + result;
                break;
            case 13:
                result = "d" + result;
                break;
            case 14:
                result = "e" + result;
                break;
            case 15:
                result = "f" + result;
                break;
            }
        }
        return result;
    }
}
// @lc code=end

