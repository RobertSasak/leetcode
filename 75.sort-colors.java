/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        // [0 1 0 1 1 2 2 2]
        int s = 0;
        int e = nums.length - 1;
        int i = 0;
        while (s < e && i <= e) {
            if (nums[i] == 0) {
                swap(nums, s, i);
                s++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, e, i);
                e--;
            } else {
                i++;
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void sortColorsTwoPasses(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int c : nums) {
            if (c == 0) {
                red++;
            } else if (c == 1) {
                white++;
            } else {
                blue++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (red > 0) {
                nums[i] = 0;
                red--;
            } else if (white > 0) {
                nums[i] = 1;
                white--;
            } else {
                nums[i] = 2;
            }
        }
    }
}
// @lc code=end

