/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int r = 0;
        int i = 0;
        while (i <= r) {
            r = Math.max(r, i + nums[i]);
            if (r >= nums.length - 1) {
                return true;
            }
            i++;
        }
        return false;
    }
}
// @lc code=end

