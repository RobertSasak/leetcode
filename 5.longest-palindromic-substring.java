/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {

    // ""
    // a
    public String longestPalindrome(String s) {
        int l = s.length();
        int start = 0;
        int end = -1;
        int max = 0;
        for (int i = 0; i < l; i++) {
            int j = i;
            int k = i;
            while (j >= 0 && k < l && s.charAt(j) == s.charAt(k)) {
                int d = k - j + 1;
                if (max < d) {
                    max = d;
                    start = j;
                    end = k;
                }
                j--;
                k++;
            }
            j = i - 1;
            k = j + 1;
            while (j >= 0 && k < l && s.charAt(j) == s.charAt(k)) {
                int d = k - j + 1;
                if (max < d) {
                    max = d;
                    start = j;
                    end = k;
                }
                j--;
                k++;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private boolean isPalindrom(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        int l = s.length();
        int max = 0;
        int start = 0;
        int end = -1;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                if (isPalindrom(s, i, j)) {
                    int d =  j - i + 1;
                    if (d > max) {
                        max = d;
                        start = i;
                        end = j;   
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
// @lc code=end

