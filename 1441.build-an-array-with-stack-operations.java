import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1441 lang=java
 *
 * [1441] Build an Array With Stack Operations
 */

// @lc code=start
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int j=1;
        for(int i=0;i<target.length;i++){
            if(target[i]==j){
                result.add("Push");
                j++;
                continue;
            }
            if(target[i]>j){
                for(int k=0;k<target[i]-j;k++){
                    result.add("Push");
                    result.add("Pop");
                }
                result.add("Push");
                j=target[i]+1;
                continue;
            }
        }
        return result;
    }
}
// @lc code=end

