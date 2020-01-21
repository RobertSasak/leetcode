/*
 * @lc app=leetcode id=633 lang=java
 *
 * [633] Sum of Square Numbers
 */

// @lc code=start
class Solution {

    private boolean bs(long l, long r, long b) {
        if (l > r) {
            return false;
        }
        long m = (l + r) / 2;
        if (m * m == b) {
            return true;
        } else if (m * m > b) {
            return bs(l, m - 1, b);
        } else {
            return bs(m + 1, r, b);
        }
    }

    public boolean judgeSquareSum(int c) {
        for (long a = 0; a*a <= c; a++) {
            int b = c - (int)(a*a);
            if (bs(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a*a <= c; a++) {
            double b = Math.sqrt(c - a*a);
            if ((int)b == b) {
                return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSumSlow(int c) {
        for (long a = 0; a*a <= c; a++) {
            for (long b = 0; a*a + b*b <=c; b++) {
                if (a*a + b*b == c) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

