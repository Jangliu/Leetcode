import java.util.HashSet;

/*
 * @lc app=leetcode id=961 lang=java
 *
 * [961] N-Repeated Element in Size 2N Array
 */

// @lc code=start
class Solution {
    public int repeatedNTimes(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<A.length;i++){
            if(!set.add(A[i])){
                return A[i];
            }
        }
        return 0;
    }
}
// @lc code=end

