/*
 * @lc app=leetcode id=1232 lang=java
 *
 * [1232] Check If It Is a Straight Line
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 2; i < coordinates.length; i++) {
            if (!onLine(coordinates[0], coordinates[1], coordinates[i])) {
                return false;
            }
        }
        return true;
    }

    boolean onLine(int[] a, int[] b, int[] c) {
        return (a[0] - b[0]) * (a[1] - c[1]) == (a[0] - c[0]) * (a[1] - b[1]);
    }
}
// @lc code=end

