import java.util.HashSet;

/*
 * @lc app=leetcode id=859 lang=java
 *
 * [859] Buddy Strings
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String a, String b) {
        if(a.length()!=b.length()){
            return false;
        }
        if(a.equals(b)){
            HashSet<Character> map = new HashSet<>();
            for(int i=0;i<a.length();i++){
                if(map.contains(a.charAt(i))){
                    return true;
                }
                map.add(a.charAt(i));
            }
        }
        int a1=-1;
        int a2=-1;
        int i=0;
        while(i<a.length()){
            if(a.charAt(i)!=b.charAt(i)){
                if(a1==-1){
                    a1=i;
                    i++;
                    continue;
                }
                if(a2==-1){
                    a2=i;
                    i++;
                    continue;
                }
                return false;
            }
            i++;
        }
        if(a2==-1){
            return false;
        }
        return a.charAt(a1)==b.charAt(a2)&&a.charAt(a2)==b.charAt(a1);
    }
}
// @lc code=end

