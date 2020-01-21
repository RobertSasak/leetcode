/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {

    private int parse(char c) {
        return c == '1' ? 1 : 0;
    }

    public String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();
        if (al < bl) {
            return addBinary(b, a);
        }
        int i = al - 1;
        int j = bl - 1;
        int c = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            int s = parse(a.charAt(i)) + c; 
            if (j >= 0) {
                s += parse(b.charAt(j));
            }
            c = s / 2;
            sb.append((s % 2 == 1) ? '1': '0');
            i--;
            j--;
        }
        if (c > 0) {
            sb.append('1');
        }
        sb.reverse();
        return sb.toString();
    }
}
// @lc code=end

