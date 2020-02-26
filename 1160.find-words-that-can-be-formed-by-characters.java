/*
 * @lc app=leetcode id=1160 lang=java
 *
 * [1160] Find Words That Can Be Formed by Characters
 */

// @lc code=start
class Solution {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        int[] base = frequency(chars);
        for (String w : words) {
            int[] f = frequency(w);
            if (contain(f, base)) {
                sum += w.length();
            }
        }
        return sum;
    }

    int[] frequency(String word) {
        int[] f = new int[26];
        for (char c : word.toCharArray()) {
            f[c - 'a']++;
        }
        return f;
    }

    boolean contain(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

