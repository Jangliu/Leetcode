/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String temp = countAndSay(n-1);
        StringBuffer buffer = new StringBuffer();
        int i=0;
        while(i<temp.length()-1){
            int j=i+1;
            int count=1;
            while(j<temp.length()){
                if(temp.charAt(j)==temp.charAt(i)){
                    count++;
                    j++;
                }
                else{
                    break;
                }
            }
            buffer.append(count);
            buffer.append(temp.charAt(i));
            if(j==temp.length()){
                return buffer.toString();
            }
            i=j;
        }
        buffer.append("1");
        buffer.append(temp.charAt(temp.length()-1));
        return buffer.toString();
    }
}
// @lc code=end

