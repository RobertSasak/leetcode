/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        s = strip(s);
        List<String> result = new LinkedList<String>();        
        HashSet<String> h = new HashSet();
        
        h.add(s);
        while (!h.isEmpty()) {
            for (String a : h) {
                // System.out.println(a);
                if (isValid(a)) {
                    result.add(a);
                }
            }
            if (!result.isEmpty()) {
                return result;
            }
            h = criple(h);
        }
        
        return result;
    }
    
    HashSet<String> criple(HashSet<String> input) {
        HashSet<String> h = new HashSet();
        for (String s : input) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                    h.add(new StringBuilder(s).deleteCharAt(i).toString());
                }
            }
        }
        return h;
    }
    
    boolean isValid(String text) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '(') {
                s.add(c);
            } else if (c == ')') {
                if (s.isEmpty()) {
                    return false;
                } else {
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }
    
    String strip(String text) {
        StringBuffer sb = new StringBuffer();
        int s = 0;
        while (s < text.length()) {
            char c = text.charAt(s);
            if (c == '(') 
                break;
            else if (c != ')')
                sb.append(c);
            s++;
        }
        int e = text.length() - 1;
        while (e >= 0) {
            char c = text.charAt(e);
            if (c == ')')
                break;
            e--;
        }
        while (s<=e) {
            sb.append(text.charAt(s));
            s++;
        }
        while (s < text.length()) {
            char c = text.charAt(s);
            if (c != '(')
                sb.append(c);
            s++;
        }
        return sb.toString();
    }
}
// @lc code=end

