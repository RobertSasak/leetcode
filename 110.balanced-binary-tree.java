/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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

    // null => 0 => true
    // 3 => 1 => true
    //    4   => 2 => true
    //   /
    //  1


    //         1
    //        / \
    //       2   2
    //      / \ / \
    //     3       3
    //    / \     /
    //   4       4
    public boolean isBalanced(TreeNode root) {
        if (maxDepth(root) == -1) {
            return false;
        }
        return true;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (l == -1 || r == -1) {
            return -1;
        }
        if (Math.abs(l - r) <= 1) {
            return Math.max(l, r) + 1;
        }
        return -1;
    }
}
// @lc code=end

