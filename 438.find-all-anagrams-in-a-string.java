/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int l = p.length();
        int[] fp = freq(p);
        int[] fs = new int[26];
        
        List<Integer> result = new LinkedList<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            fs[c - 'a']++;
            if (i - l >= 0) {
                fs[s.charAt(i - l) - 'a']--;
            }
            if (equal(fp, fs)) {
                result.add(i - l + 1);
            }
        }
        return result;
    }
    
    int[] freq(String a) {
        int[] f = new int[26];
        for (char c : a.toCharArray()) {
            f[c - 'a']++;
        }
        return f;
    }
    
    boolean equal(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}
// @lc code=end

