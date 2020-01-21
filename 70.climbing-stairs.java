/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public int climbStairsDP(int n) {
        int[] m = new int[n + 1];
        m[0] = 1;
        m[1] = 1;
        for (int i = 2; i <= n; i++) {
            m[i] = m[i - 1] + m[i - 2];
        }
        return m[n];
    }

    public int climbStairsRecursive(int n) {
        int[] m = new int[n + 1];
        return climb(n, m);
    }

    public int climb(int n, int[] m) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1; 
        }
        if (m[n] > 0) {
            return m[n];
        }
        m[n] = climb(n - 1, m) + climb(n - 2, m);
        return m[n];
    }
}
// @lc code=end

