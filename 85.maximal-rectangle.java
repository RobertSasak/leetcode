/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {

        int r = matrix.length;
        if (r == 0) {
            return 0;
        }

        int c = matrix[0].length;

        int[][] width = new int[r][c];
        
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                width[i][j] = j > 0 ? width[i][j - 1] + 1 : 1;
                int minWidth = width[i][j];
                for (int k = i; k >= 0; k--) {
                    minWidth = Math.min(minWidth, width[k][j]);
                    int area = minWidth * (i - k + 1);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }
}
// @lc code=end

