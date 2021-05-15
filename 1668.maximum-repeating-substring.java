/*
 * @lc app=leetcode id=1668 lang=java
 *
 * [1668] Maximum Repeating Substring
 */

// @lc code=start
class Solution {
    public int maxRepeating(String sequence, String word) {
        int res=0;
        for(int i=1;i<=sequence.length()/word.length();i++){
            StringBuffer temp = new StringBuffer();
            for(int k=0;k<i;k++){
                temp.append(word);
            }
            if(sequence.indexOf(temp.toString())!=-1){
                res=i;
                continue;
            }
            break;
        }
        return res;
    }
}
// @lc code=end

