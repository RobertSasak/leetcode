/*
 * @lc app=leetcode id=1051 lang=java
 *
 * [1051] Height Checker
 */

// @lc code=start
class Solution {
    public int heightChecker(int[] heights) {
        int[] freq = new int[101];
        for (int h : heights) {
            freq[h]++;
        }
        int move = 0;
        int current = 0;

        for (int i = 0; i < heights.length; i++) {
            while (freq[current] == 0) {
                current++;
            }
            freq[current]--;
            if (heights[i] != current) {
                move++;
            }
        }
        return move;
    }
}
// @lc code=end

