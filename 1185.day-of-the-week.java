/*
 * @lc app=leetcode id=1185 lang=java
 *
 * [1185] Day of the Week
 */

// @lc code=start
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int daily = 0;
        int theYear = 1971;
        // int theDay = 5;
        int sumDay = -1;
        while (theYear < year) {
        if (theYear % 400 == 0 || (theYear % 4 == 0 && theYear % 100 != 0)) {
                //可以被400整除的年份一定是闰年,可以被4整除但是不能被100整除的年份是闰年 366天
                sumDay = sumDay + 366;
            } else {
                sumDay = sumDay + 365;
            }
            theYear++;
        }
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {//闰年
            if (month == 1) ;
            else if (month == 2) sumDay = sumDay + 31;
            else if (month == 3) sumDay = sumDay + 60;
            else if (month == 4) sumDay = sumDay + 91;
            else if (month == 5) sumDay = sumDay + 121;
            else if (month == 6) sumDay = sumDay + 152;
            else if (month == 7) sumDay = sumDay + 182;
            else if (month == 8) sumDay = sumDay + 213;
            else if (month == 9) sumDay = sumDay + 244;
            else if (month == 10) sumDay = sumDay + 274;
            else if (month == 11) sumDay = sumDay + 305;
            else if (month == 12) sumDay = sumDay + 335;
        }else {//平年
            if (month == 1) ;
            else if (month == 2) sumDay = sumDay + 31;
            else if (month == 3) sumDay = sumDay + 59;
            else if (month == 4) sumDay = sumDay + 90;
            else if (month == 5) sumDay = sumDay + 120;
            else if (month == 6) sumDay = sumDay + 151;
            else if (month == 7) sumDay = sumDay + 181;
            else if (month == 8) sumDay = sumDay + 212;
            else if (month == 9) sumDay = sumDay + 243;
            else if (month == 10) sumDay = sumDay + 273;
            else if (month == 11) sumDay = sumDay + 304;
            else if (month == 12) sumDay = sumDay + 334;
        }
        sumDay = sumDay + day;
        daily = sumDay % 7;
        String[] str = new String[7];
        str[0] =  "Friday";
        str[1] =  "Saturday";
        str[2] = "Sunday";
        str[3] =  "Monday";
        str[4] = "Tuesday";
        str[5] =  "Wednesday";
        str[6] =  "Thursday";
        return str[daily];
    }
}

// @lc code=end

