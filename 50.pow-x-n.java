/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        return myPowRecursive(x, n);
        // return myPowIterative(x, n);
    }

    public double myPowRecursive(double x, long n) {
        if (x == 1) {
            return 1;
        }
        if (x == 0.0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            return 1 / myPowRecursive(x, -n);
        }
        if (x == 0.0 && n < 0) {
            // throw error
        }
        double r = myPowRecursive(x, n / 2);
        r *= r;
        if (n % 2 == 1) {
            r *= x;
        }
        return r;
    }


    public double myPowIterative(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (x == 0.0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double r = x;
        int m = Math.abs(n);
        while (m > 1) {
            m--;
            r *= x;
        }
        if (n < 0) {
            return 1/r;
        }
        return r;
    }
}
// @lc code=end

