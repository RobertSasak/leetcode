/*
 * @lc app=leetcode id=908 lang=java
 *
 * [908] Smallest Range I
 */

// @lc code=start
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        return Math.max(
            max - min - 2 * K,
            0
        );
    }
}
// @lc code=end

