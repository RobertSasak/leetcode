/*
 * @lc app=leetcode id=1025 lang=java
 *
 * [1025] Divisor Game
 */

// @lc code=start
class Solution {
    public boolean divisorGame(int N) {
        // 0 false
        // 1 false
        // 2 true
        // 3 false
        // 4 true
        // 5 false
        return N % 2 == 0;
    }
}
// @lc code=end

