/*
 * @lc app=leetcode id=1399 lang=java
 *
 * [1399] Count Largest Group
 */

// @lc code=start
class Solution {
    public int countLargestGroup(int n) {
        int[] sum =new int[37];
        //n最大值10000，所以9999是加起来数字最大的，是36
        for (int i = 1; i <= n; i++) {
            int num = i;
            int count = 0;
            while (num >= 10) {
                count += num % 10;
                num = num / 10;
            }
            count += num;
            sum[count]++;
        }
        int largest = 0;
        int size = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > largest) {
                largest = sum[i];
                size = 1;
                continue;
            }
            if (sum[i] == largest) {
                size++;
            }
        }
        return size;
    }
}
// @lc code=end

