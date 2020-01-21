/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            h.put(c, h.getOrDefault(c, 0) + 1);
        }

        int sum = 0;
        int  middle = 0;
        for (Map.Entry e : h.entrySet()) {
            int count = (int)e.getValue();
            sum += (count / 2) * 2;
            if (count % 2 == 1) {
                middle = 1;
            }
        }
        return sum + middle;
    }
}
// @lc code=end

