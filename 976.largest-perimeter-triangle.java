/*
 * @lc app=leetcode id=976 lang=java
 *
 * [976] Largest Perimeter Triangle
 */

// @lc code=start
class Solution {
    public int largestPerimeter(int[] A) {
        int max = 0;
        Arrays.sort(A);
        for (int i = 2; i < A.length; i++) {
            int a = A[i - 2];
            int b = A[i - 1];
            int c = A[i];
            if (a + b > c) {
                max = Math.max(max, a + b + c);
            }
        }
        return max;
    }
}
// @lc code=end

