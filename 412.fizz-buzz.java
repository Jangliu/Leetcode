import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        for(int i=1;i<n+1;i++){
            String temp="";
            if(i%3!=0&&i%5!=0){
                result.add(String.valueOf(i));
                continue;
            }
            if(i%3==0){
                temp+="Fizz";
            }
            if(i%5==0){
                temp+="Buzz";
            }
            result.add(temp);
        }
        return result;
    }
}
// @lc code=end

