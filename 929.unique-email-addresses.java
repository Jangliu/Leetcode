import java.util.HashSet;

/*
 * @lc app=leetcode id=929 lang=java
 *
 * [929] Unique Email Addresses
 */

// @lc code=start
class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String s:emails){
            String[] temp = s.split("@");
            StringBuffer result = new StringBuffer();
            for(int i=0;i<temp[0].length();i++){
                if(temp[0].charAt(i)=='.'){
                    continue;
                }
                if(temp[0].charAt(i)=='+'){
                    break;
                }
                result.append(temp[0].charAt(i));
            }
            set.add(result.toString()+"@"+temp[1]);
        }
        return set.size();
    }
}
// @lc code=end

