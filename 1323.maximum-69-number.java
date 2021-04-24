import java.util.ArrayList;

/*
 * @lc app=leetcode id=1323 lang=java
 *
 * [1323] Maximum 69 Number
 */

// @lc code=start
class Solution {
    public int maximum69Number (int num) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(num);
        for(int i = 0 ; i < sb.length() ; i++){
            if(sb.charAt(i) != '9'){
                sb.setCharAt(i,'9');
                break;
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}
// @lc code=end

