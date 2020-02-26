/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> q = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j});
                }
            }
        }
        int[] dx = new int[] { 1, -1,  0, 0};
        int[] dy = new int[] { 0,  0, -1, 1};
        int minutes = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            while (n > 0) {
                int[] a = q.removeFirst();
                for (int i = 0; i < 4; i++) {
                    int x = a[0] + dx[i];
                    int y = a[1] + dy[i];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        int[] b = new int[2];
                        b[0] = x;
                        b[1] = y;
                        grid[x][y] = 2;
                        q.add(b);
                    }
                }
                n--;
            }
            if (!q.isEmpty()) {
                minutes++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minutes;
    }
}
// @lc code=end

