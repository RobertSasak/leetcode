/*
 * @lc app=leetcode id=1287 lang=java
 *
 * [1287] Element Appearing More Than 25% In Sorted Array
 */

// @lc code=start
class Solution {
    //O(n)
    public int findSpecialInteger(int[] arr) {
        int q = arr.length / 4;
        for (int i = 0; i < arr.length - q; i++) {
            if (arr[i] == arr[i + q]) {
                return arr[i];
            }
        }
        return -1;
    }
}
// @lc code=end

