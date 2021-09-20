import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> index = new Stack<>();
        for(int i=0;i<chars.length;i++){
            switch(chars[i]){
                case '[':
                    index.push(i);
                    break;
                case ']':
                    map.put(index.pop(), i);
                    break;
                default:
                    break;
            }
        }
        int k=0;
        int i=0;
        while(i<chars.length){
            if(chars[i]=='['){
                String temp = decodeString(s.substring(i + 1, map.get(i)));
                for (int j = 0; j < k; j++) {
                    res.append(temp);
                }
                i = map.get(i) + 1;
                k=0;
            }
            else if(chars[i]>='0'&&chars[i]<='9'){
                k=k*10 + chars[i] - '0';
                i++;
            }
            else{
                res.append(chars[i]);
                i++;
            }
        }
        return res.toString();
    }
}
// @lc code=end

