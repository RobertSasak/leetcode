/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
    // O(N)
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int count = 0;
        int sum = 0;
        h.put(0, 1);
        for (int n : nums) {
            sum += n;
            count += h.getOrDefault(sum - k, 0);
            h.put(sum, h.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // O(N^2)
    public int subarraySumSlow(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }
}
// @lc code=end

