/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        StringBuffer res = new StringBuffer();
        while(num>0){
            if(num>=1000){
                for(int i=0;i<num/1000;i++){
                    res.append("M");
                }
                num=num%1000;
                continue;
            }
            if(num>=900){
                res.append("CM");
                num=num-900;
                continue;
            }
            if(num>=500){
                res.append("D");
                num-=500;
                continue;
            }
            if(num>=400){
                res.append("CD");
                num-=400;
                continue;
            }
            if(num>=100){
                res.append("C");
                num-=100;
                continue;
            }
            if(num>=90){
                res.append("XC");
                num-=90;
                continue;
            }
            if(num>=50){
                res.append("L");
                num-=50;
                continue;
            }
            if (num >= 40) {
                res.append("XL");
                num -= 40;
                continue;
            }
            if (num >= 10) {
                res.append("X");
                num -= 10;
                continue;
            }
            if (num >= 9) {
                res.append("IX");
                num -= 9;
                continue;
            }
            if (num >= 5) {
                res.append("V");
                num -= 5;
                continue;
            }
            if (num >= 4) {
                res.append("IV");
                num -= 4;
                continue;
            }
            else{
                for(int i=0;i<num;i++){
                    res.append("I");
                }
                break;
            }
        }
        return res.toString();
    }
}
// @lc code=end

