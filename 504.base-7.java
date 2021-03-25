/*
 * @lc app=leetcode id=504 lang=java
 *
 * [504] Base 7
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        String result="";
        boolean flag=true;
        if(num<=0)
        {
            flag=false;
            num=-num;
        }
        int n=num/7;
        int rest=num%7;
        while(n>=1){
            result=String.valueOf(rest)+result;
            num=(num-rest)/7;
            n=num/7;
            rest=num%7;
        }
        if(rest==0){
            return result.length()==0?"0":result;
        }
        return flag==true?String.valueOf(rest)+result:"-"+ String.valueOf(rest)+result;
    }
}
// @lc code=end

