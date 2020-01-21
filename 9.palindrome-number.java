/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x % 10 == 0 && x > 0) {
            return false;
        }
        int y = 0;
        while (x > y) {    
            y *= 10;
            y += x % 10;
            x /= 10;  
        }
        if (x == y || x == y / 10) {
                return true;
        }
        return false;
    }

    // public boolean isPalindromeString(int x) {
    //     String s = String.valueOf(x);
    //     int l = s.length();
    //     for (int i = 0; i <= l / 2; i++) {
    //         if (s.charAt(i) != s.charAt(l - i - 1)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
// @lc code=end

