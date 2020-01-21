/*
 * @lc app=leetcode id=1022 lang=java
 *
 * [1022] Sum of Root To Leaf Binary Numbers
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
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int s) {
        if (root == null) {
            return;
        }
        int d = (s << 1) + root.val;
        if (root.left == null && root.right == null) {
            sum += d;
        } else {
            dfs(root.left, d);
            dfs(root.right, d);
        }
    }
}
// @lc code=end

