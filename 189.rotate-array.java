/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    // k = 3
    // [5,6,7,1,2,3,4]
    // [1,2,3,4,5,6,7]
    // [7,6,5,4,3,2,1]

    // Reverse method
    public void rotate(int[] nums, int k) {
        int l = nums.length;
        if (l <= 1) {
            return;
        }
        k = k % l;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, l - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, l - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            // swap
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }

    // in place, space O(1), rotating k times, Time O(n*k)
    public void rotateBruteForce(int[] nums, int k) {
        int l = nums.length;
        if (l <= 1) {
            return;
        }
        k = k % l;
        if (k == 0) {
            return;
        }
        while (k > 0) {
            int t = nums[l - 1];
            for (int i = l - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = t;
            k--;
        }
    }

    // loops, O(n)
    public void rotateLoops(int[] nums, int k) {
        int l = nums.length;
        if (l <= 1) {
            return;
        }
        k = k % l;
        if (k == 0) {
            return;
        }
        int c = 0;
        for (int s = 0; c < l; s++) {
            int current = s;
            int prev = nums[current];
            do {
                int j = (current + k) % l;
                int t = nums[j];
                nums[j] = prev;
                prev = t;
                current = j;
                c++;
            } while (s != current);
        }
    }


    // with copy array
    public void rotateCopy(int[] nums, int k) {
        int l = nums.length;
        if (l <= 1) {
            return;
        }
        k = k % l;
        if (k == 0) {
            return;
        }
        int[] c = new int[l];
        for (int i = 0; i < l; i++) {
            c[(i + k) % l] = nums[i];
        }
        for (int i = 0; i < l; i++) {
            nums[i] = c[i];
        }
    }
}
// @lc code=end

