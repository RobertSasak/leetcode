/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int r = 0;
        while (x != 0) {
            int c = x % 10;
            if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && c > 7)) {
                return 0;
            }
            if (r < Integer.MIN_VALUE / 10 || (r == Integer.MIN_VALUE / 10 && c < -8)) {
                return 0;
            }
            r *= 10;
            r += c;
            x /= 10;
        }
        return r;
    }
}
// @lc code=end

