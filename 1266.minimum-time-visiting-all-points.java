/*
 * @lc app=leetcode id=1266 lang=java
 *
 * [1266] Minimum Time Visiting All Points
 */

// @lc code=start
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < points.length; i++) {
            sum += time(points[i - 1], points[i]);
        }
        return sum;
    }

    int time(int[] a, int[] b) {
        int x = Math.abs(a[0] - b[0]);
        int y = Math.abs(a[1] - b[1]);
        return Math.max(x, y);
    }
}
// @lc code=end

