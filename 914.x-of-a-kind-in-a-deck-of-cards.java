import java.util.HashMap;

/*
 * @lc app=leetcode id=914 lang=java
 *
 * [914] X of a Kind in a Deck of Cards
 */

// @lc code=start
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<deck.length;i++){
            if(map.containsKey(deck[i])){
                map.replace(deck[i], map.get(deck[i])+1);
            }
            else{
                map.put(deck[i], 1);
            }
        }
        int[] nums = new int[map.size()];
        int i=0;
        for(int key:map.keySet()){
            min = Math.min(map.get(key), min);
            nums[i]=map.get(key);
            i++;
        }
        if(min<2){
            return false;
        }
        for(i=2;i<=min;i++){
            int j=0;
            for(;j<nums.length;j++){
                if(nums[j]%i!=0){
                    break;
                }
            }
            if(j==nums.length){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

