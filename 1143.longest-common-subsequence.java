/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String a, String b) {
        Integer[][] dp = new Integer[a.length()][b.length()];
        
        return longestCommonSubsequence(a, b, 0, 0, dp);
    }
    
    public int longestCommonSubsequence(String a, String b, int i, int j, Integer[][] dp) {
        if (i == a.length() || j == b.length()) {
            return 0;
        }
        if (dp[i][j] != null) return dp[i][j];
        
        if (a.charAt(i) == b.charAt(j)) {
            return longestCommonSubsequence(a, b, i + 1, j + 1, dp) + 1;
        }
        dp[i][j] = Math.max(
            longestCommonSubsequence(a, b, i + 1, j, dp),
            longestCommonSubsequence(a, b, i, j + 1, dp)
        );
        return dp[i][j];
    }
}
// @lc code=end

