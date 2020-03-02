/*
 * @lc app=leetcode id=1260 lang=java
 *
 * [1260] Shift 2D Grid
 */

// @lc code=start
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r = grid.length;
        if (r == 0) {
            return null;
        }
        int c = grid[0].length;
        k = k % (r * c);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            List<Integer> row = new LinkedList<Integer>();
            result.add(row);
            for (int j = 0; j < c; j++) {
                int index = (i * c + j + r * c - k) % (r * c);
                row.add(grid[index / c][index % c]);
            }
        }
        return result;
    }
}
// @lc code=end

