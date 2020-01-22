/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    
    public List<String> generateParenthesis(int n) {
        // With Strings
        // return generateParenthesisString(n);
        // With String Builder
        return generateParenthesisSB(n);
    }

    // With String Builder
    public List<String> generateParenthesisSB(int n) {
        List<String> l = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();

        // Start with all closing brackets 
        for (int i = 0; i < n * 2; i++) {
            sb.append(')');
        }

        generateParenthesisSB(l, sb, 0, n);

        return l;
    }

    public void generateParenthesisSB(List<String> l, StringBuilder sb, int index, int n) {
        if (n == 0) {
            l.add(sb.toString());
            return;
        }

        int len = sb.length();
        int open = len / 2 - n;
        for (int i = index; i <= open * 2; i++) {
            sb.setCharAt(i, '(');
            generateParenthesisSB(l, sb, i + 1, n - 1);
            sb.setCharAt(i, ')');
        }
    }


    // With Strings

    public List<String> generateParenthesisString(int n) {
        List<String> l = new LinkedList<String>();

        generateParenthesisString(l, "", n, n);
        return l;
    }

    public void generateParenthesisString(List<String> l, String prefix, int open, int close) {
        if (open + close == 0) {
            l.add(prefix);
        }
        if (open > 0) {
            generateParenthesisString(l, prefix + "(", open - 1, close);
        } 
        if (close > open) {
            generateParenthesisString(l, prefix + ")", open, close - 1);
        }
    }
}
// @lc code=end

