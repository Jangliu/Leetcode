import java.util.HashMap;

/*
 * @lc app=leetcode id=507 lang=java
 *
 * [507] Perfect Number
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==1){
            return false;
        }
        HashMap<Integer,Boolean> map =new HashMap<Integer, Boolean>();
        for(int i=1;i<=num/2;i++){
            if(num%i==0){
                map.put(i, true);
                map.put(num%i, true);
            }
        }
        int count=0;
        for(int key:map.keySet()){
            if(key!=num){
                count+=key;
            }
            if(count>num){
                return false;
            }
        }
        return count==num?true:false;
    }
}
// @lc code=end

