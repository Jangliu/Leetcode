/*
 * @lc app=leetcode id=812 lang=java
 *
 * [812] Largest Triangle Area
 */

// @lc code=start
class Solution {
    public double largestTriangleArea(int[][] points) {
        int len = points.length;
        double area = 0;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    double a = Math
                            .sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                    double b = Math
                            .sqrt(Math.pow(points[i][0] - points[k][0], 2) + Math.pow(points[i][1] - points[k][1], 2));
                    double c = Math
                            .sqrt(Math.pow(points[j][0] - points[k][0], 2) + Math.pow(points[j][1] - points[k][1], 2));
                    double p = (a + b + c) / 2;
                    if (p - a <= 0 || p - b <= 0 || p - c <= 0) {
                        continue;
                    }
                    double tempArea = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                    area = Math.max(tempArea, area);
                }
            }
        }
        return area;
    }
}
// @lc code=end

