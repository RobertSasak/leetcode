/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for (int n : nums) {
            sum += n; 
        }
        if (sum % 2 == 1) return false;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = sum; i >=0; i--) {
                if (dp[i]) {
                    dp[i + n] = true;
                }
            }
        }
        return dp[sum / 2] == true;
    }
}
// @lc code=end

