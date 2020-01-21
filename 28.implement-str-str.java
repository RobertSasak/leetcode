/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    /*
    H ''
    N hello => -1

    H very long text
    N ''
    
       i
    H HelloWorld
        j
    N ellb
    */
    public int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        if (hl == 0 && nl == 0) {
            return 0;
        }
        for (int i = 0; i < hl; i++) {
            if (i + nl > hl) {
                break;
            }
            boolean found = true;
            for (int j = 0; j < nl; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

