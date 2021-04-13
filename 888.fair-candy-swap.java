import java.util.HashSet;

/*
 * @lc app=leetcode id=888 lang=java
 *
 * [888] Fair Candy Swap
 */

// @lc code=start
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        HashSet<Integer> numA = new HashSet<>();
        HashSet<Integer> numB = new HashSet<>();
        int[] result = new int[2];
        int sumA =0;
        int sumB = 0;
        for(int i=0;i<A.length;i++){
            numA.add(A[i]);
            sumA+=A[i];
        }
        for (int i = 0; i < B.length; i++) {
            numB.add(B[i]);
            sumB+=B[i];
        }
        int difference = sumB-sumA;
        for(int key:numA){
            if(numB.contains(difference/2+key)){
                result[0]=key;
                result[1]=difference/2+key;
                return result;
            }
        }
        return result;
    }
}
// @lc code=end

