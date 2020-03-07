/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isLetter(char c) {
         return c <= 'z' && c >= 'a';
    }
    // i
    // aa
    // j
    // a*
    // sl = 2 - 0 = 2
    // pl = 2
    // s1 = a
    // p1 = a
    // p2 = *
    private boolean isMatch(String s, String p, int i, int j) {
        int sl = s.length() - i;
        int pl = p.length() - j;
        if (pl == 0) {
            return sl == 0;
        }
        char s1 = p.charAt(i);
        char p1 = p.charAt(j);

        if (pl == 1) {
            return sl == 1 && s1 == p1;
        }
        char p2 = p.charAt(j + 1);
        if (isLetter(p2)) {
            return p1 == s1 && isMatch(s, p, i + 1, j + 1);
        }
        if (p2 == '*') {
            if (p1 == s1) {
                return 
                    isMatch(s, p, i, j + 2) ||
                    isMatch(s, p, i + 1, j) || 
                    isMatch(s, p, i + 1, j + 2);
            }
            return isMatch(s, p, i, j + 2);
        }
        // p2 == +
        if (p1 != s1) {
            return false;
        }
        return  
            isMatch(s, p, i + 1, j) || 
            isMatch(s, p, i + 1, j + 2);
    }
}
// @lc code=end

