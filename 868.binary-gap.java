/*
 * @lc app=leetcode id=868 lang=java
 *
 * [868] Binary Gap
 */

// @lc code=start
class Solution {
    public int binaryGap(int N) {
        int max = 0;
        int gap = -100;
        while (N != 0) {
            if (N % 2 == 1) {
                max = Math.max(max, gap);
                gap = 1;
            } else {
                gap++;
            }
            N /= 2;
        }
        return max;
    }
}
// @lc code=end

