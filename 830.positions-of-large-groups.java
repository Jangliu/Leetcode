import java.util.ArrayList;

/*
 * @lc app=leetcode id=830 lang=java
 *
 * [830] Positions of Large Groups
 */

// @lc code=start
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i=0;
        while(i<s.length()-1){
            if(s.charAt(i)==s.charAt(i+1)){
                int j=i+1;
                while(j<s.length()&&s.charAt(j)==s.charAt(i)){
                    j++;
                }
                if(j-i>=3){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j-1);
                    result.add(temp);
                }
                i=j;
            }
            else{
                i++;
            }
        }
        return result;
    }
}
// @lc code=end

