/*
 * @lc app=leetcode id=985 lang=java
 *
 * [985] Sum of Even Numbers After Queries
 */

// @lc code=start
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int odd = 0;
        int even = 0;
        for (int a : A)
            if (a % 2 == 0) even += a;
            else            odd += a;

        int[] r = new int[queries.length];
        int j = 0;
        for (int[] q : queries) {
            int v = q[0];
            int i = q[1];
            if (v % 2 == 0) {
                if (A[i] % 2 == 0) {
                    even += v;
                } else {
                    odd += v;
                }
            } else {
                if (A[i] % 2 == 0) {
                    even -= A[i];
                    odd += A[i] + v;
                } else {
                    odd -= A[i];
                    even += A[i] + v;
                }
            } 
            A[i] += v;
            r[j] = even;
            j++;
        }
        return r;
    }
}
// @lc code=end

