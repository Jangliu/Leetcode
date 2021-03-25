import org.graalvm.compiler.core.common.alloc.Trace;

/*
 * @lc app=leetcode id=520 lang=java
 *
 * [520] Detect Capital
 */

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.charAt(0)>=65 && word.charAt(0) <= 90){
            if(word.length()==1){
                return true;
            }
            if(word.charAt(1)>=65 && word.charAt(1) <= 90){
                for(int i=2;i<word.length();i++){
                    if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                        continue;
                    }
                    return false;
                }
                return true;
            }
            if(word.charAt(1)>=97 && word.charAt(1) <= 122){
                for (int i = 2; i < word.length(); i++) {
                    if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
                        continue;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        if (word.charAt(0) >= 97 && word.charAt(0) <= 122) {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) >= 97 && word.charAt(i) <= 122) {
                    continue;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
// @lc code=end

