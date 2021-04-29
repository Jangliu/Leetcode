import java.util.ArrayList;

/*
 * @lc app=leetcode id=1417 lang=java
 *
 * [1417] Reformat The String
 */

// @lc code=start
class Solution {
    public String reformat(String s) {
        ArrayList<Character> c = new ArrayList<>();
        ArrayList<Character> n = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp>='a'&&temp<='z'){
                c.add(temp);
            }
            else{
                n.add(temp);
            }
        }
        if(Math.abs(c.size()-n.size())>1){
            return "";
        }
        StringBuffer result = new StringBuffer();
        int i=0;
        int j=0;
        while(i<c.size()&&j<n.size()){
            result.append(c.get(i));
            i++;
            result.append(n.get(j));
            j++;
        }
        if(c.size()>n.size()){
            result.append(c.get(i));
        }
        if(n.size()>c.size()){
            result.insert(0, n.get(j));
        }
        return result.toString();
    }
}
// @lc code=end

