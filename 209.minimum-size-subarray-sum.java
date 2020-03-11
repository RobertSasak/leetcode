/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        //  i     j
        // [2,3,1,2,4,3]    
        //  2 5 6 8 12 15

        //  s = 7
        //  sum = 8
        //  l
        //        r
        // [2,3,1,2,4,3]    
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, r = 0, sum = 0, min = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (l < r && sum - nums[l] >= s) {
                sum -= nums[l];
                l++;
            }
            if (sum >= s) {
                if (r - l + 1 < min || min == 0) {
                    min = r - l + 1;
                }
            }
            r++;
        }
        return min;
    }
}
// @lc code=end

