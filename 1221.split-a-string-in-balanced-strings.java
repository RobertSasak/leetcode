/*
 * @lc app=leetcode id=1221 lang=java
 *
 * [1221] Split a String in Balanced Strings
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        int l = 0;
        int r = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                l++;
            } else if (c == 'R') {
                r++;
            }
            if (l == r) {
                l = 0;
                r = 0;
                sum++;
            }
        }
        return sum;
    }
}
// @lc code=end

