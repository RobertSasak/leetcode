/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(5, (a, b) -> b - a);
        for (int s : stones) {
            q.add(s);
        }

        while (!q.isEmpty()) {
            if (q.size() == 1) {
                return q.poll();
            }
            int a = q.poll();
            int b = q.poll();
            if (a != b) {
                q.add(a - b);
            }
        }
        return 0;
    }
}
// @lc code=end

