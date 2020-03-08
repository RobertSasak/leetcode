/*
 * @lc app=leetcode id=1030 lang=java
 *
 * [1030] Matrix Cells in Distance Order
 */

// @lc code=start
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] visited = new boolean[R][C];
        int[] dr = new int[]{ -1, 1,  0, 0};
        int[] dc = new int[]{  0, 0, -1, 1};
        LinkedList<int[]> q = new LinkedList<int[]>();
        
        q.add(new int[]{ r0, c0 });
        visited[r0][c0] = true;
        
        int[][] result = new int[R * C][2];
        int j = 0;
        while (!q.isEmpty()) {
            int[] p = q.removeFirst();
            result[j] = p;
            for (int i = 0; i < dr.length; i++) {
                int r = p[0] + dr[i];
                int c = p[1] + dc[i];
                if (c >=0 && c < C && r >= 0 && r < R) {
                    if (!visited[r][c]) {
                        q.add(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }
            }
            j++;
        }
        return result;
    }
}
// @lc code=end

