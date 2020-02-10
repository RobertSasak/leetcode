/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap <Character, Integer> h = new HashMap();
        for (char c : s1.toCharArray()) {
            int f = h.getOrDefault(c, 0) + 1;
            h.put(c, f);
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            update(h, c, -1);
            if (i >= s1.length()) {
                c = s2.charAt(i - s1.length());
                update(h, c, 1);
            }
            if (h.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    void update(HashMap<Character, Integer> h, char c, int delta) {
        int f = h.getOrDefault(c, 0) + delta;
        if (f == 0) {
            h.remove(c);
        } else {
            h.put(c, f);
        }
    }
}
// @lc code=end

