/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    // with hash map
    public int singleNumberHash(int[] nums) {
        Set<Integer > h = new HashSet<Integer>();

        for (int n : nums) {
            if (h.contains(n)) {
                h.remove(n);
            } else {
                h.add(n);
            }
        }

        for (int n : h) {
            return n;
        }
        return Integer.MAX_VALUE;
    }

    // using XOR
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int n : nums) {
            x ^= n;
        }
        return x;
    }
}
// @lc code=end

