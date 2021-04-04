import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public boolean truth(int sr, int sc, int length2, int length1) {
        if (sr >= 0 && sr < length1 && sc >= 0 && sc < length2) {
            return true;
        }
        return false;
    }

    public int[][] fill(int[][] image, int n, int sr, int sc) {
        int s = image[sr][sc];
        image[sr][sc] = n;
        if (truth(sr, sc, image[0].length, image.length)) {
            if (truth(sr - 1, sc, image[0].length, image.length)) {
                if (image[sr - 1][sc] == s) {
                    fill(image, n, sr - 1, sc);
                }
            }
            if (truth(sr + 1, sc, image[0].length, image.length)) {
                if (image[sr + 1][sc] == s) {
                    fill(image, n, sr + 1, sc);
                }
            }
            if (truth(sr, sc - 1, image[0].length, image.length)) {
                if (image[sr][sc - 1] == s) {
                    fill(image, n, sr, sc - 1);
                }
            }
            if (truth(sr, sc + 1, image[0].length, image.length)) {
                if (image[sr][sc + 1] == s) {
                    fill(image, n, sr, sc + 1);
                }
            }
        }
        return image;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        return fill(image, newColor, sr, sc);
    }
}
// @lc code=end

