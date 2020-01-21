/*
 * @lc app=leetcode id=728 lang=java
 *
 * [728] Self Dividing Numbers
 */

// @lc code=start
class Solution {
    private boolean isSelfDividing(int n) {
        int p = n;
        while (p > 1) {
            int d = p % 10;
            if (d == 0) {
                return false;
            }
            p /= 10;
            if (n % d != 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> l = new LinkedList<Integer>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                l.add(i);
            }
        }
        return l;
    }
}
// @lc code=end

