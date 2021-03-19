import java.util.HashMap;

/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length()<ransomNote.length()){
            return false;
        }
        if(ransomNote.length()==0){
            return true;
        }
        char[] c = new char[26];
        for(int i=0;i<magazine.length();i++){
            c[magazine.charAt(i)-97]++;
        }
        for(int i=0;i<ransomNote.length();i++){
            if(c[ransomNote.charAt(i)-97]==0){
                return false;
            }
            c[ransomNote.charAt(i)-97]--;
        }
        return true;
    }
}
// @lc code=end

