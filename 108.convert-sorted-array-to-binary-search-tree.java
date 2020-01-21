/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // [] => null
    // [5] = > [5]

    // [1,2] => 1
    //         / \
    //        Ø   2
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        if (s == e) {
            return new TreeNode(nums[s]);
        }
        int m = (s + e) / 2;
        TreeNode n = new TreeNode(nums[m]);
        n.left = sortedArrayToBST(nums, s, m - 1);
        n.right = sortedArrayToBST(nums, m + 1, e);
        return n;
    }
}
// @lc code=end

