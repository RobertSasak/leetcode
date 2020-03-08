/*
 * @lc app=leetcode id=1071 lang=java
 *
 * [1071] Greatest Common Divisor of Strings
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return str1;
        }
        if (str1.length() == str2.length()) {
            return "";
        }
        if (str1.length() > str2.length()) {
            return gcdOfStrings(str2, str1);
        }
        String sub = str2.substring(str1.length());
        return gcdOfStrings(str1, sub);
    }
}
// @lc code=end

