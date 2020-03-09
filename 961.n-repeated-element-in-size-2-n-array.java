/*
 * @lc app=leetcode id=961 lang=java
 *
 * [961] N-Repeated Element in Size 2N Array
 */

// @lc code=start
class Solution {
    public int repeatedNTimes(int[] A) {
        for (int i = 2; i < A.length; i++) {
            if (A[i - 2] == A[i - 1])   return A[i - 1];
            if (A[i - 2] == A[i])       return A[i];
            if (A[i - 1] == A[i])       return A[i];
        }
        if (A.length == 4 && A[0] == A[3]) return A[0];
        return -1;
    }
}
// @lc code=end

