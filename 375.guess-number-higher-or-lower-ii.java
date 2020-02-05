/*
 * @lc app=leetcode id=375 lang=java
 *
 * [375] Guess Number Higher or Lower II
 */

// @lc code=start
class Solution {
    public int getMoneyAmount(int n) {
        int[][] m = new int[n + 1][n + 1];
        return get(m, 1, n);
    }

    int get(int[][] m, int s, int e) {
        if (s >= e) {
            return 0;
        }
        if (m[s][e] != 0) {
            return m[s][e];
        }
        int min = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            min = Math.min(min, Math.max(get(m, s, i - 1), get(m, i + 1, e)) + i);
        }
        m[s][e] = min;
        return min;
    }
}
// @lc code=end

