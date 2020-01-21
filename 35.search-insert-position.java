/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {

    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public int searchInsert(int[] nums, int target, int i, int j) {
        if (i > j) {
            return i;
        }
        int m = (i + j) / 2;
        if (nums[m] == target) {
            return m;
        }
        if (target < nums[m]) {
            return searchInsert(nums, target, i, m - 1);
        } else {
            return searchInsert(nums, target, m + 1, j);
        }
    }

    /*
    target 9
     i   m     j
         i m   j
         imj
     0 1 2 3   4
    [4,5,6,10,14]
    */
    public int searchInsert3(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (target < nums[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
    /*
        Target 5
        [] => 0
        [4] => 1
        [7] => 0
        [2,4,6] => 2
    */
    public int searchInsert2(int[] nums, int target) {
        int i = 0;
        while (i < nums.length && nums[i] < target) {
            i++;
        }
        return i;
    }
}
// @lc code=end

