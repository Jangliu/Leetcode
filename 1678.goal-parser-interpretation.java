/*
 * @lc app=leetcode id=1678 lang=java
 *
 * [1678] Goal Parser Interpretation
 */

// @lc code=start
class Solution {
    public String interpret(String command) {
        StringBuffer res = new StringBuffer();
        int i=0;
        while(i<command.length()-1){
            if(command.charAt(i)=='('&&command.charAt(i+1)==')'){
                res.append('o');
                i=i+2;
                continue;
            }
            if(command.charAt(i)=='('&&command.charAt(i+1)!=')'){
                i++;
                continue;
            }
            if(command.charAt(i)!=')'){
                res.append(command.charAt(i));
            }
            i++;
        }
        if(command.charAt(command.length() - 1) != '('&&command.charAt(command.length()-1)!=')'){
            res.append(command.charAt(command.length() - 1));
        }
        return res.toString();
    }
}
// @lc code=end

