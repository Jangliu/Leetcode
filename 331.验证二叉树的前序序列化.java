import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start
class Solution {
    boolean[] isVisited;
    public boolean isValidSerialization(String preorder) {
        if(preorder.charAt(0)=='#'){
            return false;
        }
        String[] strs = preorder.split(",");
        isVisited = new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if(isVisited[i]){
                continue;
            }
            if(!isValidSerializationDfs(i, preorder)){
                return false;
            }
        }
        return true;
    }
    public boolean isValidSerializationDfs(int i,String[] strs){
        if(strs[i]=='#'){
            return true;
        }
        return isValidSerializationDfs(i*2+1,strs)&&isValidSerializationDfs(i*2+2, strs);

    }
}
// @lc code=end

