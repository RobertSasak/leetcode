/*
 * @lc app=leetcode id=888 lang=java
 *
 * [888] Fair Candy Swap
 */

// @lc code=start
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int as = 0; 
        int bs = 0;
        HashSet<Integer> h = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            as += A[i];
            h.add(A[i]);
        }
        for (int n : B) {
            bs += n;
        }
        int d = bs - as;
        for (int i = 0; i < B.length; i++) {
            int m = B[i] - d / 2;
            if (h.contains(m)) {
                int[] r = new int[] { m, B[i] };
                return r;
            }
        }
        return new int[] { -1, -1};
    }
}
// @lc code=end

