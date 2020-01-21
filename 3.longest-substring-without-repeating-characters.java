/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {

    // "" => 0
    // d => 1
    // abc => 3
    // aabc => 3

    // h: a0 b1
    // l: 2
    // max: 2
    // abacd

    // h: a0
    // l: 1
    // max: 2
    //   i
    // abba
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (h.containsKey(c)) {
                int j = h.get(c);
                l = Math.min(i - j - 1, l);
                h.remove(c);
            }
            l++;
            max = Math.max(max, l);
            h.put(c, i);
        }
        return max;
    }
}
// @lc code=end

