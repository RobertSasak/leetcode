/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int u = n;
        while (l <= u) {
            int m = l + (u - l) / 2;
            if (isBadVersion(m)) {
                u = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
// @lc code=end

