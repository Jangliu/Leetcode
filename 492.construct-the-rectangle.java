import javax.swing.text.DefaultStyledDocument.ElementSpec;

/*
 * @lc app=leetcode id=492 lang=java
 *
 * [492] Construct the Rectangle
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        int sqr = (int)Math.sqrt(area);
        int[] method1 = new int[2];
        int[] method2 = new int[2];
        for(int i=sqr;i>=0;i--){
            if(area%i==0){
                method1[0]=Math.max(i, area/i);
                method1[1]=Math.min(i, area/i);
                break;
            }
        }
        for(int i=sqr+1;i<area;i++){
            if(area%i==0){
                method2[0] = Math.max(i, area / i);
                method2[1] = Math.min(i, area / i);
                break;
            }
        }
        if(method1[0]==0){
            return method2;
        }
        if(method2[0]==0){
            return method1;
        }
        if(method1[0]-method1[1]>=method2[0]-method2[1]){
            return method2;
        }
        else{
            return method1;
        }
    }
}
// @lc code=end

