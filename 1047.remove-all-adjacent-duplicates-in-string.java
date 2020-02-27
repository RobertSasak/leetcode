/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String S) {
        LinkedList<Character> l = new LinkedList<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!l.isEmpty() && l.getLast() == c) {
                l.removeLast();
            } else {
                l.add(c);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (char c : l) {
            sb.append(c);
        }
        return sb.toString();
    }
}
// @lc code=end

