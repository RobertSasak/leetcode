/*
 * @lc app=leetcode id=1027 lang=java
 *
 * [1027] Longest Arithmetic Sequence
 */

// @lc code=start
class Solution {
    public int longestArithSeqLength(int[] A) {
        int l = A.length;
        if (l == 0) return 0;
        if (l == 1) return 1;
        
        HashMap<Integer, HashMap<Integer, Integer>> dp = new HashMap<>();

        int max = 2;
        dp.put(0, new HashMap<>());
        for (int i = 1; i < l; i++) {
            dp.put(i, new HashMap<>());
            for (int j = 0; j < i; j++) {
                int d = A[i] - A[j];
                int c = 1 + dp.get(j).getOrDefault(d, 1);
                max = Math.max(max, c);
                dp.get(i).put(d, c);
            }

        }
        return max;
    }
}
// @lc code=end

