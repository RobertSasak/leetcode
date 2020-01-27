/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        return spiralOrderLoops(matrix);
        // return spiralOrderWalk(matrix);
    }

    List<Integer> spiralOrderLoops(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();
        int rows = matrix.length;
        if (rows == 0) {
            return result;
        }
        int cols = matrix[0].length;
        int c1 = 0;
        int c2 = cols - 1;
        int r1 = 0;
        int r2 = rows - 1;
        while (r1 <= r2 && c1 <= c2) {
            // if (r1 == r2 && c1 == c2) {
            //     result.add(matrix[r1][c1]);
            //     break;
            // }
            for (int i = c1; i <= c2; i++)
                result.add(matrix[r1][i]);
            
            for (int i = r1 + 1; i <= r2; i++)
                result.add(matrix[i][c2]);
            
            if (r1 < r2 && c1 < c2) {
                for (int i = c2 - 1; i >= c1 + 1; i--)
                    result.add(matrix[r2][i]);
                
                for (int i = r2; i >= r1 + 1; i--)
                    result.add(matrix[i][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }
    



    boolean isInside(int r, int c, int rows, int cols) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }
    
    // 1 2 3
    // 4 5 6
    // 7 8 9
    List<Integer> spiralOrderWalk(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();
        int rows = matrix.length;
        if (rows == 0) {
            return result;
        }
        int cols = matrix[0].length;
        int[] dc = new int[] { 1, 0, -1,  0 };
        int[] dr = new int[] { 0, 1,  0, -1 };
        boolean[][] visited = new boolean[rows][cols];
        int dir = 0;
        int r = 0;
        int c = 0;
        while (isInside(r, c, rows, cols) && !visited[r][c]) {
            visited[r][c] = true;
            result.add(matrix[r][c]);
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (isInside(nr, nc, rows, cols) && !visited[nr][nc]) {
                r = nr;
                c = nc;
            } else {
                dir = (dir + 1) % 4;
                r += dr[dir];
                c += dc[dir];
            }
        }
        return result;
    }
        
}
// @lc code=end

