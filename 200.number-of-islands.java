/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        if (r == 0) return 0;
        int c = grid[0].length;
        
        int[] movex = new int[] { -1, 1,  0, 0 };
        int[] movey = new int[] {  0, 0, -1, 1 };
        
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] { i, j });
                    while (!q.isEmpty()) {
                        int[] n = q.poll();
                        for (int k = 0; k < movex.length; k++) {
                            int rr = n[0] + movey[k];
                            int cc = n[1] + movex[k];
                            if (rr >= 0 && rr < r && cc >= 0 && cc < c 
                                && grid[rr][cc] == '1'
                            ) {
                                grid[rr][cc] = '0';
                                q.add(new int[] { rr, cc });
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
// @lc code=end

