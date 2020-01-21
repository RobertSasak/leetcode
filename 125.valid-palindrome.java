/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = s.length();
        int i = 0;
        int j = l - 1;
        while (i <= j) {
            while (
                !Character.isLetterOrDigit(s.charAt(i)) && 
                i < l - 1
            ) {
                i++;
            }
            while (
                !Character.isLetterOrDigit(s.charAt(j)) && 
                j > 0
            ) {
                j--;
            } 
            if (i <= j && s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
// @lc code=end

