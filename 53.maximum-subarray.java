/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int crossing(int[] nums, int s, int m, int e) {
        int sum = 0;
        int maxLeft = Integer.MIN_VALUE;
        for (int i = m; i >= s; i--) {
            sum += nums[i];
            maxLeft = Math.max(maxLeft, sum);
        }

        int maxRight = Integer.MIN_VALUE;
        sum = 0;
        for (int i = m + 1; i <= e; i++) {
            sum += nums[i];
            maxRight = Math.max(maxRight, sum);
        }
        return maxLeft + maxRight;
    }
    //             m
    //        m
    //     m
    //   m
    // [-2,1,-3,4,-1,2,1,-5,4]
    // 
    public int maxSubArray(int[] nums, int s, int e) {
        if (s == e) {
            return nums[s];
        }
        int m = (s + e) / 2;
        int l = maxSubArray(nums, s, m);
        int r = maxSubArray(nums, m + 1, e);
        return Math.max(
            Math.max(l, r),
            crossing(nums, s, m, e)
        );
    }

    public int maxSubArray4(int[] nums) {
        int l = nums.length;
        if (l == 0) {
            return -1;
            //throw new InvalidInputException();
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < l; i++) {
            sum = Math.max(nums[i], nums[i] + sum);
            max = Math.max(max, sum);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        int l = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < l; i++) {
            int sum = 0;
            for (int j = i; j < l; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int l = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i=0; i < l; i++) {
            for (int j = i; j < l; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
// @lc code=end

