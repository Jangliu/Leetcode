import java.util.Random;

/*
 * @lc app=leetcode.cn id=497 lang=java
 *
 * [497] 非重叠矩形中的随机点
 */

// @lc code=start
class Solution {

    int[][] rects;
    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();
    // 二分法查找，注意矩阵面积越大那么选到该矩阵的概率越大
    public Solution(int[][] rects) {
        this.rects = rects;
        for (int[] x : rects) {
            tot += (x[2] - x[0] + 1) * (x[3] - x[1] + 1);
            psum.add(tot);
        }
    }

    public int[] pick() {
        int targ = rand.nextInt(tot);

        int lo = 0;
        int hi = rects.length - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) lo = mid + 1;
            else hi = mid;
        }

        int[] x = rects[lo];
        int width = x[2] - x[0] + 1;
        int height = x[3] - x[1] + 1;
        int base = psum.get(lo) - width * height;
        return new int[]{x[0] + (targ - base) % width, x[1] + (targ - base) / width};
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
// @lc code=end

