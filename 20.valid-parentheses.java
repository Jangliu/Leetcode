import java.util.ArrayList;/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> List = new ArrayList<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            switch(c){
                case '(':
                    List.add(c);
                    break;
                case '[':
                    List.add(c);
                    break;
                case '{':
                    List.add(c);
                    break;
                case ')':
                    if(List.size() == 0 || List.get(List.size()-1) != '('){
                        return false;
                    }
                    else{
                        List.remove(List.size()-1);
                        break;
                    }
                case ']':
                    if (List.size() == 0 || List.get(List.size() - 1) != '[') {
                        return false;
                    } else {
                        List.remove(List.size() - 1);
                        break;
                    }
                case '}':
                    if (List.size() == 0 || List.get(List.size() - 1) != '{') {
                        return false;
                    } else {
                        List.remove(List.size() - 1);
                        break;
                    }
            }
        }
        if(List.size()!=0)
        {
            return false;
        }
        return true;
    }
}
// @lc code=end

