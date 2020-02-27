/*
 * @lc app=leetcode id=896 lang=java
 *
 * [896] Monotonic Array
 */

// @lc code=start
class Solution {

    public boolean isMonotonic(int[] a) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) {
                increasing = false;
            } else if (a[i - 1] > a[i]) {
                decreasing = false;
            }
            if (!increasing && !decreasing) {
                return false;
            }
        }
        return true;
    }


    public boolean isMonotonic2(int[] a) {
        if (a.length < 3) {
            return true;
        }
        return increasing(a) || decresing(a);
    }

    boolean increasing(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                return false;
            }
        }
        return true;
    }

    boolean decresing(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

