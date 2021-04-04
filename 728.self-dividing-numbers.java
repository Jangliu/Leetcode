import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=728 lang=java
 *
 * [728] Self Dividing Numbers
 */

// @lc code=start
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (self(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean self(int number) {
        int temp = number;
        while (number > 0) {
            // 在算每一位的数字的时候不用先加了再判断，可以直接判断这个数字是否对
            int x = number % 10; // digit extracted
            if (x == 0)
                return false;
            else if (temp % x != 0) {
                return false;
            }
            number = number / 10;
        }
        return true;

    }
}
// @lc code=end

