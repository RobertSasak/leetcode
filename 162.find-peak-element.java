/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {

    public int findPeakElement(int[] nums) {
        // return findPeakElementLinear(nums);
        return findPeakElementLog(nums);
    }


    public int findPeakElementLog(int[] nums) {
        return findPeakElementLog(nums, 0, nums.length - 1);
    }

    private int get(int[] nums, int i) {
        if (i >= 0 && i < nums.length) {
            return nums[i];
        }  else {
            return Integer.MIN_VALUE;
        }
    }

    private boolean isPeak(int[] nums, int i) {
        return nums[i] > get(nums, i - 1) && nums[i] > get(nums, i + 1);
    }

    // []
    public int findPeakElementLog(int[] nums, int start, int end) {
        if (start >= end) {
            return start;
        }
        int m = (start + end) / 2;
        if (isPeak(nums, m)) {
            return m;
        }
        if (get(nums, m - 1) > nums[m]) {
            return findPeakElementLog(nums, start, m - 1);
        }
        return findPeakElementLog(nums, m + 1, end);
    }

    public int findPeakElementLinear(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            boolean left = true;
            boolean right = true;
            if (i > 0 && nums[i - 1] >= nums[i]) {
                left = false;
            }
            if (i < l - 1 && nums[i + 1] >= nums[i]) {
                right = false;
            }
            if (left && right) {
                return i;
            }
        }
        return 0;
    }
}
// @lc code=end

