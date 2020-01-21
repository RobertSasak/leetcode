/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {

    public int lengthOfLastWord(String s) {
        boolean hasWord = false;
        int l = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (hasWord) {
                    return l;
                } 
            } else {
                l++;
                hasWord = true;
            }
        }
        return l;
    }

    public int lengthOfLastWord2(String s) {
        int max = 0;
        boolean space = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                space = true;
            } else if (space) {
                max = 1;
                space = false;
            } else {
                max++;
                space = false;
            }
        }
        return max;    
    }
}
// @lc code=end

