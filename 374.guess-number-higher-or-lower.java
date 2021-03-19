/*
 * @lc app=leetcode id=374 lang=java
 *
 * [374] Guess Number Higher or Lower
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long sp=1;
        long ep=n;
        long mid = (sp+ep)/2;
        while(ep-sp>1){
            if(guess((int)mid)==0){
                return (int)mid;
            }
            if(guess((int)mid)==1){
                sp=mid;
                mid=(sp+ep)/2;
                continue;
            }
            ep=mid;
            mid=(sp+ep)/2;
        }
        if(guess((int)sp)==0){
            return (int)sp;
        }
        return (int)ep;
    }
}
// @lc code=end

