import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=390 lang=java
 *
 * [390] 消除游戏
 */

// @lc code=start
class Solution {
    public int lastRemaining(int n) {
        // 每次消除留下来的数以及各个数之间差的规律
        if(n==1){
            return 1;
        }
        int left = 2;
        int right = n%2==0?n:n-1;
        int count = n/2;
        int level = 2;
        while(left!=right){
            right-=level;
            if(count%2!=0){
                left+=level;
            }
            level*=2;
            count=count/2;
            if(left==right){
                break;
            }
            left+=level;
            if(count%2!=0){
                right-=level;
            }
            level*=2;
            count=count/2;
        }
        return left;
    }
}
// @lc code=end

