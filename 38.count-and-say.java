/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        return say(s);
    }

    public String countAndSay2(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = say(s);    
        }
        return s;
    }

    public String say(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int c = 1;
        char p = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char si = s.charAt(i);
            if (p == si) {
                c++;
            } else {
                sb.append(c);
                sb.append(p);
                c = 1;
                p = si;
            }
        }
        sb.append(c);
        sb.append(p);
        return sb.toString();
    }
}
// @lc code=end

