import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.RunnableScheduledFuture;

/*
 * @lc app=leetcode id=1005 lang=java
 *
 * [1005] Maximize Sum Of Array After K Negations
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        if (A[0] >= 0 && K % 2 != 0) {
            A[0] = -A[0];
        } else if (A[0] < 0) { 
            // && K % 2 == 0) 
            int change = 0;
            while (K > 0 && A[change] < 0 && change < A.length) {
                A[change] = -A[change];
                change++;
                K--;
            }
            if (K % 2 != 0) {
                int index = A[change] < A[change - 1] ? change : change - 1;
                A[index] = -A[index];
                //此时已经将所有负元素都替换玩了，change处在原来的正负交界处
            }
        }
        for (int val : A)
            sum += val;
        return sum;
    }
}
// @lc code=end

