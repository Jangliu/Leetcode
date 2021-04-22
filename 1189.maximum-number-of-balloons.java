/*
 * @lc app=leetcode id=1189 lang=java
 *
 * [1189] Maximum Number of Balloons
 */

// @lc code=start
class Solution {
    public int maxNumberOfBalloons(String text) {
        int min = Integer.MAX_VALUE;
        int aNum = 0;
        int bNum = 0;
        int lNum = 0;
        int oNum = 0;
        int nNum = 0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)=='a'){
                aNum++;
            }
            if(text.charAt(i)=='b'){
                bNum++;
            }
            if(text.charAt(i)=='l'){
                lNum++;
            }
            if(text.charAt(i)=='o'){
                oNum++;
            }
            if(text.charAt(i)=='n'){
                nNum++;
            }
        }
        lNum=lNum/2;
        oNum=oNum/2;
        min = Math.min(aNum, min);
        min = Math.min(bNum, min);
        min = Math.min(lNum, min);
        min = Math.min(oNum, min);
        min = Math.min(nNum, min);
        return min;
    }
}
// @lc code=end

