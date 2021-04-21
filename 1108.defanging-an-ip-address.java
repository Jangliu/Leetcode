/*
 * @lc app=leetcode id=1108 lang=java
 *
 * [1108] Defanging an IP Address
 */

// @lc code=start
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder r = new StringBuilder();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)!='.'){
                r.append(address.charAt(i));
            }
            else{
                r.append("[.]");
            }
        }
        return r.toString();
    }
}
// @lc code=end

