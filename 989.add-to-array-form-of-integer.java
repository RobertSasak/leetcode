/*
 * @lc app=leetcode id=989 lang=java
 *
 * [989] Add to Array-Form of Integer
 */

// @lc code=start
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            K += A[i];
            result.addFirst(K % 10);
            K /= 10;
        }
        while (K != 0) {
            result.addFirst(K % 10);
            K /= 10;
        }
        return result;
    }
}
// @lc code=end

