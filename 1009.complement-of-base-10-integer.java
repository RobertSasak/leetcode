/*
 * @lc app=leetcode id=1009 lang=java
 *
 * [1009] Complement of Base 10 Integer
 */

// @lc code=start
class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        } 
        int r = 0;
        int b = 1;
        while (N != 0) {
            r += (N % 2 == 0 ? 1 : 0) * b;
            N = N >> 1;
            b *= 2;
        }
        return r;
    }
}
// @lc code=end

