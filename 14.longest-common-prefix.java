/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char c = 'x';
        while (true) {
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return sb.toString();
                }
                if (j == 0) {
                    c = strs[0].charAt(i);
                } else if (c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
            i++;
        }
    }
}
// @lc code=end

