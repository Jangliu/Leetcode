import java.util.HashMap;

/*
 * @lc app=leetcode id=575 lang=java
 *
 * [575] Distribute Candies
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candyType) {
        HashMap<Integer,Integer> val = new HashMap<Integer,Integer>();
        int count = 0;
        for(int i=0;i<candyType.length;i++){
            if(!val.containsKey(candyType[i])){
                val.put(candyType[i], 1);
                count++;
                if(count==candyType.length/2){
                    break;
                }
            }
        }
        return val.size();
    }
}
// @lc code=end

