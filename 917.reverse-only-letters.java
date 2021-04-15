/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] c = S.toCharArray();
        int i=0;
        int j=c.length-1;
        while(i<j){
            while(c[i]>=33&&c[i]<=64||c[i]>=91&&c[i]<=96&&i<c.length){
                i++;
                if (i == c.length) {
                    break;
                }
            }
            if (i == c.length) {
                break;
            }
            while(c[j]>=33&&c[j]<=64||c[j]>=91&&c[j]<=96&&j>=0){
                j--;
                if (j == -1) {
                    break;
                }
            }
            if(j==-1){
                break;
            }
            if(i>=j){
                break;
            }
            else{
                char temp = c[j];
                c[j]=c[i];
                c[i]=temp;
                i++;
                j--;
            }
        }
        return new String(c);
    }
}
// @lc code=end

