/*
 * @lc app=leetcode id=764 lang=java
 *
 * [764] Largest Plus Sign
 */

// @lc code=start
class Solution {
    // O(N^2)
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        boolean[][] m = new boolean[N][N];
        for (int[] mine : mines) {
            m[mine[0]][mine[1]] = true;
        }
            
            
        int[][] a = new int[N][N];
        int[][] b = new int[N][N];
        int[][] c = new int[N][N];
        int[][] d = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!m[i][j]) {
                    a[i][j] = j > 0 ? a[i][j - 1] + 1 : 1;
                    c[i][j] = i > 0 ? c[i - 1][j] + 1 : 1;
                }
            }
            for (int j = N - 1; j >= 0; j--) {
                if (!m[i][j]) {
                    b[i][j] = j < N - 1 ? b[i][j + 1] + 1 : 1;
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (!m[i][j]) {
                    d[i][j] = i < N - 1 ? d[i + 1][j] + 1 : 1;
                }
            }
        }
        int max = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int min = Math.min(
                    Math.min(a[i][j], b[i][j]),
                    Math.min(c[i][j], d[i][j])   
                );
                max = Math.max(max, min);
            }
        }
        return max;    
    }
}
// @lc code=end

