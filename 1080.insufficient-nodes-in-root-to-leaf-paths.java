/*
 * @lc app=leetcode id=1080 lang=java
 *
 * [1080] Insufficient Nodes in Root to Leaf Paths
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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        if (shouldDelete(root, limit, 0)) {
            return null;
        }
        return root;
    }

    boolean shouldDelete(TreeNode root, int limit, int sum) {
        if (root == null) {
            return true;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum < limit;
        }
        boolean left = shouldDelete(root.left, limit, sum);
        boolean right = shouldDelete(root.right, limit, sum);
        if (left) {
            root.left = null;
        }
        if (right) {
            root.right = null;
        }
        return left && right;
    }
}
// @lc code=end

