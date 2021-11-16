/*
 * @lc app=leetcode.cn id=478 lang=java
 *
 * [478] 在圆内随机生成点
 */

// @lc code=start
class Solution {
    private double radius;
    private double xCenter;
    private double yCenter;
    // 拒绝采样法
    public Solution(double radius, double xCenter, double yCenter) {
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    Random random = new Random();

    public double[] randPoint() {
        // 每个圆都有一个外切正方形
        // 在正方形中随机生成点
        // 如果点落在园内就接受，否则拒绝，继续生成
        while (true) {
            double x = xCenter - radius + 2 * radius * random.nextDouble();
            double y = yCenter - radius + 2 * radius * random.nextDouble();
            if ((x - xCenter) * (x - xCenter) + (y - yCenter) * (y - yCenter) <= radius * radius) {
                return new double[] { x, y };
            }
        }
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
// @lc code=end

