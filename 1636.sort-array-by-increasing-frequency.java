import java.util.HashMap;

/*
 * @lc app=leetcode id=1636 lang=java
 *
 * [1636] Sort Array by Increasing Frequency
 */

// @lc code=start
class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }
            else{
                map.put(n, 1);
            }
        }
        int[][] toSorted = new int[map.size()][2];
        int i=0;
        for(int n:map.keySet()){
            toSorted[i][0]=n;
            toSorted[i][1]=map.get(n);
            i++;
        }
        for(int j=0;j<toSorted.length-1;j++){
            for(int k=0;k<toSorted.length-1-j;k++){
                if(toSorted[k][1]>toSorted[k+1][1]){
                    int[] temp = toSorted[k];
                    toSorted[k]=toSorted[k+1];
                    toSorted[k+1]=temp;
                }
                if(toSorted[k][1]==toSorted[k+1][1]&&toSorted[k][0]<toSorted[k+1][0]){
                    int[] temp = toSorted[k];
                    toSorted[k] = toSorted[k + 1];
                    toSorted[k + 1] = temp;
                }
            }
        }
        int k=0;
        for(int j=0;j<toSorted.length;j++){
            for(int l=0;l<toSorted[j][1];l++){
                nums[k]=toSorted[j][0];
                k++;
            }
        }
        return nums;
    }
}
// @lc code=end

