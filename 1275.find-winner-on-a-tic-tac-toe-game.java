/*
 * @lc app=leetcode id=1275 lang=java
 *
 * [1275] Find Winner on a Tic Tac Toe Game
 */

// @lc code=start
class Solution {
    public String tictactoe(int[][] moves) {
        int[][] grid = new int[3][3];
        int A = 1; 
        for (int[] m : moves){
            grid[m[0]][m[1]] = A;
            A = A == 1 ? 2 : 1;
        }

        boolean pending = false;
        int[] startX = new int[] {0, 1, 2, 0, 0, 0, 0, 0};
        int[] startY = new int[] {0, 0, 0, 0, 1, 2, 0, 2};
        int[] dx = new int[] {0, 0, 0, 1, 1, 1, 1,  1};
        int[] dy = new int[] {1, 1, 1, 0, 0, 0, 1, -1};
        for (int i = 0; i < dx.length; i++) {
            boolean first = true;
            boolean second = true;
            for (int j = 0; j < 3; j++) {
                int x = startX[i] + dx[i] * j;
                int y = startY[i] + dy[i] * j;
                if (grid[x][y] ==0) {
                    pending = true;
                    first = false;
                    second = false;
                    break;
                } else if (grid[x][y] == 1) {
                    second = false;
                } else {
                    first = false;
                }
            }
            if (first) {
                return "A";
            }
            if (second) {
                return "B";
            }
        }
        if (pending) {
            return "Pending";
        }
        return "Draw";
    }
}
// @lc code=end

