/*
 * @lc app=leetcode id=434 lang=java
 *
 * [434] Number of Segments in a String
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        int l = s.length();
        if (l == 0) {
            return 0;
        }
        boolean isWord = false;
        int words = 0;
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) != ' ') {
                isWord = true;
                words++;
            } else {
                isWord = false;
            }
        }
        if (isWord) {
            words++;
        }
        return words;
    }
}
// @lc code=end

