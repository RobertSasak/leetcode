/*
 * @lc app=leetcode id=999 lang=java
 *
 * [999] Available Captures for Rook
 */

// @lc code=start
class Solution {
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    return 
                        pawn(board, i, j,  1,  0) + 
                        pawn(board, i, j, -1,  0) + 
                        pawn(board, i, j,  0,  1) + 
                        pawn(board, i, j,  0, -1);
                }
            }
        }
        return 0;    
    }

    int pawn(char[][] board, int x, int y, int dx, int dy) {
        int rows = board.length;
        int cols = board[0].length;            
        while (true) {
            x += dx; 
            y += dy;
            if (x < 0 || y < 0 || x >= rows || y >= cols) {
                return 0;
            }
            if (board[x][y] == 'B') {
                return 0;
            }
            if (board[x][y] == 'p') {
                return 1;
            }
        }
    }
}
// @lc code=end

