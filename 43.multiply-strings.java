/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start
class Solution {
    public String multiply(String a, String b) {
        int[] res = new int[a.length() + b.length()];
        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {
                int m = (a.charAt(i) - '0') * (b.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int s = m + res[p2];
                res[p1] += s / 10;
                res[p2] = s % 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int d : res) {
            if (sb.length() > 0 || d != 0) {
                sb.append(d);
            }
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }


    public String multiplyComplicated(String a, String b) {
        if (a.length() > b.length()) {
            return multiply(b, a);
        }
        a = reverse(a);
        b = reverse(b);
        String s= "0";
        for (int i = 0; i < a.length(); i++) {
            int d = digit(a, i); // 3
            String m = multiply(b, d); //  654,3
            s = sum(s, m);
            if (!b.equals("0")) b =  "0" + b;
        }
        return reverse(s);
    }

    String sum(String a, String b) {
        if (a.length() < b.length()) {
            return sum(b, a);
        }
        StringBuffer sb = new StringBuffer();
        int r = 0;
        for (int i = 0; i < a.length(); i++) {
            int ai = digit(a, i);
            int bi = digit(b, i);
            int s = ai + bi + r;
            sb.append(s % 10);
            r = s / 10;
        }
        if (r > 0) {
            sb.append(r);
        }
        return sb.toString();
    }

    String multiply(String a, int d) {
        if (d == 0) {
            return "0";
        }
        if (d == 1) {
            return a;
        }
        StringBuffer sb = new StringBuffer();
        int r = 0;
        for (int i = 0; i < a.length(); i++) {
            int ai = digit(a, i);
            int s = ai * d + r;
            sb.append(s % 10);
            r = s / 10;
        }
        while (r > 0) {
            sb.append(r % 10);
            r /= 10;
        }
        return sb.toString();
    }

    int digit(String s, int i) {
        if (i < s.length()) {
            return s.charAt(i) - '0';
        }
        return 0;
    }

    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
// @lc code=end

