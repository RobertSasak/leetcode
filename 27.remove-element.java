/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
    /*
    val: 5
    [] => 0

     i
       j
    [3] => 1


       i
     j
    [5] => 0 

             i
         j
    [1,3,5,3] => 2

    */
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
// @lc code=end

