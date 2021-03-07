import java.util.ArrayList;

/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        int[] temp = new int[digits.length+1];
        for(int i=1;i<digits.length+1;i++){
            temp[i]=digits[i-1];
        }
        temp[digits.length]+=1;
        for(int i=temp.length-1;i>=0;i--){
            if(flag){
                temp[i]+=1;
                if(temp[i]>=10){
                    flag = true;
                    temp[i]=temp[i]-10;
                }
                else{
                flag=false;
                }
            }
            if(temp[i]>=10){
                flag=true;
                temp[i]=temp[i]-10;
            }
        }
        if(temp[0]!=0){
            return temp;
        }
        else{
            int[] newdigits = new int[temp.length-1];
            for(int i =1;i<temp.length;i++){
                newdigits[i-1]=temp[i];
            }
            return newdigits;
        }
    }
}
// @lc code=end

