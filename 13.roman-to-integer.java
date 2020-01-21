/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {


    private int letter(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V': 
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C': 
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }

    public int romanToInt(String s) {
        int r = 0;
        int l = s.length();
        for (int i = 0; i < l; i++) {
            int first = letter(s.charAt(i));
            if (i + 1 < l && first < letter(s.charAt(i + 1))) {
                r += letter(s.charAt(i + 1)) - first;
                i++;
            } else {
                r += first;
            }
        }
        return r;   
    }
}
// @lc code=end

