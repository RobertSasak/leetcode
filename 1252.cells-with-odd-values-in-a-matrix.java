/*
 * @lc app=leetcode id=1252 lang=java
 *
 * [1252] Cells with Odd Values in a Matrix
 */

// @lc code=start
class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] a = new int[n][m];
        for (int[] indice : indices) {
            int ri = indice[0];
            int ci = indice[1];
            for (int i = 0; i < n; i++) {
                a[i][ci]++;
            }
            for (int i = 0; i < m; i++) {
                a[ri][i]++;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] % 2 == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
// @lc code=end

