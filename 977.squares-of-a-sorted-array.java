/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] r = new int[A.length];
        int i = 0; 
        int j = A.length - 1;
        int k = A.length - 1;
        while (i <= j){
            int left = A[i] * A[i];
            int right = A[j] * A[j];
            if (left <= right) {
                r[k] = right;
                j--;
            } else {
                r[k] = left;
                i++;
            }
            k--;
        }
        return r;
    }
}
// @lc code=end

