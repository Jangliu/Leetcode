import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=1700 lang=java
 *
 * [1700] Number of Students Unable to Eat Lunch
 */

// @lc code=start
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] a = new int[2];
        for (int i = 0; i < students.length; i++)
            a[students[i]] += 1;
        int k = 0;
        while (k < sandwiches.length) {
            //需要某种三明治的学生人数=0的时候就说明后面的肯定不够了，就可以退出循环了
            if (a[sandwiches[k]] > 0)
                a[sandwiches[k]] -= 1;
            else
                break;
            k ++;
        }
        return sandwiches.length - k;
    }
}
// @lc code=end

