/*
 * @lc app=leetcode id=1037 lang=java
 *
 * [1037] Valid Boomerang
 */

// @lc code=start
class Solution {
    public boolean isBoomerang(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] a = points[0];
        int[] b = points[1];
        int[] c = points[2];
        if (a[0] == b[0] && a[1] == b[1]) {
            return false;
        }
        if (a[0] == b[0]) {
            return b[0] != c[0];
        }
        return rate(a, b) != rate(a, c);
    }

    double rate(int[] a, int[] b) {
        return (double)(a[1] - b[1]) / (a[0] - b[0]);
    }
}
// @lc code=end

