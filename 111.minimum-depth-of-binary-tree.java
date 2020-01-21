/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            depth++;
            for (int i = 0; i < s; i++) {
                TreeNode n = q.remove();
                if (n.left == null && n.right == null) {
                    return depth;
                }
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
        }
        return depth;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right ==  null) {
            return 1;
        }
        if (root.left != null && root.right != null) {
            return Math.min(
                minDepth(root.left),
                minDepth(root.right)
            ) + 1;
        } 
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        return minDepth(root.left) + 1;
    }
}
// @lc code=end

