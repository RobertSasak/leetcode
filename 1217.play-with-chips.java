/*
 * @lc app=leetcode id=1217 lang=java
 *
 * [1217] Play with Chips
 */

// @lc code=start
class Solution {
    public int minCostToMoveChips(int[] chips) {
        int e = 0;
        for (int c : chips) {
            if (c % 2 == 0) {
                e++;
            }
        }    
        return Math.min(e, chips.length - e);
    }
}
// @lc code=end

