/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        int zero = 0;
        for (int i = l-1; i >=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] r = new int[l+1];
        r[0] = 1;
        return r;
    }
}
// @lc code=end

