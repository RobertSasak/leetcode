/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {

    private char opposite(char c) {
        switch (c) {
            case '{':
                return '}';
            case '[':
                return ']';
            case '(':
                return ')';
        }
        throw new IllegalArgumentException("Invalid input");
    }

    public boolean isValid(String s) {
        Stack<Character> q = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                q.push(c);
            } else {
                if (q.isEmpty()) {
                    return false;
                }
                char l = q.pop(); 
                if (c != opposite(l)) {
                    return false;
                }
            }
        }
        return q.isEmpty();
    }
}
// '' => true
// '{' => false
// '{}' => true
// '{[]}' => true
// '{[}]'

// {[}]
// @lc code=end

