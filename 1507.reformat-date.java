/*
 * @lc app=leetcode id=1507 lang=java
 *
 * [1507] Reformat Date
 */

// @lc code=start
class Solution {
    public String reformatDate(String date) {
        if (date == null || date.length() == 0)
            return null;

        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        String[] dateArr = date.split(" ");

        String dayStr = dateArr[0].substring(0, dateArr[0].length() - 2);

        if (dayStr.length() == 1)
            dayStr = '0' + dayStr;

        return dateArr[2] + "-" + months.get(dateArr[1]) + "-" + dayStr;
    }
}
// @lc code=end

