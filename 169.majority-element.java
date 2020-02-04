/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int l = nums.length;
        if (l == 0) {
            return -1;
        }
        int candidate = nums[0];
        int pro = 1;
        for (int i = 1; i < l; i++) {
            if (nums[i] == candidate) {
                pro++;
            } else {
                pro--;
            }
            if (pro == 0) {
                i++;
                pro = 1;
                candidate = nums[i];
            }
        }
        return candidate;
    }
}
// @lc code=end

