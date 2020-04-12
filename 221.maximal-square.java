/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {

    // O(m*n) Space: O(n)
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        if (r == 0) return 0;
        int c = matrix[0].length;
    
        int[] dp = new int[c + 1];

        int max = 0;
        int prev = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                int t = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(
                        prev,
                        Math.min(
                            dp[j],
                            dp[j - 1]
                        )
                    ) + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = t;
            }
        }
        return max * max;
    }

    // O(m*n) Space: O(n^2)
    public int maximalSquare2(char[][] matrix) {
        int r = matrix.length;
        if (r == 0) return 0;
        int c = matrix[0].length;
    
        int[][] dp = new int[r + 1][c + 1];

        int max = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(
                        dp[i - 1][j - 1],
                        Math.min(
                            dp[i - 1][j],
                            dp[i][j-1]
                        )
                    ) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
// @lc code=end

