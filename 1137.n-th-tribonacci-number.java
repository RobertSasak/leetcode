/*
 * @lc app=leetcode id=1137 lang=java
 *
 * [1137] N-th Tribonacci Number
 */

// @lc code=start
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int a = 0;
        int b = 1; 
        int c = 1;
        for (int i = 3; i <= n; i++) {
            int t = a + b + c;
            a = b;
            b = c;
            c = t;
        }
        return c;
    }
}
// @lc code=end

