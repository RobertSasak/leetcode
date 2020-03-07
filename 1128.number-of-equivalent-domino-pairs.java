/*
 * @lc app=leetcode id=1128 lang=java
 *
 * [1128] Number of Equivalent Domino Pairs
 */

// @lc code=start
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int sum = 0;
        for (int[] d : dominoes) {
            int k = Math.max(d[0], d[1]) * 10 + Math.min(d[0], d[1]);
            if (h.containsKey(k)) {
                int f = h.get(k);
                sum += f;
                h.put(k, f + 1);
            } else {
                h.put(k, 1);
            }
        }
        return sum;
    }
}
// @lc code=end

