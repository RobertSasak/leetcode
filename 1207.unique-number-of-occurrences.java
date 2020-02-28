/*
 * @lc app=leetcode id=1207 lang=java
 *
 * [1207] Unique Number of Occurrences
 */

// @lc code=start
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int n : arr) {
            h.put(n, h.getOrDefault(n, 0) + 1);
        }
        HashSet<Integer> s = new HashSet<>();
        for (int k : h.keySet()) {
            int f = h.get(k);
            if (s.contains(f)) {
                return false;
            }
            s.add(f);
        }
        return true;
    }
}
// @lc code=end

