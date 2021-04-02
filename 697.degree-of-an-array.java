import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=697 lang=java
 *
 * [697] Degree of an Array
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int maxCount = 0;
        int minLength = 0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                ArrayList<Integer> temp = map.get(nums[i]);
                temp.add(i);
                map.replace(nums[i], temp);
            }
            else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                map.put(nums[i], temp);
            }
        }
        for(int key :map.keySet()){
            if(map.get(key).size()>maxCount){
                minLength = map.get(key).get(map.get(key).size()-1)-map.get(key).get(0);
                maxCount = map.get(key).size();
            }
            if(map.get(key).size()==maxCount){
                int temp = map.get(key).get(map.get(key).size() - 1) - map.get(key).get(0);
                minLength=Math.min(temp,minLength);
            }
        }
        return minLength+1;
    }
}
// @lc code=end

