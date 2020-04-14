/*
 * @lc app=leetcode id=773 lang=java
 *
 * [773] Sliding Puzzle
 */

// @lc code=start
class Solution {
    HashMap<String, Integer> h = new HashMap<>();;
    int min = Integer.MAX_VALUE;
    public int slidingPuzzle(int[][] board) {
        helper(board, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    void helper(int[][] board, int depth) {
        if (depth >= min) {
            return;
        }
        if (
            board[0][0] == 1 && 
            board[0][1] == 2 && 
            board[0][2] == 3 && 
            board[1][0] == 4 && 
            board[1][1] == 5 && 
            board[1][2] == 0 
        ) {
            min = depth;
            return;
        }
        String key = "" + board[0][0] + board[0][1] + board[0][2]
                        + board[1][0] + board[1][1] + board[1][2];
        if (h.containsKey(key) && h.get(key) <= depth)
            return;
        h.put(key, depth);
        int x = -5;
        int y = -5;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    x = j;
                    y = i;
                }
            }
        }
        if (x == -5) 
            System.out.println("asdadadasdadas");
        
        if (x > 0) {
            helper(swap(copy(board), x, y, x - 1, y), depth + 1);
        }
        if (x < 2) {
            helper(swap(copy(board), x, y, x + 1, y), depth + 1);
        }
        if (y > 0) {
            helper(swap(copy(board),  x, y, x, y - 1), depth + 1);
        }
        if (y < 1) {
            helper(swap(copy(board),  x, y, x, y + 1), depth + 1);
        }
    }
    
    int[][] swap(int[][] board, int x, int y, int xx, int yy) {
        int t = board[y][x];
        board[y][x] = board[yy][xx];
        board[yy][xx] = t;
        return board;
    }
    
    void print(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    boolean equal(int[][] board1, int[][] board2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board1[i][j] != board2[i][j])
                    return false;
            }
        }
        return true;
    }
    
    int[][] copy(int[][] board) {
        int[][] copy = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
}
// @lc code=end

