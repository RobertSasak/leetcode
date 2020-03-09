/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
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
    public boolean isCousins(TreeNode root, int x, int y) {
        HashMap<Integer, TreeNode> h = new HashMap<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        Integer depthX = null;
        Integer depthY = null;
        int level = 0;
        while (!q.isEmpty()) {
            int nodes = q.size();
            while (nodes > 0) {
                TreeNode n = q.removeFirst();
                if (n.left != null && n.right != null) {
                    if (
                        (n.left.val == x && n.right.val == y) ||
                        (n.left.val == y && n.right.val == x)
                    ) {
                        return false;
                    }
                }
                if (n.val == x) {
                    depthX = level;
                }
                if (n.val == y) {
                    depthY = level;
                }
                if (depthX != null && depthY != null && depthX == depthY) {
                    return true;
                }
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
                nodes--;
            }
            level++;
        }
        return false;
    }
}
// @lc code=end

