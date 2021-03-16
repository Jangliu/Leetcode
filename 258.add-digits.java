import java.util.ArrayList;

/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        while(num>=10){
            ArrayList<Integer> digits = new ArrayList<Integer>();
            int n=1;
            int rest;
            while(n>0){
                rest = num % 10;
                digits.add(rest);
                num = (num - rest) / 10;
                n = num;
            }
            int temp=0;
            for(int i=0;i<digits.size();i++){
                temp+=digits.get(i);
            }
            num = temp;
        }
        return num;
    }
}
// @lc code=end

