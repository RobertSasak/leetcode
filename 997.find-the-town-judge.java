/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {
    public int findJudge(int N, int[][] trust) {
        boolean[] isTrusting = new boolean[N + 1];
        int[] trustBy = new int[N + 1];
        for (int[] t : trust) {
            isTrusting[t[0]] = true;
            trustBy[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (!isTrusting[i] && trustBy[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

