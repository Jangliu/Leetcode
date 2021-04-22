/*
 * @lc app=leetcode id=1154 lang=java
 *
 * [1154] Day of the Year
 */

// @lc code=start
class Solution {
    public int dayOfYear(String date) {
        int year = Integer.valueOf(date.split("-")[0]);
        int month = Integer.valueOf(date.split("-")[1]);
        int day = Integer.valueOf(date.split("-")[2]);
        boolean flag = false;
        if((year%4==0&&year%100!=0)||year%400==0){
            flag=true;
        }
        int[] monthday  = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(flag){
            monthday[1]=29;
        }
        int result = 0;
        for(int i=0;i<month-1;i++){
            result+=monthday[i];
        }
        result+=day;
        return result;
    }
}
// @lc code=end

